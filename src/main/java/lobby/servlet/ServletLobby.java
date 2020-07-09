package lobby.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.model.Ticket;
import core.model.User;
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
		List<Ticket> var_list_ticket = var_MysqlSrv_instance.F_getTicket().F_GetAllTicket();
		request.setAttribute("tickets", var_list_ticket);
		request.setAttribute("sub_views",LIST_SUB_VIEW);
		this.getServletContext().getRequestDispatcher( VAR_STRING_VIEW_DEFAULT ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
