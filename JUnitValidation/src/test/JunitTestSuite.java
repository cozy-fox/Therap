package test;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/13/14
 * Time: 2:32 PM
 * To change this template use File | Settings | File Templates.
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        PersonTest.class,
        PersonTest_2.class
})
public class JunitTestSuite {
}