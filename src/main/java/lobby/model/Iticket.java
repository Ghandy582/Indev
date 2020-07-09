package lobby.model;

import java.util.List;

import core.model.Ticket;

public interface Iticket {
	
	/**
	 * Load all ticket
	 * @return List<Ticket>
	 */
	public List<Ticket> F_GetAllTicket();
}
