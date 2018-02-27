package model.items.summaryItems;

import java.util.Arrays;

public class Kuiken extends SummaryItem {

	public Kuiken() {
		super(Arrays.asList(OrderEntry.KIP), 10);
	}

	@Override
	public String getName() {
		return "Kip (1)";
	}


}
