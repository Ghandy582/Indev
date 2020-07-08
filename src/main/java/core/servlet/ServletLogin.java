package core.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.utils.MysqlSrv;


/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VAR_STRING_URL_TEST = "indev_dev";
	public static final String VAR_STRING_URL_PROJECT = "indev";
	private final String VAR_STRING_VIEW_DEFAULT = 	"/WEB-INF/VIEW/login.jsp";
    
	/**
     * Default constructor. 
     */
    public ServletLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> var_list_url = new ArrayList<String>();
		var_list_url.add(VAR_STRING_URL_TEST);
		var_list_url.add(VAR_STRING_URL_PROJECT);
	    request.setAttribute("url", var_list_url);
		this.getServletContext().getRequestDispatcher( VAR_STRING_VIEW_DEFAULT ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
				case "login": 
					login(request, response);
					break;
				case "logout":
					break;
				default:
					break;
			}
		} catch (Exception e) {
			
		}
	}
	
	private void login(HttpServletRequest req, HttpServletResponse res) {
		String login = req.getParameter("login");
		String pass = req.getParameter("password");
		System.out.println(login);
		System.out.println(pass);

	}

}
