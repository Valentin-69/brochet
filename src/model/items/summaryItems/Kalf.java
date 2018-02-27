package model.items.summaryItems;

import java.util.Arrays;

public class Kalf extends SummaryItem {

	public Kalf() {
		super(Arrays.asList(OrderEntry.RUND), 10);
	}

	@Override
	public String getName() {
		return "Rund (1)";
	}

}
