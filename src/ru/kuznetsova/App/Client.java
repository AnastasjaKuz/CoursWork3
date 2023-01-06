package ru.kuznetsova.App;

import ru.kuznetsova.App.common.Connection;
import ru.kuznetsova.App.common.Message;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private String host;
    private int port;
    private Scanner scanner;
    private Message message;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start(){
        System.out.println("Введите имя отправителя");
        String name = scanner.nextLine();

        while (true){
            System.out.println("Введите сообщение");
            String text = scanner.nextLine();

            sendAndPrintMessage(new Message(name, text));
            if("/exit".equals(message)) break;
        }
    }

    private void sendAndPrintMessage(Message message){
        try(Connection connection = new Connection(new Socket(host, port))) {
        } catch (UnknownHostException e) {
            System.out.println("Ошибка соединения. Проверье хост");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ощибка отправления");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Нет подключения");
            e.printStackTrace();
        }
    }


}
