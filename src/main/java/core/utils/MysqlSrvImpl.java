package core.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MysqlSrvImpl {

	public PreparedStatement stmt = null;
	public MysqlSrv var_MysqlSrv_daos;
	protected MysqlSrvImpl(){
		try {
			var_MysqlSrv_daos = MysqlSrv.F_getInstance("indev_dev");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Builds a SQL request
	 * @param con connection
	 * @param query formated query
	 * @param args optional arguments to add to the query
	 * @return statement instance
	 * @throws SQLException if there is an error in the arguments
	 */
	public PreparedStatement buildRequest(Connection con, String query, Object... args) throws SQLException {
		PreparedStatement ps = con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof Integer[]) {
				ps.setArray(i + 1, con.createArrayOf("INTEGER", (Object[]) args[i]));
			} else if (args[i] instanceof String[]) {
				ps.setArray(i + 1, con.createArrayOf("STRING", (Object[]) args[i]));
			} else if (args[i] instanceof Integer) {
				ps.setInt(i + 1, (Integer) args[i]);
			} else if (args[i] instanceof Boolean) {
				ps.setBoolean(i + 1, (Boolean) args[i]);
			} else if (args[i] instanceof String) {
				ps.setString(i + 1, (String) args[i]);
			} else {
				ps.setObject(i + 1, args[i]);
			}
		}
		return ps;
	}
}
