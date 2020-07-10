package user.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.beans.Droit;
import core.beans.User;
import core.utils.MysqlSrvImpl;

public class UserImpl extends MysqlSrvImpl implements IUser {
	private Connection con = null;

	private static final String VAR_STRING_QUERY_LOGIN = "SELECT * FROM User WHERE user_login = ? AND user_password = ?";
	private static final String VAR_STRING_QUERY_RIGHT = "SELECT Dr.droit_id, Dr.droit_libelle FROM Posseder Po INNER JOIN Droit Dr on Po.droit_id = Dr.droit_id "
			+ "WHERE Po.role_id = ? ";
	
	@Override
	public User F_login(String login, String password, String env) {
		User var_user = null;
		List<Droit> var_list_right = new ArrayList<>();
		try {
			/*Connection SQL*/
			MysqlSrvImpl(env);
			con = var_MysqlSrv_daos.getConnection();
			/*Request User*/
			stmt = buildRequest(con, VAR_STRING_QUERY_LOGIN, login, password);
			ResultSet var_rs = stmt.executeQuery();
			var_rs.next();
			var_user = new User(var_rs.getInt("user_id"), 
					var_rs.getString("user_login"), 
					var_rs.getString("user_password"), 
					var_rs.getString("user_nom"),
					var_rs.getString("user_prenom"), 
					var_rs.getInt("role_id"));
			
			/*Request Rights*/
			stmt = buildRequest(con, VAR_STRING_QUERY_RIGHT, var_user.getRole_id());
			var_rs = stmt.executeQuery();
			while(var_rs.next()) {
				var_list_right.add(new Droit(var_rs.getInt("droit_id"), var_rs.getString("droit_libelle")));
			}
			var_user.setVar_list_right(var_list_right);
			/*Close connection SQL*/
			con.close();
		} catch (SQLException e) {
			
		}
		return var_user;
	}

}
