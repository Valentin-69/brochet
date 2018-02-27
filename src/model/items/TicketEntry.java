package model.items;

public class TicketEntry {

	private final Item item;
	private int amount;
	
	public TicketEntry(Item item, int amount) {
		this.item=item;
		this.amount=amount;
	}
	
	public double getTotalPrice() {
		return amount * item.getPricePerUnit();
	}
	
	public String getTicketEntry() {
		return Item.getRepresentationWithAmountAndName(amount, item.getTicketName());
	}
	
	public Item getItem() {
		return item;
	}
	
	public int getAmount(){
		return amount;
	}
	
}
