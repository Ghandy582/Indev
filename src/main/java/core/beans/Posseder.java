package core.beans;

public class Posseder{
	
	/**
	 * Static Posseder attribute
	 */
	public static final String ATTRIBUTE = "posseder";

	public static final String SESSION_ATTRIBUTE = "POSSEDER";
	
	/**
	 * Droit id
	 */
	private int droit_id;
	
	/**
	 * Role id
	 */
	private int role_id;

	/**
	 * Getters
	 * @return
	 */
	public int getDroit_id() {
		return droit_id;
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
	 * @param droit_id
	 * @param role_id
	 */
	public Posseder(int droit_id, int role_id) {
		super();
		this.droit_id = droit_id;
		this.role_id = role_id;
	}

	/**
	 * Constructor
	 * @param role_id
	 */
	public Posseder(int role_id) {
		super();
		this.role_id = role_id;
	}
	
	
}