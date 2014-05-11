package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        ServerSocket welcomeSocket = new ServerSocket(8080);
        while (true) {
            System.out.println("Waiting...");
            Socket cSock = welcomeSocket.accept();
            System.out.println("Accepted connection : " + cSock);


            Server a = new Server(cSock);
            a.start();
        }

        /*SingleThreadedServer singleThreadedServer = new SingleThreadedServer(4545);
        singleThreadedServer.run();
        */

    }

}


