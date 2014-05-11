package view;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/27/14
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class InputOutput implements IOInterface {
    @Override
    public String input(String locator) {

        if (locator.equals("console")){
            return fromConsole();
        } else if ( locator.contains(".txt")){
            return fromFile(locator);
        }


        return "";
    }

    @Override
    public void output(String destination, ArrayList<ArrayList<String>> out) {
        if (destination.equals("console")){
            this.toConsole((out));
        }
    }


    public String fromFile(String filePath){
        BufferedReader br = null;
        String returnValue="";
        try {
            br = new BufferedReader(new FileReader(new File(filePath)));
            String line;
            while ((line = br.readLine()) != null) {
                returnValue = returnValue+line+";";
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br!=null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return returnValue;
    }


    public String fromConsole() {
        System.out.println(".:: Enter Choice:");
        System.out.println("\t1) Show all accounts.");
        System.out.println("\t2) Show selected accounts.");

        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void toConsole(ArrayList<ArrayList<String>> result) {

        int columns = 0;
        /*try {
            columns = rs.getMetaData().getColumnCount();
            for (int i=1; i<=columns; i++){
                System.out.print(" \t" + rs.getMetaData().getColumnLabel(i));
            }
            System.out.println("");

            StringBuilder message = new StringBuilder();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    message.append(" \t"+rs.getString(i));
                }
                message.append("\n");
            }
            System.out.println(message);

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        int arrayListSize = result.size();
        StringBuilder message = new StringBuilder();
        for(int i = 0; i < arrayListSize; i++){
            int rowSize = result.get(i).size();
            for (int j = 0; j < rowSize; j++){
                message.append(" \t\t"+result.get(i).get(j).toString());
            }
            message.append("\n");
        }
        System.out.print(message);
    }
}
