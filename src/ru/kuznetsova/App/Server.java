package ru.kuznetsova.App;

import ru.kuznetsova.App.common.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{
    private int port;

    ServerSocket serverSocket = null;
    Socket socket = null;
    ArrayList<Client> clients;
    Message message;

    public Server(int port){
        try{
            serverSocket = new ServerSocket(port);
            clients = new ArrayList<>();
            this.start();
        } catch (IOException e){
            System.out.println("Ошибка сервера");
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            socket = serverSocket.accept();
            Client client = new Client("127.0.0.1", 123);
            clients.add(client);
            client.start();
            System.out.println("Подключено "+ String.valueOf(clients.size()));
        }catch (Exception e){
            System.out.println("Ошибка подключения");
            e.printStackTrace();
        }
    }


}
