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
	 * User id
	 */
	private int user_id;
	
	
	/**
	 * type_id
	 */
	private int type_id;
	
	
	/**
	 * etat_id
	 */
	private int etat_id;
	
	
	/**
	 * user_id_modifier
	 */
	private int user_id_modifier;
	
	
	/**
	 * priorite_id
	 */
	private int priorite_id;
	
	
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
	public int getUser_id() {
		return user_id;
	}
	
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
	public int getEtat_id() {
		return etat_id;
	}
	/**
	 * Getters
	 * @return
	 */
	public int getUser_id_modifier() {
		return user_id_modifier;
	}
	
	/**
	 * Getters
	 * @return
	 */
	public int getPriorite_id() {
		return priorite_id;
	}

	
	/**
	 * 
	 * @param ticket_id
	 * @param ticket_nom
	 * @param ticket_description
	 * @param ticket_date_ouverture
	 * @param ticket_date_cloture
	 * @param user_id
	 * @param type_id
	 * @param etat_id
	 * @param user_id_modifier
	 * @param priorite_id
	 */
	
	public Ticket(int ticket_id, String ticket_nom, String ticket_description, String ticket_date_ouverture,
			String ticket_date_cloture, int user_id, int type_id, int etat_id, int user_id_modifier,
			int priorite_id) {
		super();
		this.ticket_id = ticket_id;
		this.ticket_nom = ticket_nom;
		this.ticket_description = ticket_description;
		this.ticket_date_ouverture = ticket_date_ouverture;
		this.ticket_date_cloture = ticket_date_cloture;
		this.user_id = user_id;
		this.type_id = type_id;
		this.etat_id = etat_id;
		this.user_id_modifier = user_id_modifier;
		this.priorite_id = priorite_id;
	}
	
	
}
