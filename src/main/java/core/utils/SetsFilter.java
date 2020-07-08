package core.utils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.model.User;

/**
 * Servlet Filter implementation class SetsFilter
 */
//@WebFilter(filterName="SetsFilter" , urlPatterns="/*")
public class SetsFilter implements Filter {


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
    	String chemin = req.getRequestURI().substring(req.getContextPath().length());
    	User userSession = (User) req.getSession().getAttribute(User.SESSION_ATTRIBUTE);
    	Pattern p = Pattern.compile("(login)|(css)");
		Matcher m = p.matcher(chemin);
        try {
        	if (m.find() == false) {
        		 if (userSession != null) {
                   	chain.doFilter(request, response);
                   } else {
                 	res.sendRedirect(req.getContextPath() + "/login");
                   }
        	}else {
    			chain.doFilter(request, response);
    		}
             
        } catch (ArrayIndexOutOfBoundsException e) {
        	res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
