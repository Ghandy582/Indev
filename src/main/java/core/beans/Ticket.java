package core.beans;

public class Ticket {

	/**
	 * Static ticket attribute
	 */
	public static final String ATTRIBUTE = "ticket";

	public static final String SESSION_ATTRIBUTE = "TICKET";

	/**
	 * Ticket id
	 */
	private int ticket_id;
		

	/**
	 * Ticket name
	 */
	private String ticket_nom;
		

	/**
	 * Ticket description
	 */
	private String ticket_description;
		

	/**
	 * Ticket date ouverture
	 */
	private String ticket_date_ouverture;

	
	/**
	 * Ticket date cloture
	 */
	private String ticket_date_cloture;
		

	/**
	 * User
	 */
	private String var_string_user;
	
	
	/**
	 * Type
	 */
	private String var_string_type;
	
	
	/**
	 * Etat
	 */
	private String var_string_etat;
	
	
	/**
	 * User modifier
	 */
	private String var_string_userModifier;
	
	
	/**
	 * Priorite
	 */
	private String var_string_priorite;
	

	/**
	 * Getters
	 * @return
	 */
	public int getTicket_id() {
		return ticket_id;
	}
	
	/**
	 * Getters
	 * @return
	 */
	public String getTicket_nom() {
		return ticket_nom;
	}
	
	/**
	 * Getters
	 * @return
	 */
	public String getTicket_description() {
		return ticket_description;
	}
	
	/**
	 * Getters
	 * @return
	 */	
	public String getTicket_date_ouverture() {
		return ticket_date_ouverture;
	}
	
	/**
	 * Getters
	 * @return
	 */
	public String getTicket_date_cloture() {
		return ticket_date_cloture;
	}
	
	/**
	 * Getters
	 * @return
	 */
	public String getVar_string_user() {
		return var_string_user;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getVar_string_type() {
		return var_string_type;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getVar_string_etat() {
		return var_string_etat;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getVar_string_userModifier() {
		return var_string_userModifier;
	}

	/**
	 * Getters
	 * @return
	 */
	public String getVar_string_priorite() {
		return var_string_priorite;
	}

	/**
	 * Constructor
	 * @param ticket_id
	 * @param ticket_nom
	 * @param ticket_description
	 * @param ticket_date_ouverture
	 * @param ticket_date_cloture
	 * @param var_string_user
	 * @param var_string_type
	 * @param var_string_etat
	 * @param var_string_userModifier
	 * @param var_string_priorite
	 */
	public Ticket(int ticket_id, String ticket_nom, String ticket_description, String ticket_date_ouverture,
			String ticket_date_cloture, String var_string_user, String var_string_type, String var_string_etat,
			String var_string_userModifier, String var_string_priorite) {
		super();
		this.ticket_id = ticket_id;
		this.ticket_nom = ticket_nom;
		this.ticket_description = ticket_description;
		this.ticket_date_ouverture = ticket_date_ouverture;
		this.ticket_date_cloture = ticket_date_cloture;
		this.var_string_user = var_string_user;
		this.var_string_type = var_string_type;
		this.var_string_etat = var_string_etat;
		this.var_string_userModifier = var_string_userModifier;
		this.var_string_priorite = var_string_priorite;
	}
	
}
