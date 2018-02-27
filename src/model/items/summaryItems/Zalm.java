package model.items.summaryItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zalm extends SummaryItem {

	public Zalm() {
		super(new ArrayList<OrderEntry>(Arrays.asList(OrderEntry.ZALM)), 15);
	}

	@Override
	public String getName() {
		return "Zalm";
	}


}
