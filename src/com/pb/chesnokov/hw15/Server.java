package com.pb.chesnokov.hw15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static int port = 4321;
    public static List<SomeServer> serverList = new ArrayList<>();


    static class SomeServer extends Thread {
        private Socket socket;
        private BufferedReader in;
        private BufferedWriter out;
        private String nickname;

        public SomeServer(Socket socket) throws IOException {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            start();
        }

        @Override
        public void run() {
            String str;

            try {
                str = in.readLine();
                try {
                    out.write("Добро пожаловать " + str + "\n");
                    out.flush();
                    System.out.println(str + " присоединился к чату");
                    for (SomeServer ss: Server.serverList) {
                        if(ss.equals(this))
                            continue;
                        ss.send(str + " присоединился к чату");
                    }
                    nickname = str;
                } catch (Exception ex) {}
                try {
                    while (true) {
                        str = in.readLine();
                        System.out.println("Echo: " + str);
                        if ("exit".equalsIgnoreCase(str)) {
                            out.write("exit");
                            out.flush();
                            System.out.println(nickname + " покинул чат");
                            for (SomeServer ss: Server.serverList) {
                                if(ss.equals(this))
                                    continue;
                                ss.send(nickname + " покинул чат");
                            }
                            this.downServer();
                            break;
                        }
                        for (SomeServer ss: Server.serverList) {
                            ss.send(str);
                        }
                    }
                } catch (Exception ex) {}

            } catch (Exception ex) {
                this.downServer();
            }
        }

        private void send(String str) {
            try {
                out.write(str + "\n");
                out.flush();
            } catch (IOException ex) {}
        }

        private void downServer() {
            try {
                if(!socket.isClosed()) {
                    socket.close();
                    in.close();
                    out.close();
                    for (SomeServer ss : Server.serverList) {
                        if(ss.equals(this))
                            ss.interrupt();
                        Server.serverList.remove(this);
                    }
                }
            } catch (IOException ex) {}
        }
    }

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту : " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            serverList.add(new SomeServer(clientSocket));
        }
    }
}
