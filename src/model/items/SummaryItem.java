package model.items;

import java.util.List;

public class SummaryItem extends Item {

	private List<OrderEntry> orderEntries;
	private double price;
	private String name;
	
	public SummaryItem(List<OrderEntry> orderEntries, double price, String name) {
		this.orderEntries=orderEntries;
		this.price=price;
		this.name=name;
	}
	
	public List<OrderEntry> getOrderEntries() {
		return orderEntries;
	}
	
	@Override
	public double getPricePerUnit() {
		return price;
	}
	
	@Override
	public SummaryItem getSummaryItem() {
		return this;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public String getSummaryEntryRepresentation(int amount){
		return Item.getRepresentationWithAmountAndName(amount, getName());
	}
	
}
