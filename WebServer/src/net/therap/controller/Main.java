package net.therap.controller;

import net.therap.server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);


            ExecutorService executor = Executors.newFixedThreadPool(20);
            while(true) {
                System.out.println("Waiting for connection ...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection arrived ...");

                Thread thread = new Server(clientSocket);
                executor.execute(thread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
