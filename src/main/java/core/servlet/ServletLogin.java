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

import org.json.JSONObject;

import core.beans.User;
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
		String var_string_action = request.getParameter("action");
		try {
			switch (var_string_action) {
				case "login": 
					F_login(request, response);
					break;
				case "logout":
					F_logout(request, response);
					break;
				default:
					break;
			}
		} catch (Exception e) {
			
		}
	}
	
	private void F_logout(HttpServletRequest req, HttpServletResponse res) {
		try {
			JSONObject result = new JSONObject()
					.put("code", "1").put("message","");
			/*Delete session*/
			req.getSession().setAttribute(User.SESSION_ATTRIBUTE, null);
			res.getWriter().write(result.toString());
		} catch (Exception e) {
			
		}
		
	}

	private void F_login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		/*Get variables*/
		String var_string_login = req.getParameter("login");
		String var_string_pass = req.getParameter("password");
		String var_string_env = req.getParameter("choixbdd");
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		User var_user_u = null;
		try {
			/*Check User in BDD*/
			MysqlSrv var_MysqlSrv_instance = MysqlSrv.F_getInstance(var_string_env);
			var_user_u = var_MysqlSrv_instance.F_getUser().F_login(var_string_login, var_string_pass, var_string_env);
			var_user_u.user_bdd = var_string_env;
			/*Create session*/
			req.getSession().setAttribute(User.SESSION_ATTRIBUTE, var_user_u);
			JSONObject result = new JSONObject()
					.put("code", "1").put("message","");
			res.getWriter().write(result.toString());
		} catch (Exception e) {
			JSONObject result = new JSONObject()
					.put("code", "-1").put("message","Erreur de connexion");
			res.getWriter().write(result.toString());
		}
	}

}
