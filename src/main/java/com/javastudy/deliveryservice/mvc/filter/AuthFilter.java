package com.javastudy.deliveryservice.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tanya
 */

//Dont forgetg uncomment annotation  when you need this filter for work
//@WebFilter(filterName = "AuthFilter", urlPatterns = {"/"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

            HttpSession session = req.getSession();

            Integer clientID = (Integer) session.getAttribute("clientID");

            boolean isAuth = false;
            if (clientID != null && clientID > 0) {
                isAuth = true;
            }

            if (isAuth) {
                chain.doFilter(request, response);   
            } else {
                resp.sendRedirect("./auth");
            }

    }

    @Override
    public void destroy() {

    }

}
