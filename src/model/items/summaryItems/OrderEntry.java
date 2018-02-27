package model.items.summaryItems;

import model.items.Item;

public enum OrderEntry {
	
	RUND{

		@Override
		public String getRepresentation(int amount) {
			return Item.getRepresentationWithAmountAndName(amount, "Rund");
		}
		
	},KIP{

		@Override
		public String getRepresentation(int amount) {
			return Item.getRepresentationWithAmountAndName(amount, "Kip");
		}
		
	},ZALM{

		@Override
		public String getRepresentation(int amount) {
			return Item.getRepresentationWithAmountAndName(amount, "Zalm");
		}
		
	},VEGGY{

		@Override
		public String getRepresentation(int amount) {
			return Item.getRepresentationWithAmountAndName(amount, "Veggy");
		}
		
	},TICKET{

		@Override
		public String getRepresentation(int amount) {
			return Item.getRepresentationWithAmountAndName(amount, "Bonnetje");
		}
		
	},SOUP{

		@Override
		public String getRepresentation(int amount) {
			return Item.getRepresentationWithAmountAndName(amount, "Soep");
		}
		
	};
	
	public abstract String getRepresentation(int amount);
	
}
