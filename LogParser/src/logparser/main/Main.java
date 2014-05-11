package logparser.main;


import logparser.controller.MyParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    private static String searchCondition   = null;
    private static String fileName          = null;
    private static String searchUri         = null;

    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream in  = null;

        try {
            in = new FileInputStream("config.properties");

            prop.load(in);

            searchUri        = prop.getProperty("searchuri");
            fileName         = prop.getProperty("filepath");
            searchCondition  = prop.getProperty("searchcondition");

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
        }
        if (in != null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }


        MyParser myParseVar = new MyParser();

        //System.out.print("Enter the URI: ");
        //Scanner sc = new Scanner(System.in);
        //String searchUri = sc.nextLine();

        //System.out.print("Enter File Path: ");
        //Scanner sc2 = new Scanner(System.in);
        //String fileName = sc2.nextLine();

        String line = "";
        while ( (line = myParseVar.logInput(fileName)) != null){
            myParseVar.parseLog(searchUri, searchCondition, line);
        }

        myParseVar.logOutput("console");
    }
}
