/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/18/14
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestScope {

    public static void main(String args[]) {
        TestScope obj = new DerivedTestScope();
        obj.function();
    }
    protected void function(){
        System.out.println("function");}
}

class DerivedTestScope extends TestScope{
    @Override
    protected void function() {
        System.out.println("derived function");
    }
}
