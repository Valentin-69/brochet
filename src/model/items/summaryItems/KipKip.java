package model.items.summaryItems;

import java.util.Arrays;

public class KipKip extends SummaryItem {

	public KipKip() {
		super(Arrays.asList(OrderEntry.KIP,OrderEntry.KIP), 15);
	}

	@Override
	public String getName() {
		return "Kip (2)";
	}


}
