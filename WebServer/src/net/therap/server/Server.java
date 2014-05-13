package net.therap.server;


/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/7/14
 * Time: 9:33 AM
 * To change this template use File | Settings | File Templates.
 */

import net.therap.util.ServerHelper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Server extends Thread {

    Socket cSock;

    public Server(Socket cSock) {   //constructor
        this.cSock = cSock;
    }

    public void run() {
        DataOutputStream toClient = null;
        BufferedReader fromClient = null;
        String request;
        try {

            fromClient = new BufferedReader(new InputStreamReader(cSock.getInputStream()));
            toClient = new DataOutputStream(cSock.getOutputStream());
            request = fromClient.readLine();
            System.out.println("Received: " + request);

            String requestMethod = ServerHelper.getRequestMethod(request);
            String requestURL = ServerHelper.getRequestURL(request);

            byte[] mBytesArray = null;
            if (requestMethod.equals("GET")) {
                mBytesArray = ServerHelper.getFileContent(requestURL.trim());

                String mBytesString = new String(mBytesArray,"UTF-8");
                if (mBytesString.startsWith("404"))
                    new ServerHelper().writeToClient(toClient, mBytesArray, 404, 5);
                else
                    new ServerHelper().writeToClient(toClient, mBytesArray, 200, 5);
            } else if (requestMethod.equals("POST")) {
                mBytesArray = new ServerHelper().postMethodHandler(fromClient);
                new ServerHelper().writeToClient(toClient, mBytesArray, 200, 5);
            } else {
                mBytesArray = ServerHelper.badRequestHandler();
                new ServerHelper().writeToClient(toClient, mBytesArray, 400, 5);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
