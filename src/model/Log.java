package model;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import model.items.TicketEntry;

public class Log {

	public final HashMap<String, Integer> entries = new HashMap<>();
	
	@JsonIgnore
	public Log(List<TicketEntry> ticketList) {
		for (TicketEntry ticketEntry : ticketList) {
			entries.put(ticketEntry.getItem().getName(),entries.getOrDefault(ticketEntry.getItem().getName(), 0)+ ticketEntry.getAmount());
		}
	}

	
	
}
