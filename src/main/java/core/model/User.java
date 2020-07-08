package core.model;

public class User {
	/**
	 * Static user attribute
	 */
	public static final String ATTRIBUTE = "user";

	public static final String SESSION_ATTRIBUTE = "USER";

	/**
	 * User login
	 */
	private String user_login;
	
	/**
	 * User password
	 */
	private String user_password;
	
	/**
	 * User nom
	 */
	private String user_nom;
	
	/**
	 * User prenom
	 */
	private String user_prenom;
	
	/**
	 * Role id
	 */
	private String role_id;
	
	public User(String user_login, String user_password) {
		this.user_login = user_login;
		this.user_password = user_password;
	}
}
