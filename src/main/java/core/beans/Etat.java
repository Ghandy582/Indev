package core.beans;

public class Etat{
	/**
	 * Static Etat attribute
	 */
	public static final String ATTRIBUTE = "etat";

	public static final String SESSION_ATTRIBUTE = "ETAT";
	
	
	/**
	 * Etat id
	 */
	private int etat_id;
	
	/**
	 * Etat libelle
	 */
	private String etat_libelle;
	
	/**
	 * Getters
	 * @return
	 */
	public int getEtat_id() {
		return etat_id;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getEtat_libelle() {
		return etat_libelle;
	}

	/**
	 * Constructor
	 * @param etat_id
	 * @param etat_libelle
	 */
	public Etat(int etat_id, String etat_libelle) {
		super();
		this.etat_id = etat_id;
		this.etat_libelle = etat_libelle;
	}

	/**
	 * Constructor
	 * @param etat_libelle
	 */
	public Etat(String etat_libelle) {
		super();
		this.etat_libelle = etat_libelle;
	}
	
	
}