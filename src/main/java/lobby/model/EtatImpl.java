package lobby.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.beans.Etat;
import core.utils.MysqlSrvImpl;

public class EtatImpl extends MysqlSrvImpl implements Ietat{
	private Connection con = null;
	private static final String VAR_STRING_QUERY_ALL = "SELECT * FROM Etat ";
	
	public List<Etat> F_GetAllEtat(){
		/*Variables*/
		List<Etat> var_list_etat = new ArrayList<>();
		ResultSet var_rs = null;
		try {
			/*Connection SQL*/
			con = var_MysqlSrv_daos.getConnection();
			/*Request Etat*/
			stmt = buildRequest(con,VAR_STRING_QUERY_ALL);
			var_rs = stmt.executeQuery();
			while(var_rs.next()) {
				var_list_etat.add(new Etat(var_rs.getInt("etat_id"), var_rs.getString("etat_libelle")));
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return var_list_etat;
	}
}
