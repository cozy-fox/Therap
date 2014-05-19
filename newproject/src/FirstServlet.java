import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/18/14
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class FirstServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet Called");
        PrintWriter out = response.getWriter();
        Date today = new Date();
        out.println(
                "<html><body>"+
                "<h1>"+today+
                "</body></html>"
        );

    }
}
