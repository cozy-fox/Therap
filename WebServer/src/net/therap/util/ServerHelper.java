package net.therap.util;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/7/14
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class ServerHelper {

    private static final String BASEPATH  = System.getProperty("user.home")+"/Drive/serverSocket/";
    private static final String INDEXFILE = "index.html";

    public static byte[] getFileContent(String requestURL){

        File localFile          = null;
        byte [] myByteArray     = null;
        FileInputStream fis     = null;
        BufferedInputStream bis = null;

        if (requestURL.length() > 1) {
            localFile = new File(requestURL.trim());
        } else {
            localFile = new File(BASEPATH + INDEXFILE);
        }

        myByteArray   = new byte [(int)localFile.length()];
        try {
            fis       = new FileInputStream(localFile);
            bis       = new BufferedInputStream(fis);
            bis.read(myByteArray,0,myByteArray.length);
        } catch (IOException e) {
            String errorString = "<h1>404! File Not Found</h1>";
            myByteArray        = errorString.getBytes(Charset.forName("UTF-8"));
            return myByteArray;
        }

        return myByteArray;
    }

    public static String constructHttpHeader(int returnCode, int fileType) {

        String s = "HTTP/1.0 ";
        switch (returnCode) {
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

        s = s + "\r\n";
        s = s + "Connection: close\r\n"; //we can't handle persistent connections
        s = s + "Server: SimpleHTTPtutorial v0\r\n"; //server name

        //Construct the right Content-Type for the header.
        //This is so the browser knows what to do with the
        //file, you may know the browser dosen't look on the file
        //extension, it is the servers job to let the browser know
        //what kind of file is being transmitted. You may have experienced
        //if the server is miss configured it may result in
        //pictures displayed as text!
        switch (fileType) {
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

        s = s + "\r\n"; //this marks the end of the httpheader
        return s;
    }

    public static String getRequestMethod(String request) {
        String[] tmpStringArray = request.split("([\\s\t])+");
        return tmpStringArray[0];
    }

    public static String getRequestURL(String request) {
        String[] tmpStringArray = request.split("([\\s\t])+");
        return tmpStringArray[1];
    }

    public static byte[] badRequestHandler() {
        String errorString = "Bad Request";
        return errorString.getBytes(Charset.forName("UTF-8"));
    }

    public void writeToClient(DataOutputStream toClient, byte[] mBytesArray, int status, int type) {
        try {
            toClient.writeBytes(ServerHelper.constructHttpHeader(status, type));
            toClient.write(mBytesArray, 0, mBytesArray.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (toClient != null) {
                try {
                    toClient.flush();
                    toClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Sending...");

    }

    public byte[] postMethodHandler(BufferedReader inFromClient) throws IOException {
        String lineString = "";
        StringBuilder postValues = null;
        Integer contentLength = null;

        while ((lineString = inFromClient.readLine()) != null) {
            String tmpContentLength = "Content-Length: ";
            System.out.println(lineString);
            if (lineString.length()<1) break;

            if (lineString.startsWith(tmpContentLength)) {
                contentLength = Integer.parseInt(lineString.substring(tmpContentLength.length(), lineString.length()));
            }
        }
        System.out.println("out of while");

        postValues = new StringBuilder();
        while (contentLength > 0) {
            postValues.append((char) inFromClient.read());
            contentLength--;
        }

        StringBuilder postParsed = postParser(postValues);
        String tmpPostParsed = postParsed.toString();
        return tmpPostParsed.getBytes(Charset.forName("UTF-8"));
    }

    private StringBuilder postParser(StringBuilder postValue) {
        String postValueString = postValue.toString();
        String postParts[] = postValueString.split("&");
        StringBuilder retStr = new StringBuilder();

        retStr.append("<h2>POST Values</h2><table>");
        for (String part : postParts) {
            String tmpParts[] = part.split("=");
            String key = tmpParts[0];
            String value = tmpParts[1];

            retStr.append("<tr><td><b>").append(key).append("</b></td><td>").append(value).append("</td></tr>");
        }
        retStr.append("</table>");
        return retStr;
    }
}
