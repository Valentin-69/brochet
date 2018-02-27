package model.items.summaryItems;

import java.util.Arrays;

public class KipRund extends SummaryItem {

	public KipRund() {
		super(Arrays.asList(OrderEntry.KIP,OrderEntry.RUND), 15);
	}

	@Override
	public String getName() {
		return "Kip Rund";
	}

}
