package com.pb.chesnokov.hw15;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    static class SomeClient {
        private Socket socket;
        private BufferedReader inConsole;
        private BufferedReader inServer;
        private PrintWriter outServer;
        private String nickname;

        private MainFrame mf;

        private JScrollPane messagesScroll;
        private JTextArea messages;
        private JPanel messagePanel;
        private JTextField message;
        private JButton sendButton;

        private class MainFrame extends JFrame {
            public MainFrame() {
                this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                this.setResizable(false);
                this.setLayout(new BorderLayout());
                this.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e)
                    {
                        outServer.println("exit");
                    }
                });

                messages = new JTextArea();
                messages.setRows(20);
                messages.setEditable(false);
                DefaultCaret caret = (DefaultCaret)messages.getCaret();
                caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                messagesScroll = new JScrollPane(messages);
                messagePanel = new JPanel();
                messagePanel.setLayout(new BorderLayout());
                message = new JTextField();
                message.addActionListener(new SendButtonListener());
                message.setPreferredSize(new Dimension(400, 24));
                sendButton = new JButton(">>");
                sendButton.addActionListener(new SendButtonListener());
                messagePanel.add(message, BorderLayout.WEST);
                messagePanel.add(sendButton, BorderLayout.EAST);

                this.add(messagesScroll, BorderLayout.NORTH);
                this.add(messagePanel, BorderLayout.SOUTH);

                this.pack();
                message.requestFocus();
                this.setVisible(true);
            }

            private class SendButtonListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Date time;
                    SimpleDateFormat dt;
                    String str;

                    time = new Date();
                    dt = new SimpleDateFormat("HH:mm:ss");
                    str = dt.format(time);

                    outServer.println("(" + str + ") " + nickname + ": " + message.getText());
                    message.setText("");
                    message.requestFocus();
                }
            }
        }

        public SomeClient (String addr, int port) {
            try {
                this.socket = new Socket(addr, port);
                inConsole = new BufferedReader(new InputStreamReader(System.in));
                inServer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                outServer = new PrintWriter(this.socket.getOutputStream(), true);
                nickname = JOptionPane.showInputDialog("Введите логин:");
                if (this.nickname == null || this.nickname.isEmpty())
                    System.exit(0);
                outServer.println(this.nickname);
                mf = new MainFrame();
                mf.setTitle("Cool chat (nickname: " + this.nickname + ")");
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
                        messages.append(str + "\n");
                    }
                } catch (Exception ex) {}
            }
        }
    }

    public static void main(String[] args) {
        SomeClient someClient = new SomeClient("127.0.0.1", 4321);
    }
}
