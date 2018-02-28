package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import gui.CashierGui;
import model.items.Item;
import model.items.OrderEntry;
import model.items.Sauce;
import model.items.SaucedItem;
import model.items.SummaryItem;
import model.items.TicketEntry;

public class CashierController {
	
	private static final SummaryItem KIP_KIP = new SummaryItem(Arrays.asList(OrderEntry.KIP,OrderEntry.KIP), 15, "Kip (2)");
	public static final Item KIP_KIP_NATUUR = new SaucedItem(KIP_KIP, Sauce.NATUUR);
	public static final Item KIP_KIP_PROVENCAAL = new SaucedItem(KIP_KIP, Sauce.PROVENCAAL);
	public static final Item KIP_KIP_STROGANOFF = new SaucedItem(KIP_KIP, Sauce.STROGANOFF);
	public static final Item KIP_KIP_BEARNAISE = new SaucedItem(KIP_KIP, Sauce.BEARNAISE);
	public static final Item KIP_KIP_APPELMOES = new SaucedItem(KIP_KIP, Sauce.APPELMOES);
	
	private static final SummaryItem KIP_RUND = new SummaryItem(Arrays.asList(OrderEntry.KIP,OrderEntry.RUND), 15, "Kip Rund");
	public static final Item KIP_RUND_NATUUR = new SaucedItem(KIP_RUND, Sauce.NATUUR);
	public static final Item KIP_RUND_PROVENCAAL = new SaucedItem(KIP_RUND, Sauce.PROVENCAAL);
	public static final Item KIP_RUND_STROGANOFF = new SaucedItem(KIP_RUND, Sauce.STROGANOFF);
	public static final Item KIP_RUND_BEARNAISE = new SaucedItem(KIP_RUND, Sauce.BEARNAISE);
	public static final Item KIP_RUND_APPELMOES = new SaucedItem(KIP_RUND, Sauce.APPELMOES);
	
	private static final SummaryItem RUND_RUND = new SummaryItem(Arrays.asList(OrderEntry.RUND,OrderEntry.RUND), 15,"Rund (2)");
	public static final Item RUND_RUND_NATUUR = new SaucedItem(RUND_RUND, Sauce.NATUUR);
	public static final Item RUND_RUND_PROVENCAAL = new SaucedItem(RUND_RUND, Sauce.PROVENCAAL);
	public static final Item RUND_RUND_STROGANOFF = new SaucedItem(RUND_RUND, Sauce.STROGANOFF);
	public static final Item RUND_RUND_BEARNAISE = new SaucedItem(RUND_RUND, Sauce.BEARNAISE);
	public static final Item RUND_RUND_APPELMOES = new SaucedItem(RUND_RUND, Sauce.APPELMOES);
	
	private static final SummaryItem ZALM = new SummaryItem(new ArrayList<OrderEntry>(Arrays.asList(OrderEntry.ZALM)), 15,"Zalm");
	public static final Item ZALM_NATUUR = new SaucedItem(ZALM, Sauce.NATUUR);
	public static final Item ZALM_PROVENCAAL = new SaucedItem(ZALM, Sauce.PROVENCAAL);
	public static final Item ZALM_STROGANOFF = new SaucedItem(ZALM, Sauce.STROGANOFF);
	public static final Item ZALM_BEARNAISE = new SaucedItem(ZALM, Sauce.BEARNAISE);
	public static final Item ZALM_APPELMOES = new SaucedItem(ZALM, Sauce.APPELMOES);
	
	private static final SummaryItem KUIKEN = new SummaryItem(Arrays.asList(OrderEntry.KIP), 10,"Kip (1)");
	public static final Item KUIKEN_NATUUR = new SaucedItem(KUIKEN, Sauce.NATUUR);
	public static final Item KUIKEN_PROVENCAAL = new SaucedItem(KUIKEN, Sauce.PROVENCAAL);
	public static final Item KUIKEN_STROGANOFF = new SaucedItem(KUIKEN, Sauce.STROGANOFF);
	public static final Item KUIKEN_BEARNAISE = new SaucedItem(KUIKEN, Sauce.BEARNAISE);
	public static final Item KUIKEN_APPELMOES = new SaucedItem(KUIKEN, Sauce.APPELMOES);
	
	private static final SummaryItem KALF = new SummaryItem(Arrays.asList(OrderEntry.RUND), 10,"Rund (1)");
	public static final Item KALF_NATUUR = new SaucedItem(KALF, Sauce.NATUUR);
	public static final Item KALF_PROVENCAAL = new SaucedItem(KALF, Sauce.PROVENCAAL);
	public static final Item KALF_STROGANOFF = new SaucedItem(KALF, Sauce.STROGANOFF);
	public static final Item KALF_BEARNAISE = new SaucedItem(KALF, Sauce.BEARNAISE);
	public static final Item KALF_APPELMOES = new SaucedItem(KALF, Sauce.APPELMOES);

	private static final SummaryItem VEGGY_VEGGY = new SummaryItem(Arrays.asList(OrderEntry.VEGGY,OrderEntry.VEGGY), 15,"Veggy (2)");
	public static final Item VEGGY_VEGGY_NATUUR = new SaucedItem(VEGGY_VEGGY, Sauce.NATUUR);
	public static final Item VEGGY_VEGGY_PROVENCAAL = new SaucedItem(VEGGY_VEGGY, Sauce.PROVENCAAL);
	public static final Item VEGGY_VEGGY_STROGANOFF = new SaucedItem(VEGGY_VEGGY, Sauce.STROGANOFF);
	public static final Item VEGGY_VEGGY_BEARNAISE = new SaucedItem(VEGGY_VEGGY, Sauce.BEARNAISE);
	public static final Item VEGGY_VEGGY_APPELMOES = new SaucedItem(VEGGY_VEGGY, Sauce.APPELMOES);

	private static final SummaryItem VEGGY = new SummaryItem(Arrays.asList(OrderEntry.VEGGY), 10,"Veggy (1)");
	public static final Item VEGGY_NATUUR = new SaucedItem(VEGGY, Sauce.NATUUR);
	public static final Item VEGGY_PROVENCAAL = new SaucedItem(VEGGY, Sauce.PROVENCAAL);
	public static final Item VEGGY_STROGANOFF = new SaucedItem(VEGGY, Sauce.STROGANOFF);
	public static final Item VEGGY_BEARNAISE = new SaucedItem(VEGGY, Sauce.BEARNAISE);
	public static final Item VEGGY_APPELMOES = new SaucedItem(VEGGY, Sauce.APPELMOES);

	public static final Item SOEP = new SummaryItem(Arrays.asList(OrderEntry.SOUP), 4,"Soep");
	public static final Item BON = new SummaryItem(Arrays.asList(OrderEntry.TICKET), 1.8,"Bon");
	
	private final CashierGui gui;

	private int selectedNumber = 1;
	private boolean notYetSelectedNumber = true;
	
	private final List<TicketEntry> ticketList = new ArrayList<>();
	
	
	public CashierController(CashierGui gui) {
		this.gui=gui;
		startHourThread();
	}
	
	private void startHourThread() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					gui.setHour(Clock.getHourStringFromDate(Calendar.getInstance().getTime()));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
				}
			}
		}).start();
	}

	public void selectNumber(int number) {
		if(selectedNumber==0 || notYetSelectedNumber){
			selectedNumber=number;
			notYetSelectedNumber=false;
		}else{
			selectedNumber=Math.min(1000, selectedNumber*10 + number);
		}
		updateGui();
	}
	
	public void backspace() {
		selectedNumber=selectedNumber/10;
		updateGui();
	}

	public void addToTicket(Item item) {
		if(selectedNumber==0){
			return;
		}
		ticketList.add(new TicketEntry(item, selectedNumber));
		updateGui();
		resetSelectedNumber();
	}

	private void resetSelectedNumber() {
		selectedNumber=1;
		notYetSelectedNumber=true;
		updateGui();
	}

	private void updateGui(){
		updateGuiLists();
		updateTotalPrice();
		updateGuiNumber();
	}
	
	private void updateTotalPrice() {
		gui.setTotal("€ "+getTotalPrice());
	}

	private void updateGuiNumber() {
		gui.setNumber(selectedNumber);
	}

	private void updateGuiLists(){
		//update the gui ticket list
		updateGuiTickets();
		
		//update the gui summary list
		HashMap<SummaryItem, Integer> summaryClassToAmount = new HashMap<>();
		for (TicketEntry ticketEntry : ticketList) {
			summaryClassToAmount.put(ticketEntry.getItem().getSummaryItem(), 
					summaryClassToAmount.getOrDefault(ticketEntry.getItem().getSummaryItem(), 0)+ticketEntry.getAmount());
		}
		updateGuiSummary(summaryClassToAmount);
		
		//update the gui bbq list
		HashMap<OrderEntry, Integer> orderEntryToAmount = new HashMap<>();
		for (TicketEntry ticketEntry : ticketList) {
			for (OrderEntry orderEntry : ticketEntry.getItem().getSummaryItem().getOrderEntries()) {
				orderEntryToAmount.put(orderEntry, orderEntryToAmount.getOrDefault(orderEntry, 0)+ticketEntry.getAmount());
			}
		}
		updateGuiBbqList(orderEntryToAmount);
	}


	private void updateGuiTickets() {
		gui.writeTicketList(ticketList.stream().map(x -> x.getTicketEntry()).collect(Collectors.toList()),
							ticketList.stream().map(x -> "€ "+x.getTotalPrice()).collect(Collectors.toList()));
	}

	private void updateGuiSummary(HashMap<SummaryItem, Integer> summaryClassToAmount) {
		ArrayList<String> summary = new ArrayList<>(); 
		for (Entry<SummaryItem, Integer> summaryEntry : summaryClassToAmount.entrySet()) {
			summary.add(summaryEntry.getKey().getSummaryEntryRepresentation(summaryEntry.getValue()));
		}
		gui.writeSummaryList(summary);

	}
	
	private void updateGuiBbqList(HashMap<OrderEntry, Integer> orderEntryToAmount) {
		ArrayList<String> bbqList = new ArrayList<>(); 
		for (Entry<OrderEntry, Integer> entryToAmount : orderEntryToAmount.entrySet()) {
			bbqList.add(entryToAmount.getKey().getRepresentation(entryToAmount.getValue()));
		}
		gui.writeBbqList(bbqList);
	}

	public void deleteSelectedItem() {
		ticketList.remove(gui.getSelectedTicketIndex());
		updateGui();
	}

	public void deleteAllItems() {
		ticketList.clear();
		updateGui();
	}

	public double getTotalPrice() {
		return ticketList.stream().map(x -> x.getTotalPrice()).reduce(0.0, (a,b) -> a+b);
	}

	public void savePayment() {
		//TODO: implement
	}
}
