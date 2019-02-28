package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		gui.setTotal(getTotalPrice());
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
		try {
			saveAsJson();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			saveInExcel();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void saveAsJson() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		FileOutputStream stream = new FileOutputStream(new File("logs/"+Clock.toLogFormat(Calendar.getInstance().getTime())+".json"));
		mapper.writeValue(stream, getLogFrom(ticketList));
		stream.close();
	}

	private Log getLogFrom(List<TicketEntry> ticketList) {
		return new Log(ticketList);
	}

	private void saveInExcel() throws IOException {
		int adultBrochet = 0;
		int childBrochet = 0;
		int salmon = 0;
		int adultVeggy = 0;
		int childVeggy = 0;
		int tickets = 0;
		for (TicketEntry ticketEntry : ticketList) {
			if(ticketEntry.getItem().getSummaryItem().equals(RUND_RUND)||ticketEntry.getItem().getSummaryItem().equals(KIP_KIP)||ticketEntry.getItem().getSummaryItem().equals(KIP_RUND) ) {
				adultBrochet+=ticketEntry.getAmount();
			}
			if(ticketEntry.getItem().getSummaryItem().equals(KALF)||ticketEntry.getItem().getSummaryItem().equals(KUIKEN)) {
				childBrochet+=ticketEntry.getAmount();
			}
			if(ticketEntry.getItem().getSummaryItem().equals(ZALM)) {
				salmon+=ticketEntry.getAmount();
			}
			if(ticketEntry.getItem().getSummaryItem().equals(VEGGY_VEGGY)) {
				adultVeggy+=ticketEntry.getAmount();
			}
			if(ticketEntry.getItem().getSummaryItem().equals(VEGGY)) {
				childVeggy+=ticketEntry.getAmount();
			}
			if(ticketEntry.getItem().getSummaryItem().equals(BON)) {
				tickets+=ticketEntry.getAmount();
			}
		}

		FileInputStream in = new FileInputStream(new File("logs/AFBLIJVEN.xlsx"));
		XSSFWorkbook book = new XSSFWorkbook(in);
		in.close();
		XSSFSheet sheet = book.getSheetAt(Clock.getSheet(Calendar.getInstance().getTime()));
		XSSFRow row = sheet.createRow(sheet.getLastRowNum()+1);
		int i=0;
		row.createCell(i++).setCellValue("Brochet Volwassen: ");
		row.createCell(i++).setCellValue(adultBrochet);
		row.createCell(i++).setCellValue("    ");
		row.createCell(i++).setCellValue("Brochet Kind: ");
		row.createCell(i++).setCellValue(childBrochet);
		row.createCell(i++).setCellValue("    ");
		row.createCell(i++).setCellValue("Zalm: ");
		row.createCell(i++).setCellValue(salmon);
		row.createCell(i++).setCellValue("    ");
		row.createCell(i++).setCellValue("Veggy Volwassen: ");
		row.createCell(i++).setCellValue(adultVeggy);
		row.createCell(i++).setCellValue("    ");
		row.createCell(i++).setCellValue("Veggy Kind: ");
		row.createCell(i++).setCellValue(childVeggy);
		row.createCell(i++).setCellValue("    ");
		row.createCell(i++).setCellValue("Bonnekes: ");
		row.createCell(i++).setCellValue(tickets);
		row.createCell(i++).setCellValue("    ");
		row.createCell(i++).setCellValue("Prijs: ");
		row.createCell(i++).setCellValue(adultBrochet*15+childBrochet*10+salmon*15+adultVeggy*15+childVeggy*10+tickets*1.8);
		row.createCell(i++).setCellValue("    ");
		for(int j =0;j<i;j++) {
			sheet.autoSizeColumn(j);
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("logs/AFBLIJVEN.xlsx"));
			book.write(out);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("samenvatting.xlsx"));
			book.write(out);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		book.close();
	}
}
