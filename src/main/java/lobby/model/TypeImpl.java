package lobby.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.beans.Type;
import core.utils.MysqlSrvImpl;

public class TypeImpl extends MysqlSrvImpl implements Itype{
	
	private Connection con = null;
	private static final String VAR_STRING_QUERY_ALL = "SELECT * FROM Type ";
	
	public List<Type> F_GetAllType(){
		List<Type> var_list_type = new ArrayList<>();
		ResultSet var_rs = null;
		try {
			con = var_MysqlSrv_daos.getConnection();
			stmt = buildRequest(con,VAR_STRING_QUERY_ALL);
			var_rs = stmt.executeQuery();
			while(var_rs.next()) {
				var_list_type.add(new Type(var_rs.getInt("type_id"), var_rs.getString("type_libelle")));
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return var_list_type;
	}
	
}
