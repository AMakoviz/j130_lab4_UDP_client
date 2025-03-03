package org.example;

import java.io.IOException;
import java.net.*;

public class MessageExchangeSender {
    private DatagramSocket ds;
    private DatagramPacket dp;
    private byte[] data;
    public static int MAX_LENGTH = 65000;

    public MessageExchangeSender () throws SocketException {
        ds = new DatagramSocket ();
        data = new byte[MAX_LENGTH];
        dp = new DatagramPacket (data, data.length);
    }
    public void send (String message, AppProperties properties) throws UnknownHostException, IOException {

        dp.setData(message.getBytes());
        dp.setLength(message.getBytes().length);
        dp.setAddress(InetAddress.getByName(properties.getHost()));
        dp.setPort(properties.getPort());
        ds.send(dp);

        dp.setData (data);
        ds.receive(dp);
        String response = new String (dp.getData(), 0, dp.getLength());
        System.out.println("Сообщение от сервера: " + response);

        }
    }


