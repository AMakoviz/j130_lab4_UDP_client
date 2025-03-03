package org.example;

import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SocketException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите хост сервера");
        String host = scanner.nextLine().trim();
        System.out.println("Введите порт сервера");
        String port = scanner.nextLine().trim();
        AppProperties properties = new AppProperties(host, port);
        MessageExchangeSender sender = new MessageExchangeSender();
        System.out.println("Введите сообщение");
        String message = scanner.nextLine();
        (new Thread(() -> {
            try {
                sender.send(message, properties);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        })).start();

    }
}