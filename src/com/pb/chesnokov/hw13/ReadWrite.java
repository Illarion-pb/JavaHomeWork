package com.pb.chesnokov.hw13;

import java.util.ArrayList;
import java.util.List;

public class ReadWrite {
    private final int MAX_BUFFER_SIZE = 5;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private List<Integer> buffer = new ArrayList<>();

    public void writeBuf() {
        int  value = (int) (Math.random() * 100);
        while (true) {
            synchronized (this) {
                try {
                    while (buffer.size() >= MAX_BUFFER_SIZE) {
                        wait();
                    }

                    value = (int) (Math.random() * 100);
                    System.out.println(ANSI_GREEN + "Write to buffer: " + value);
                    buffer.add(value);
                    System.out.println(ANSI_GREEN + "Buffer (" + buffer.size() + "): " + buffer.toString());
                    System.out.println(ANSI_RESET + "-----------------------------");
                    notify();
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex) {}
            }
        }
    }

    public void readBuf() {
        while (true) {
            synchronized (this) {
                try {
                    while (buffer.size() == 0) {
                        wait();
                    }

                    int value = buffer.remove(0);
                    System.out.println(ANSI_BLUE + "Read from buffer: " + value);
                    System.out.println(ANSI_BLUE + "Buffer(" + buffer.size() + "): " + buffer.toString());
                    System.out.println(ANSI_RESET + "-----------------------------");
                    notify();
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex) {}
            }
        }
    }
}
