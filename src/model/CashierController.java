package model;

import model.items.Item;
import model.items.saucedItems.Sauce;
import model.items.saucedItems.SaucedItem;
import model.items.summaryItems.Bonnetje;
import model.items.summaryItems.Kalf;
import model.items.summaryItems.KipKip;
import model.items.summaryItems.KipRund;
import model.items.summaryItems.Kuiken;
import model.items.summaryItems.RundRund;
import model.items.summaryItems.Soup;
import model.items.summaryItems.VeggySimple;
import model.items.summaryItems.VeggyVeggy;
import model.items.summaryItems.Zalm;

public class CashierController {
	
	public static final Item KIP_KIP_NATUUR = new SaucedItem(new KipKip(), Sauce.NATUUR);
	public static final Item KIP_KIP_PROVENCAAL = new SaucedItem(new KipKip(), Sauce.PROVENCAAL);
	public static final Item KIP_KIP_STROGANOFF = new SaucedItem(new KipKip(), Sauce.STROGANOFF);
	public static final Item KIP_KIP_BEARNAISE = new SaucedItem(new KipKip(), Sauce.BEARNAISE);
	public static final Item KIP_KIP_APPELMOES = new SaucedItem(new KipKip(), Sauce.APPELMOES);
	
	public static final Item KIP_RUND_NATUUR = new SaucedItem(new KipRund(), Sauce.NATUUR);
	public static final Item KIP_RUND_PROVENCAAL = new SaucedItem(new KipRund(), Sauce.PROVENCAAL);
	public static final Item KIP_RUND_STROGANOFF = new SaucedItem(new KipRund(), Sauce.STROGANOFF);
	public static final Item KIP_RUND_BEARNAISE = new SaucedItem(new KipRund(), Sauce.BEARNAISE);
	public static final Item KIP_RUND_APPELMOES = new SaucedItem(new KipRund(), Sauce.APPELMOES);
	
	public static final Item RUND_RUND_NATUUR = new SaucedItem(new RundRund(), Sauce.NATUUR);
	public static final Item RUND_RUND_PROVENCAAL = new SaucedItem(new RundRund(), Sauce.PROVENCAAL);
	public static final Item RUND_RUND_STROGANOFF = new SaucedItem(new RundRund(), Sauce.STROGANOFF);
	public static final Item RUND_RUND_BEARNAISE = new SaucedItem(new RundRund(), Sauce.BEARNAISE);
	public static final Item RUND_RUND_APPELMOES = new SaucedItem(new RundRund(), Sauce.APPELMOES);
	
	public static final Item ZALM_NATUUR = new SaucedItem(new Zalm(), Sauce.NATUUR);
	public static final Item ZALM_PROVENCAAL = new SaucedItem(new Zalm(), Sauce.PROVENCAAL);
	public static final Item ZALM_STROGANOFF = new SaucedItem(new Zalm(), Sauce.STROGANOFF);
	public static final Item ZALM_BEARNAISE = new SaucedItem(new Zalm(), Sauce.BEARNAISE);
	public static final Item ZALM_APPELMOES = new SaucedItem(new Zalm(), Sauce.APPELMOES);
	
	public static final Item KUIKEN_NATUUR = new SaucedItem(new Kuiken(), Sauce.NATUUR);
	public static final Item KUIKEN_PROVENCAAL = new SaucedItem(new Kuiken(), Sauce.PROVENCAAL);
	public static final Item KUIKEN_STROGANOFF = new SaucedItem(new Kuiken(), Sauce.STROGANOFF);
	public static final Item KUIKEN_BEARNAISE = new SaucedItem(new Kuiken(), Sauce.BEARNAISE);
	public static final Item KUIKEN_APPELMOES = new SaucedItem(new Kuiken(), Sauce.APPELMOES);
	
	public static final Item KALF_NATUUR = new SaucedItem(new Kalf(), Sauce.NATUUR);
	public static final Item KALF_PROVENCAAL = new SaucedItem(new Kalf(), Sauce.PROVENCAAL);
	public static final Item KALF_STROGANOFF = new SaucedItem(new Kalf(), Sauce.STROGANOFF);
	public static final Item KALF_BEARNAISE = new SaucedItem(new Kalf(), Sauce.BEARNAISE);
	public static final Item KALF_APPELMOES = new SaucedItem(new Kalf(), Sauce.APPELMOES);

	public static final Item VEGGY_VEGGY_NATUUR = new SaucedItem(new VeggyVeggy(), Sauce.NATUUR);
	public static final Item VEGGY_VEGGY_PROVENCAAL = new SaucedItem(new VeggyVeggy(), Sauce.PROVENCAAL);
	public static final Item VEGGY_VEGGY_STROGANOFF = new SaucedItem(new VeggyVeggy(), Sauce.STROGANOFF);
	public static final Item VEGGY_VEGGY_BEARNAISE = new SaucedItem(new VeggyVeggy(), Sauce.BEARNAISE);
	public static final Item VEGGY_VEGGY_APPELMOES = new SaucedItem(new VeggyVeggy(), Sauce.APPELMOES);

	public static final Item VEGGY_NATUUR = new SaucedItem(new VeggySimple(), Sauce.NATUUR);
	public static final Item VEGGY_PROVENCAAL = new SaucedItem(new VeggySimple(), Sauce.PROVENCAAL);
	public static final Item VEGGY_STROGANOFF = new SaucedItem(new VeggySimple(), Sauce.STROGANOFF);
	public static final Item VEGGY_BEARNAISE = new SaucedItem(new VeggySimple(), Sauce.BEARNAISE);
	public static final Item VEGGY_APPELMOES = new SaucedItem(new VeggySimple(), Sauce.APPELMOES);

	public static final Item SOEP = new Soup();
	public static final Item BON = new Bonnetje();
	
	private int selectedNumber = 1;
		
	public CashierController() {
		// TODO Auto-generated constructor stub
	}
	
	public void selectNumber(int number) {
		selectedNumber=number;
	}
	
	public void backspace() {
		
	}

	public void addToTicket(Item item) {
		// TODO Auto-generated method stub
		
	}

	public void deleteSelectedItem() {
		// TODO Auto-generated method stub
		
	}

	public void deleteAllItems() {
		// TODO Auto-generated method stub
		
	}
}
