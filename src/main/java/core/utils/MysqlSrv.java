package core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import lobby.model.Itest;
import lobby.model.test;

public class MysqlSrv {
	// Flags for URL properties names in config file

	/**
	 * Current database url
	 */
	public String var_string_url;

	/**
	 * Current database login
	 */
	public String var_string_login;

	/**
	 * Current database password
	 */
	public String var_string_password;

	/**
	 * Current database driver
	 */
	public String var_string_driver;

	/**
	 * Singleton instance
	 */
	private static MysqlSrv var_static_instance = null;


	/**
	 * Initializes a new {@link DAOFactory}
	 * 
	 * @param url      db url
	 * @param login    db login
	 * @param password db password
	 * @param driver   db driver
	 */
	private MysqlSrv(String url, String login, String password, String driver) {
		this.var_string_url = url;
		this.var_string_login = login;
		this.var_string_password = password;
		this.var_string_driver = driver;
	}
	
	/**
	 * Gets database instance
	 * @return connection instance
	 * @throws IOException 
	 */
	public static MysqlSrv F_getInstance(String type) throws IOException {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Properties props = new Properties();
			try(InputStream resourceStream = loader.getResourceAsStream("mysqlsrv.properties")) {
			    props.load(resourceStream);
			}
			
			String url = props.getProperty(type);
			String login = props.getProperty("login");
			String password = props.getProperty("password");
			String driver = props.getProperty("driver");
			if (var_static_instance == null || var_static_instance.F_reload(url, login, password, driver)) {
				Class.forName(driver);
				var_static_instance = new MysqlSrv(url, login, password, driver);
			}
		} catch (ClassNotFoundException e) {
		} 
		return var_static_instance;
	}

	
	/**
	 * Reload the parameters
	 * @param url
	 * @param login
	 * @param password
	 * @param driver
	 * @return all parameters
	 */
	private boolean F_reload(String url, String login, String password, String driver) {
		return !this.var_string_url.equals(url) || !this.var_string_login.equals(login) || !this.var_string_password.equals(password)
				|| !this.var_string_driver.equals(driver);
	}
	
	/**
	 * Gets database connection
	 * 
	 * @return connection instance
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(var_string_url);
	}
	
	public Itest F_getTest() {
		return new test();
	}
}
