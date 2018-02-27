package model.items.summaryItems;

import java.util.Arrays;

public class Bonnetje extends SummaryItem {

	public Bonnetje() {
		super(Arrays.asList(OrderEntry.TICKET), 1.8);
	}

	@Override
	public String getName() {
		return "Bon";
	}

}
