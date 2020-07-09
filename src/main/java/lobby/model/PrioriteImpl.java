package lobby.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.beans.Priorite;
import core.utils.MysqlSrvImpl;

public class PrioriteImpl extends MysqlSrvImpl implements Ipriorite{
	private Connection con = null;
	private static final String VAR_STRING_QUERY_ALL = "SELECT * From Priorite";
	
	public List<Priorite> F_GetAllPriorite(){
		List<Priorite> var_list_priorite = new ArrayList<>();
		ResultSet var_rs = null;
		try {
			con = var_MysqlSrv_daos.getConnection();
			stmt = buildRequest(con,VAR_STRING_QUERY_ALL);
			var_rs = stmt.executeQuery();
			while(var_rs.next()) {
				var_list_priorite.add(new Priorite(var_rs.getInt("priorite_id"), var_rs.getString("priorite_libelle")));
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return var_list_priorite;
	}
}
