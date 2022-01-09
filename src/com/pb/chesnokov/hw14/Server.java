package com.pb.chesnokov.hw14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        int port = 4321;
        ServerSocket server = null;
        ExecutorService threadPool = null;

        try {
            server = new ServerSocket(port);
            threadPool = Executors.newFixedThreadPool(10);
            System.out.println("Сервер запущен.");
        }
        catch (Exception ex) {
            System.out.println("Ошибка связывания с портом: " + port);
            System.exit(-1);
        }

        while (true) {
            try {
                Socket client = server.accept();
                threadPool.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Клиент подключился!");
                        try {
                            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                            String s = in.readLine();
                            Date time = new Date();
                            SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss");
                            out.write(dt.format(time) + ": " + s);
                            out.flush();
                            System.out.println("Закрыаем соединение с клиентом.");
                            in.close();
                            out.close();
                            client.close();
                        }
                        catch (Exception ex) {}
                    }
                });
            }
            catch (Exception ex) {}

        }


    }
}
