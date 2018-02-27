package model.items.summaryItems;

import java.util.Arrays;

public class RundRund extends SummaryItem {

	public RundRund() {
		super(Arrays.asList(OrderEntry.RUND,OrderEntry.RUND), 15);
	}

	@Override
	public String getName() {
		return "Rund (2)";
	}

}
