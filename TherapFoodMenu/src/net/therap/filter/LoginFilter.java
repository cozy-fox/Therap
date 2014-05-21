package net.therap.filter;

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
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI();

        if ((session == null || session.getAttribute("authenticatedUser") == null) && (requestedUri.contains("home") || requestedUri.contains("logout") || requestedUri.contains("index"))) {
            ((HttpServletResponse) servletResponse).sendRedirect("/login");
        } else if (session != null && session.getAttribute("authenticatedUser") != null && (requestedUri.contains("login") || requestedUri.contains("register"))) {
            ((HttpServletResponse) servletResponse).sendRedirect("/home");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
