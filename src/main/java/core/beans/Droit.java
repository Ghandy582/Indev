package core.beans;

public class Droit{
	/**
	 * Static droit attribute
	 */
	public static final String ATTRIBUTE = "droit";

	public static final String SESSION_ATTRIBUTE = "DROIT";
	
	
	/**
	 * Doit id
	 */
	private int droit_id;


	/**
	 * Droit libelle
	 */
	private String droit_libelle;
	
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
	public String getDroit_libelle() {
		return droit_libelle;
	}
	
	
	/**
	 * Constructor
	 * @param droit_id
	 * @param droit_libelle
	 */
	public Droit(int droit_id, String droit_libelle) {
		super();
		this.droit_id = droit_id;
		this.droit_libelle = droit_libelle;
	}

	/**
	 * Constructor
	 * @param droit_libelle
	 */
	public Droit(String droit_libelle) {
		super();
		this.droit_libelle = droit_libelle;
	}

	
	
}