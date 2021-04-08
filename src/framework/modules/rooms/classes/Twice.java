package framework.modules.rooms.classes;

import java.text.ParseException;
import java.util.ArrayList;

import framework.modules.fecha.CustomDate;
import framework.modules.languages.Language;
import framework.modules.rooms.utils.orderChair;

public class Twice extends Room {
	private String welcomeGift;

	public Twice(String numRoom, CustomDate dateEntry, CustomDate dateExit, String hourEntry, String hourExit, int numBeds, int numPerson, boolean wifi, boolean available, String welcomeGift) {
		super(numRoom, dateEntry, dateExit, hourEntry, hourExit, numBeds, numPerson, wifi, available);
		this.welcomeGift = welcomeGift;
		this.setPrice();
	}

	public Twice() throws ParseException {
		super();
		this.welcomeGift = "default";
	}

	public Twice(String numRoom) {
		super(numRoom);
	}

	public String getWelcomeGift() {
		return welcomeGift;
	}

	public void setWelcomeGift(String welcomeGift) {
		this.welcomeGift = welcomeGift;
	}

	public void setPrice() {
		int pricewelcomeGift = 0;
		float priceFinal = 20;

		if (this.welcomeGift == "Nada" || this.welcomeGift == "Nothing" || this.welcomeGift == "Default")
			pricewelcomeGift = 5;
		super.setPrice(priceFinal + pricewelcomeGift);
	}

	public static ArrayList<String> toGetVariableTwice() {
		ArrayList<String> AttributesRoom = new ArrayList<String>();
		AttributesRoom.addAll(Room.toGetVariablesRoom());
		AttributesRoom.add("welcomeGift");

		return AttributesRoom;
	}

	public String toString() {
		Language language = Language.getInstance();

//		this.setPrice();

		String chain = "";
		chain += orderChair.AddLineTitle(language.getProperty("twice.TITLE"));
		chain += super.toString_No_Price();
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
