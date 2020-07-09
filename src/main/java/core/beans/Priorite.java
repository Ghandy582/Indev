package core.beans;

public class Priorite{
	
	/**
	 * Static Priorite attribute
	 */
	public static final String ATTRIBUTE = "priorite";

	public static final String SESSION_ATTRIBUTE = "PRIORITE";
	
	
	/**
	 * Priorite id
	 */
	private int priorite_id;
	
	/**
	 * Priorite libelle
	 */
	private String priorite_libelle;

	/**
	 * Getters
	 * @return
	 */
	public int getPriorite_id() {
		return priorite_id;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getPriorite_libelle() {
		return priorite_libelle;
	}

	/**
	 * Constructor
	 * @param priorite_id
	 * @param priorite_libelle
	 */
	public Priorite(int priorite_id, String priorite_libelle) {
		super();
		this.priorite_id = priorite_id;
		this.priorite_libelle = priorite_libelle;
	}

	/**
	 * Constructor
	 * @param priorite_libelle
	 */
	public Priorite(String priorite_libelle) {
		super();
		this.priorite_libelle = priorite_libelle;
	}
	
	
}