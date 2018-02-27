package model.items;

import model.items.summaryItems.SummaryItem;

public abstract class Item {

	public abstract String getName();
	
	public double getPricePerUnit() {
		if(getSummaryItem()!=null) {
			return getSummaryItem().getPricePerUnit();
		}else {
			return 0;
		}
	}
	
	public String getTicketName() {
		if(getSummaryItem()!=null) {
			return getSummaryItem().getTicketName();
		}else {
			return null;
		}
	}
	
	public abstract SummaryItem getSummaryItem();
	
	public static String getRepresentationWithAmountAndName(int amount, String name) {
		return amount+"x "+name;
	}
	
}
