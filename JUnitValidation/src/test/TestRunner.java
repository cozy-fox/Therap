package test;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/13/14
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitTestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Was Successful? : "+result.wasSuccessful());
    }
}