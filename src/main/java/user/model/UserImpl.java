package user.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.model.User;
import core.utils.MysqlSrvImpl;

public class UserImpl extends MysqlSrvImpl implements IUser {
	private Connection con = null;
	private static final String VAR_STRING_QUERY_LOGIN = "SELECT * FROM User WHERE user_login = ? AND user_password = ?";

	@Override
	public User F_login(String login, String password) {
		User var_user_1 = null;
		try {
			con = var_MysqlSrv_daos.getConnection();
			stmt = buildRequest(con, VAR_STRING_QUERY_LOGIN, login, password);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			var_user_1 = new User(rs.getInt("user_id"), 
								rs.getString("user_login"), 
								rs.getString("user_password"), 
								rs.getString("user_nom"),
								rs.getString("user_prenom"), 
								rs.getInt("role_id"));
			con.close();
		} catch (SQLException e) {
			
		}
		return var_user_1;
	}
}
