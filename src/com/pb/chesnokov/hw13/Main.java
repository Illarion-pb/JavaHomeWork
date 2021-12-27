package com.pb.chesnokov.hw13;

public class Main {
    public static void main(String[] args) {
        final ReadWrite rw = new ReadWrite();

        Thread t1 = new Thread(() -> {
            rw.writeBuf();
        });

        Thread t2 = new Thread(() -> {
            rw.readBuf();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException ex) {};

    }
}
