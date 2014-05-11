package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: rashedul.hasan
 * Date: 5/5/14
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server extends Thread {

    Socket cSock;

    Server(Socket cSock){   //constructor
        this.cSock = cSock;
    }

    public void run(){
        try{
            String request;
            Scanner inFromClient = new Scanner(cSock.getInputStream());
            DataOutputStream outToClient = new DataOutputStream(cSock.getOutputStream());
            request = inFromClient.nextLine();
            System.out.println("Received: "+request);


            //trimming URL to extract file name
            String reqMeth = request.substring(0, 3);
            String reqURL = request.substring(4, (request.lastIndexOf("HTTP/1.1")));
            String reqProto = request.substring(request.indexOf("HTTP/1.1"));
            System.out.println("Request Method:\t" +reqMeth +"\nRequest URL:\t" +reqURL+ "\nRequest Protocol: " +reqProto);

            //passing file name to open
            File localFile = new File(reqURL.trim());
            byte [] mybytearray  = new byte [(int)localFile.length()];
            FileInputStream fis = new FileInputStream(localFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(mybytearray,0,mybytearray.length);

            //sending file to stream
            outToClient.writeBytes(construct_http_header(200, 5));
            System.out.println("Sending...");
            outToClient.write(mybytearray,0,mybytearray.length);
            outToClient.flush();
            outToClient.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }


    private String construct_http_header(int return_code, int file_type) {

        String s = "HTTP/1.0 ";
        //you probably have seen these if you have been surfing the web a while
        switch (return_code) {
            case 200:
                s = s + "200 OK";
                break;
            case 400:
                s = s + "400 Bad Request";
                break;
            case 403:
                s = s + "403 Forbidden";
                break;
            case 404:
                s = s + "404 Not Found";
                break;
            case 500:
                s = s + "500 Internal Server Error";
                break;
            case 501:
                s = s + "501 Not Implemented";
                break;
        }

        s = s + "\r\n"; //other header fields,
        s = s + "Connection: close\r\n"; //we can't handle persistent connections
        s = s + "Server: SimpleHTTPtutorial v0\r\n"; //server name

        //Construct the right Content-Type for the header.
        //This is so the browser knows what to do with the
        //file, you may know the browser dosen't look on the file
        //extension, it is the servers job to let the browser know
        //what kind of file is being transmitted. You may have experienced
        //if the server is miss configured it may result in
        //pictures displayed as text!
        switch (file_type) {
            //plenty of types for you to fill in
            case 0:
                break;
            case 1:
                s = s + "Content-Type: image/jpeg\r\n";
                break;
            case 2:
                s = s + "Content-Type: image/gif\r\n";
            case 3:
                s = s + "Content-Type: application/x-zip-compressed\r\n";
            default:
                s = s + "Content-Type: text/html\r\n";
                break;
        }

        ////so on and so on......
        s = s + "\r\n"; //this marks the end of the httpheader
        //and the start of the body
        //ok return our newly created header!
        return s;
    }
}
