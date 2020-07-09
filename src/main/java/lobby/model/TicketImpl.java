package lobby.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.beans.Ticket;
import core.utils.MysqlSrvImpl;

public class TicketImpl extends MysqlSrvImpl implements Iticket{
	
	private Connection con = null;
	private static final String VAR_STRING_QUERY_ALL = "SELECT * FROM Ticket ";

	public List<Ticket> F_GetAllTicket() {
		List<Ticket> var_list_loaded = new ArrayList<>();
		ResultSet var_rs = null;
		try {
			con = var_MysqlSrv_daos.getConnection();
			stmt = buildRequest(con,VAR_STRING_QUERY_ALL);
			var_rs = stmt.executeQuery();
			while(var_rs.next()) {
				var_list_loaded.add(
						new Ticket(
								var_rs.getInt("ticket_id"), 
								var_rs.getString("ticket_nom"), 
								var_rs.getString("ticket_description"), 
								var_rs.getString("ticket_date_ouverture"), 
								var_rs.getString("ticket_date_cloture"), 
								var_rs.getInt("user_id"), 
								var_rs.getInt("type_id"), 
								var_rs.getInt("etat_id"), 
								var_rs.getInt("user_id_modifier"), 
								var_rs.getInt("priorite_id")));
			}
			con.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return var_list_loaded;
	}
	
}
