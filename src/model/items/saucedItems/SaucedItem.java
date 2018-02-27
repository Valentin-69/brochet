package model.items.saucedItems;

import model.items.Item;
import model.items.summaryItems.SummaryItem;

public class SaucedItem extends Item {

	private SummaryItem course;
	private Sauce sauce;
	
	public SaucedItem(SummaryItem course, Sauce sauce) {
		this.course=course;
		this.sauce=sauce;
	}
	
	@Override
	public SummaryItem getSummaryItem() {
		return course;
	}
	
	@Override
	public String getName() {
		return course.getName() + " " + sauce.toString();
	}

}
