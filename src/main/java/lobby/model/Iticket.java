package lobby.model;

import java.util.List;

import core.beans.Ticket;

public interface Iticket {
	
	/**
	 * Load all ticket
	 * @return List<Ticket>
	 */
	public List<Ticket> F_GetAllTicket();
}
