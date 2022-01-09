package com.pb.chesnokov.hw14;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int port = 4321;
        String serverURL = "127.0.0.1";

        System.out.printf("Соединение с сервером %s:%d\n", serverURL, port);
        try {
            Socket server = new Socket(serverURL, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            System.out.print("Введите строку: ");
            String s = new Scanner(System.in).nextLine();
            out.println(s);
            System.out.println(in.readLine());
            in.close();
            server.close();
        }
        catch (Exception ex) {
            System.out.println("Запусти сперва сервер!");
        }
    }
}
