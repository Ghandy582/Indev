package core.model;

public class User {

	/**
	 * Static user attribute
	 */
	public static final String ATTRIBUTE = "user";

	public static final String SESSION_ATTRIBUTE = "USER";

	public String user_bdd;
	/**
	 * User Id
	 */
	private int user_id;
	
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
	private int role_id;
	
	/**
	 * Getters
	 * @return
	 */
	public String getUser_login() {
		return user_login;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getUser_password() {
		return user_password;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getUser_nom() {
		return user_nom;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getUser_prenom() {
		return user_prenom;
	}

	/**
	 * Getters
	 * @return
	 */
	public int getRole_id() {
		return role_id;
	}
	
	
	/**
	 * Constructor
	 * @param user_id
	 * @param user_login
	 * @param user_password
	 * @param user_nom
	 * @param user_prenom
	 * @param role_id
	 */
	public User(int user_id, String user_login, String user_password, String user_nom, String user_prenom,
			int role_id) {
		super();
		this.user_id = user_id;
		this.user_login = user_login;
		this.user_password = user_password;
		this.user_nom = user_nom;
		this.user_prenom = user_prenom;
		this.role_id = role_id;
	}
	
	/**
	 * Constructor
	 * @param user_login
	 * @param user_password
	 * @param user_nom
	 * @param user_prenom
	 * @param role_id
	 */
	public User(String user_login, String user_password, String user_nom, String user_prenom, int role_id) {
		super();
		this.user_login = user_login;
		this.user_password = user_password;
		this.user_nom = user_nom;
		this.user_prenom = user_prenom;
		this.role_id = role_id;
	}

	/**
	 * Constructor login
	 * @param user_login
	 * @param user_password
	 */
	public User(String user_login, String user_password) {
		super();
		this.user_login = user_login;
		this.user_password = user_password;
	}

	/**
	 * Getters
	 * @return
	 */
	public int getUser_id() {
		return user_id;
	}
}