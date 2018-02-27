package model.items.summaryItems;

import java.util.List;

import model.items.Item;

public abstract class SummaryItem extends Item {

	private List<OrderEntry> orderEntries;
	private double price;
	
	public SummaryItem(List<OrderEntry> orderEntries, double price) {
		this.orderEntries=orderEntries;
		this.price=price;
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
	
}
