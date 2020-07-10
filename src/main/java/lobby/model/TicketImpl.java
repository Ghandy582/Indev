package lobby.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.beans.Ticket;
import core.beans.User;
import core.utils.MysqlSrvImpl;

public class TicketImpl extends MysqlSrvImpl implements Iticket{
	
	private Connection con = null;
	private static final String VAR_STRING_QUERY_ALL = "SELECT Ti.ticket_id, Ti.ticket_nom, Ti.ticket_description, Ti.ticket_date_ouverture, Ti.ticket_date_cloture,"
			+ "Us.user_prenom, Us.user_nom, Ty.type_libelle, Et.etat_libelle, Us2.user_prenom as userMod_prenom, Us2.user_nom as userMod_nom, Pr.priorite_libelle  "
			+ "FROM Ticket Ti "
			+ "INNER JOIN User Us on Ti.user_id = Us.user_id "
			+ "INNER JOIN User Us2 on Ti.user_id_modifier = Us2.user_id "
			+ "INNER JOIN Type Ty on Ti.type_id = Ty.type_id "
			+ "INNER JOIN Etat Et on Ti.etat_id = Et.etat_id "
			+ "INNER JOIN Priorite Pr on Ti.priorite_id = Pr.priorite_id";
	private static final String VAR_STRING_QUERY_INSERT ="insert into indev_dev.Ticket (ticket_nom, ticket_description, ticket_date_ouverture, user_id, type_id, etat_id, user_id_modifier, priorite_id) \r\n" + 
			"VALUES (?, ?, NOW(), ?, ?, 1, 17, ?)";
	
	private static final String VAR_STRING_QUERY_DELETE= "DELETE FROM Ticket Where ticket_id = ?";

	public List<Ticket> F_GetAllTicket() {
		/*Variables*/
		List<Ticket> var_list_loaded = new ArrayList<>();
		ResultSet var_rs = null;
		try {
			/*Connection SQL*/
			con = var_MysqlSrv_daos.getConnection();
			/*Request Ticket*/
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
						var_rs.getString("user_prenom") +" "+ var_rs.getString("user_nom"), 
						var_rs.getString("type_libelle"), 
						var_rs.getString("etat_libelle"), 
						var_rs.getString("userMod_prenom") +" "+ var_rs.getString("userMod_nom"), 
						var_rs.getString("priorite_libelle")));
			}
			con.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return var_list_loaded;
	}


	@Override
	public void F_AddTicket(String var_string_name, String var_string_description, int var_int_types,
			int var_int_priorites, User user) {
		try {
			/*Connection SQL*/
			con = var_MysqlSrv_daos.getConnection();
			/*Request Ticket*/
			stmt = buildRequest(con,VAR_STRING_QUERY_INSERT,var_string_name,var_string_description,user.getUser_id(),var_int_types,var_int_priorites);
			stmt.executeUpdate();
			con.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}


	@Override
	public void F_DeleteTicket(int var_int_id) {
		try {
			/*Connection SQL*/
			con = var_MysqlSrv_daos.getConnection();
			/*Request Ticket*/
			stmt = buildRequest(con,VAR_STRING_QUERY_DELETE, var_int_id);
			stmt.executeUpdate();
			con.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	
}
