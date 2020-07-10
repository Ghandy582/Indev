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
	 * @param var_string_name
	 * @param var_string_description
	 * @param var_int_types
	 * @param var_int_priorites
	 * @param user
	 */
	public void F_AddTicket(String var_string_name, String var_string_description, int var_int_types, int var_int_priorites, User user);

	/**
	 * Delete ticket
	 * @param String var_int_name
	 */
	public void F_DeleteTicket(int var_int_id);
}
