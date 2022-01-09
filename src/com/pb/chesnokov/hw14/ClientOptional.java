package com.pb.chesnokov.hw14;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientOptional {
    static class SomeClient {
        private Socket socket;
        private BufferedReader inConsole;
        private BufferedReader inServer;
        private PrintWriter outServer;
        private String nickname;

        public SomeClient (String addr, int port) {
            try {
                this.socket = new Socket(addr, port);
                inConsole = new BufferedReader(new InputStreamReader(System.in));
                inServer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                outServer = new PrintWriter(this.socket.getOutputStream(), true);
                System.out.print("Введите имя пользователя: ");
                this.nickname = inConsole.readLine();
                outServer.println(this.nickname);
                new ServerOutput().start();
                new ServerInput().start();
            } catch (Exception ex) {
                this.downClient();
            }

        }

        private void downClient() {
            try {
                if (!socket.isClosed()) {
                    socket.close();
                    inConsole.close();
                    inServer.close();
                    outServer.close();
                }
            } catch (IOException ignored) {}
        }

        private class ServerInput extends Thread {
            @Override
            public void run() {

                String str;
                try {
                    while (true) {
                        str = inServer.readLine();
                        if (("exit").equalsIgnoreCase(str)) {
                            System.out.println("Вы покинули чат.");
                            break;
                        }
                        System.out.println("\r" + str);
                        System.out.print("\rВведите сообщение: ");
                    }
                } catch (Exception ex) {}
            }
        }

        public class ServerOutput extends Thread {

            @Override
            public void run() {
                Date time;
                SimpleDateFormat dt;
                String str;
                while (true) {
                    String userMsg;
                    try {
                        time = new Date();
                        dt = new SimpleDateFormat("HH:mm:ss");
                        str = dt.format(time);
                        System.out.print("\rВведите сообщение: ");
                        userMsg = inConsole.readLine();
                        if ("exit".equalsIgnoreCase(userMsg)) {
                            outServer.println("exit");
                            break;
                        } else {
                            outServer.println("(" + str + ") " + nickname + ": " + userMsg);
                        }
                    } catch (Exception ex) {}
                }
            }
        }

    }

    public static void main(String[] args) {
        SomeClient someClient = new SomeClient("127.0.0.1", 4321);
    }
}
