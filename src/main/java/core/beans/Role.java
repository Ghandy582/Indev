package core.beans;

public class Role{
	
	/**
	 * Static Role attribute
	 */
	
	public static final String ATTRIBUTE = "role";

	public static final String SESSION_ATTRIBUTE = "Role";
	
	/**
	 * Role id
	 */
	private int role_id;
	
	/**
	 * Role libelle
	 */
	private String role_libelle;

	/**
	 * Getters
	 * @return
	 */
	public int getRole_id() {
		return role_id;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getRole_libelle() {
		return role_libelle;
	}

	/**
	 * Constructor
	 * @param role_id
	 * @param role_libelle
	 */
	public Role(int role_id, String role_libelle) {
		super();
		this.role_id = role_id;
		this.role_libelle = role_libelle;
	}

	/**
	 * Constructor
	 * @param role_libelle
	 */
	public Role(String role_libelle) {
		super();
		this.role_libelle = role_libelle;
	}
	
	
}