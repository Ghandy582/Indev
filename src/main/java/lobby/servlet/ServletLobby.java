package lobby.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import core.beans.Etat;
import core.beans.Priorite;
import core.beans.Ticket;
import core.beans.Type;
import core.beans.User;
import core.utils.MysqlSrv;

/**
 * Servlet implementation class ServletLobby
 */
@WebServlet("/lobby")
public class ServletLobby extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String VAR_STRING_VIEW_DEFAULT = 	"/WEB-INF/VIEW/lobby.jsp";
	private final String[] LIST_SUB_VIEW = {"/WEB-INF/VIEW/ajout.jsp"};

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLobby() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Get user session*/
		User var_user_session = (User) request.getSession().getAttribute(User.SESSION_ATTRIBUTE);
		MysqlSrv var_MysqlSrv_instance = MysqlSrv.F_getInstance(var_user_session.user_bdd);
		/*Get all ticket*/
		List<Ticket> var_list_ticket = var_MysqlSrv_instance.F_getTicket().F_GetAllTicket();
		/*Send data*/
		request.setAttribute("tickets", var_list_ticket);

		/*Get all type*/
		List<Type> var_list_type = var_MysqlSrv_instance.F_getType().F_GetAllType();
		/*Send data*/
		request.setAttribute("types", var_list_type);

		/*Get all priority*/
		List<Priorite> var_list_priorite = var_MysqlSrv_instance.F_getPriorite().F_GetAllPriorite();
		/*Send data*/
		request.setAttribute("priorites", var_list_priorite);
		
		/*Get all etat*/
		List<Etat> var_list_etat = var_MysqlSrv_instance.F_getEtat().F_GetAllEtat();
		/*Send data*/
		request.setAttribute("etats", var_list_etat);
		
		request.setAttribute("sub_views",LIST_SUB_VIEW);
		this.getServletContext().getRequestDispatcher( VAR_STRING_VIEW_DEFAULT ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String var_string_action = request.getParameter("action");
		/*Post selector*/
		try {
			switch (var_string_action) {
				case "ajout": 
					F_add(request, response);
					break;
				case "supprimer": 
					F_delete(request, response);
					break;
				default:
					break;
			}
		} catch (Exception e) {
			
		}
	}
	/**
	 * Post delete ticket
	 * @param req
	 * @param res
	 * @throws IOException 
	 */
	private void F_delete(HttpServletRequest req, HttpServletResponse res) throws IOException {
		/*Get session*/
		User var_user_session = (User) req.getSession().getAttribute(User.SESSION_ATTRIBUTE);
		/*variables*/
		int var_int_name = Integer.parseInt(req.getParameter("id_ticket"));
		try {
			/*Call Interface function*/
			MysqlSrv var_MysqlSrv_instance = MysqlSrv.F_getInstance(var_user_session.user_bdd);
			var_MysqlSrv_instance.F_getTicket().F_DeleteTicket(var_int_name);
			JSONObject result = new JSONObject()
					.put("code", "1").put("message","");
			res.getWriter().write(result.toString());
			
		} catch (Exception e) {
			JSONObject result = new JSONObject()
					.put("code", "-1").put("message","Erreur dans la suppression");
			res.getWriter().write(result.toString());
		}
		
	}

	/**
	 * Post add ticket
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	private void F_add(HttpServletRequest req, HttpServletResponse res) throws IOException {
		/*Get session*/
		User var_user_session = (User) req.getSession().getAttribute(User.SESSION_ATTRIBUTE);
		/*variables*/
		String var_string_name = req.getParameter("ticket_name");
		String var_string_description = req.getParameter("ticket_description");
		int var_int_types = Integer.parseInt(req.getParameter("types"));
		int var_int_priorites = Integer.parseInt(req.getParameter("priorites"));
		try {
			/*Call Interface function*/
			MysqlSrv var_MysqlSrv_instance = MysqlSrv.F_getInstance(var_user_session.user_bdd);
			var_MysqlSrv_instance.F_getTicket().F_AddTicket(var_string_name, var_string_description, var_int_types, var_int_priorites, var_user_session);
			/*response*/
			JSONObject result = new JSONObject()
					.put("code", "1").put("message","");
			res.getWriter().write(result.toString());
			
		} catch (Exception e) {
			/*response*/
			JSONObject result = new JSONObject()
					.put("code", "-1").put("message","Erreur dans l'ajout");
			res.getWriter().write(result.toString());
		}
		
	}

}
