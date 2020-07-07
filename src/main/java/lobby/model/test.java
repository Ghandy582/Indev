package lobby.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.utils.MysqlSrvImpl;

public class test extends MysqlSrvImpl implements Itest{
	
	private Connection con = null;
	
	public void tes() {
		try {
			con = var_MysqlSrv_daos.getConnection();
		} catch (SQLException e1) {
			System.out.println(e1);
		}
		try {
			stmt = buildRequest(con,"SELECT * FROM Droit");
			ResultSet res = stmt.executeQuery();
			res.next();
			System.out.println(res.getString("droit_libelle"));
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	

}
