package net.therap;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/12/14
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String args[]) throws IOException {


        String rawData = "id=10";
        String type = "application/x-www-form-urlencoded";
        String encodedData = URLEncoder.encode(rawData);
        URL u = new URL("http://www.example.com/page.php");
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty( "Content-Type", type );
        conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
        OutputStream os = conn.getOutputStream();
        os.write(encodedData.getBytes());


    }
}
