package net.therap.filter;

import net.therap.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
@WebFilter("*")
public class LoginFilter implements Filter {

    private final String[] adminUriPatterns = {"admin", "mealAdd", "prev"};
    private final String[] regularUriPatterns = {"home", "logout", "index"};

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI();

        if (!isSessionActive(session) && (isRequestedUriForAdmin(requestedUri) || isRequestedUriForOther(requestedUri)) ) {

            ((HttpServletResponse) servletResponse).sendRedirect("/login");

        } else if ( isSessionActive(session) && requestedUri.contains("login")) {

            ((HttpServletResponse) servletResponse).sendRedirect("/home");

        } else if ( isRequestedUriForAdmin(requestedUri) && !getUserTypeFromSession(session).equals("admin")) {

            ((HttpServletResponse) servletResponse).sendRedirect("/home");

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
//        filterChain.doFilter(servletRequest, servletResponse);
//
//        /*if ( && (requestedUri.contains("home") || requestedUri.contains("logout") || requestedUri.contains("index") || requestedUri.contains("prev") || requestedUri.contains("mealAdd"))) {
//            ((HttpServletResponse) servletResponse).sendRedirect("/login");
//        }/* else if((session != null && session.getAttribute("authenticatedUser") != null) && !userType.equals("admin") && (requestedUri.contains("mealAdd") || requestedUri.contains("admin") ) ) {
//            ((HttpServletResponse) servletResponse).sendRedirect("/home");
//        } else if (session != null && session.getAttribute("authenticatedUser") != null && (requestedUri.contains("login"))) {
//            ((HttpServletResponse) servletResponse).sendRedirect("/home");
//        } else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }*/
}

    private boolean isRequestedUriForOther(String requestedUri) {
        for(String uriPattern: regularUriPatterns) {
            if (requestedUri.contains(uriPattern)) {
                return true;
            }
        }
        System.out.println("Not for regular");
        return false;
    }

    private boolean isRequestedUriForAdmin(String requestedUri) {
        for(String uriPattern: adminUriPatterns) {
            if (requestedUri.contains(uriPattern)) {
                return true;
            }
        }
        System.out.println("Not for admin");
        return false;
    }

    private boolean isSessionActive(HttpSession session) {
        System.out.println((session != null && session.getAttribute("authenticatedUser") != null));
        return session != null && session.getAttribute("authenticatedUser") != null;
    }

    private String getUserTypeFromSession(HttpSession session) {
        if (isSessionActive(session)) {
            User authenticatedUser = (User)session.getAttribute("authenticatedUser");
            return authenticatedUser.getUserType();
        }
        return "";
    }

    public void destroy() {

    }
}
