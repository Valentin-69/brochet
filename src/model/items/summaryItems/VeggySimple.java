package model.items.summaryItems;

import java.util.Arrays;
import java.util.List;

public class VeggySimple extends SummaryItem {

	public VeggySimple() {
		super(Arrays.asList(OrderEntry.VEGGY), 10);
	}

	@Override
	public String getName() {
		return "Veggy (1)";
	}

}
