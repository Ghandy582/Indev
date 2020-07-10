package lobby.model;

import java.util.List;

import core.beans.Ticket;
import core.beans.User;

public interface Iticket {
	
	/**
	 * Load all ticket
	 * @return List<Ticket>
	 */
	public List<Ticket> F_GetAllTicket();
	
	/**
	 * Insert ticket
	 * @param user 
	 * @param String var_string_priorites 
	 * @param String var_string_types 
	 * @param Int var_int_description 
	 * @param Int var_int_name 
	 */
	public void F_AddTicket(String var_int_name, String var_int_description, int var_string_types, int var_string_priorites, User user);
}
