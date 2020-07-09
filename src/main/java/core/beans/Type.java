package core.beans;

public class Type{
	
	/**
	 * Static Type attribute
	 */
	public static final String ATTRIBUTE = "type";

	public static final String SESSION_ATTRIBUTE = "TYPE";
	
	/**
	 * Type id
	 */
	private int type_id;
	
	/**
	 * Type libelle
	 */
	private String type_libelle;
	
	/**
	 * Getters
	 * @return
	 */
	
	public int getType_id() {
		return type_id;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getType_libelle() {
		return type_libelle;
	}

	/**
	 * Constructor
	 * @param type_id
	 * @param type_libelle
	 */
	public Type(int type_id, String type_libelle) {
		super();
		this.type_id = type_id;
		this.type_libelle = type_libelle;
	}

	/**
	 * Constructor
	 * @param type_libelle
	 */
	public Type(String type_libelle) {
		super();
		this.type_libelle = type_libelle;
	}
	
	
}