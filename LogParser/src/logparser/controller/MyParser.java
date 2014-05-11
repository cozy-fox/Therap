package logparser.controller;

import logparser.datatypes.HitResponsePair;
import logparser.io.LogFileIO;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/6/14
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyParser implements LogFileIO {

    Map<String, HitResponsePair> fullMap = new TreeMap<String, HitResponsePair>();

    static InputStream inFile    = null;
    static BufferedReader reader = null;

    public String logInput(String fileName) {
        try {
            if (inFile == null) {
                inFile = new BufferedInputStream(new FileInputStream(fileName));
                reader = new BufferedReader(new InputStreamReader(inFile));
            }
            String str = "";

            if ((str   = reader.readLine()) != null) {
                return str;
            } else {
                inFile.close();
                return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;

    }

    public void parseLog(String uri, String condition, String inLine) {

        if (!inLine.contains(condition)) {
            return;
        } else {
            if (inLine.contains(uri)) {

                String[] parts   = inLine.split(" ");
                String timeStamp = parts[1];

                /**
                 * Get the index of the arrays
                 */
                String[] timeTmp = timeStamp.split(":");
                String indexString = timeTmp[0];
                String indexForMap = indexString + ":00:00";

                /**
                 * Parse the response time
                 */
                int responseTime        = 0;
                String regularEx        = "\\D+";
                String responseTimeStr  = parts[parts.length - 1];
                String timeSplitStr[]   = responseTimeStr.split(regularEx);

                for (String sss : timeSplitStr){
                    if (sss.matches("\\d+")) {
                        responseTime = Integer.parseInt(sss);
                        break;
                    }
                }

                if (fullMap.containsKey(indexForMap)) {
                    fullMap.put(indexForMap, new HitResponsePair((fullMap.get(indexForMap).getNumOfHits()+1),(fullMap.get(indexForMap).getResponseTime()+responseTime)));
                } else {
                    fullMap.put(indexForMap, new HitResponsePair(1, 0));
                }

            }
        }
    }

    public void logOutput(String dest) {
        if (dest.equals("console")) {
            consoleOutput();
        }
    }

    private void consoleOutput(){
        for (String key : fullMap.keySet()) {
            String hoursValue       = key;
            Integer occuranceCount  = fullMap.get(key).getNumOfHits();
            Integer responseTime    = fullMap.get(key).getResponseTime();

            String occStr           = String.format("%9d", occuranceCount);
            String resStr           = String.format("%9d", responseTime);

            System.out.println("[" + key + "]\t" + occStr + " hits\t" + resStr + " ms (response time)");
        }
    }
}
