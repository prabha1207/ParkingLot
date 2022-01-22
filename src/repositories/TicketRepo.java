package repositories;

import java.util.ArrayList;
import java.util.List;

import model.Ticket;

public class TicketRepo {
	
	public List<Ticket> allTicket=new ArrayList<>();
	public List<Ticket> allTicketWithExitTime=new ArrayList<>();
	public List<Ticket> getAllTicketWithExitTime() {
		return allTicketWithExitTime;
	}
	public void setAllTicketWithExitTime(List<Ticket> allTicketWithExitTime) {
		this.allTicketWithExitTime = allTicketWithExitTime;
	}
	public List<Ticket> getAllTicket() {
		return allTicket;
	}
	public void setAllTicket(List<Ticket> allTicket) {
		this.allTicket = allTicket;
	}
	public TicketRepo() {
		
	}
}
