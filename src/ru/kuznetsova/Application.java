package ru.kuznetsova;

import ru.kuznetsova.App.Client;
import ru.kuznetsova.App.Server;

public class Application {
    public static void main(String[] args) {
        new Server(123).start();
        new Client("127.0.0.1", 123).start();
    }
}
