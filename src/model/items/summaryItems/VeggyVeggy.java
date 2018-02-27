package model.items.summaryItems;

import java.util.Arrays;

public class VeggyVeggy extends SummaryItem {

	public VeggyVeggy() {
		super(Arrays.asList(OrderEntry.VEGGY,OrderEntry.VEGGY), 15);
	}

	@Override
	public String getName() {
		return "Veggy (2)";
	}

}
