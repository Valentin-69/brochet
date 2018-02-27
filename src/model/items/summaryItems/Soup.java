package model.items.summaryItems;

import java.util.Arrays;
import java.util.List;

public class Soup extends SummaryItem {

	public Soup() {
		super(Arrays.asList(OrderEntry.SOUP), 4);
	}

	@Override
	public String getName() {
		return "Soep";
	}


}
