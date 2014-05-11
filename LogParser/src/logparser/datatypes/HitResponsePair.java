package logparser.datatypes;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/7/14
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class HitResponsePair {

    int numOfHits       = 0;
    int responseTime    = 0;

    public HitResponsePair(int i, int i1) {
        this.numOfHits      = i;
        this.responseTime   = i1;
    }

    public int getNumOfHits(){
        return numOfHits;
    }

    public int getResponseTime(){
        return responseTime;
    }
}
