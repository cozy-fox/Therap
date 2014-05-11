package logparser.io;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/6/14
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public interface LogFileIO {
    public String logInput(String locator);

    public void logOutput(String destination);
}
