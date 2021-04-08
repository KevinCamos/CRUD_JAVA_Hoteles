package framework.modules.rooms.classes;

import java.text.ParseException;
import java.util.ArrayList;

import framework.modules.fecha.CustomDate;
import framework.modules.languages.Language;
import framework.modules.rooms.utils.orderChair;

public class Suite extends Room {

	private boolean jacuzzi;
	private boolean minibar;
	private String welcomeGift;

	public Suite(String numRoom, CustomDate dateEntry, CustomDate dateExit, String hourEntry, String hourExit, int numBeds, int numPerson, boolean wifi, boolean available, boolean jacuzzi, boolean minibar, String welcomeGift) {
		super(numRoom, dateEntry, dateExit, hourEntry, hourExit, numBeds, numPerson, wifi, available);
		this.jacuzzi = jacuzzi;
		this.minibar = minibar;
		this.welcomeGift = welcomeGift;
		this.calculatePrice();
	}

	public Suite() throws ParseException {
		super();
		this.jacuzzi = false;
		this.minibar = false;
		this.welcomeGift = "default";
	}

	public Suite(String numRoom) {
		super(numRoom);
	}

	public boolean isJacuzzi() {
		return jacuzzi;
	}

	public void setJacuzzi(boolean jacuzzi) {
		this.jacuzzi = jacuzzi;
	}

	public boolean isMinibar() {
		return minibar;
	}

	public void setMinibar(boolean minibar) {
		this.minibar = minibar;
	}

	public String getWelcomeGift() {
		return welcomeGift;
	}

	public void setWelcomeGift(String welcomeGift) {
		this.welcomeGift = welcomeGift;
	}

	public void calculatePrice() {
		int pricewelcomeGift = 0;
		int priceJacuzzi = 0;
		int priceMinibar = 0;
		float priceFinal = 50;
		if (this.jacuzzi == true)
			priceJacuzzi = 30;
		if (this.minibar == true)
			priceMinibar = 20;
		if (this.welcomeGift == "Nada" || this.welcomeGift == "Nothing" || this.welcomeGift == "Default")
			pricewelcomeGift = 5;

		super.setPrice(priceFinal + priceJacuzzi + priceMinibar + pricewelcomeGift);
	}

	public static ArrayList<String> toGetVariableSuite() {
		ArrayList<String> AttributesRoom = new ArrayList<String>();
		AttributesRoom.addAll(Room.toGetVariablesRoom());
		AttributesRoom.add("Jacuzzi");
		AttributesRoom.add("minibar");
		AttributesRoom.add("welcomeGift");

		return AttributesRoom;
	}

	@Override
	public String toString() {
		Language language = Language.getInstance();
//		this.calculatePrice();

		String chain = "";
		chain += orderChair.AddLineTitle(language.getProperty("suite.TITLE"));
		chain += super.toString_No_Price();
		chain += orderChair.AddLineText(language.getProperty("suite.Jacuzzi"), jacuzzi);
		chain += orderChair.AddLineText(language.getProperty("suite.Minibar"), minibar);
		chain += orderChair.AddLineText(language.getProperty("suite.WelcomGift"), welcomeGift);
		chain += super.toString_Price();
		return chain;

	}

	@Override
	public int compareTo(Room arg0) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}