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
		MysqlSrv m = MysqlSrv.F_getInstance(VAR_STRING_URL_TEST);
		m.F_getTest().tes();
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
		doGet(request, response);
	}

}
