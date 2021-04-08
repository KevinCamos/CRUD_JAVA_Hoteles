package framework.modules.rooms.classes;

import java.text.ParseException;
import java.util.ArrayList;

import framework.modules.fecha.CustomDate;
import framework.modules.languages.Language;
import framework.modules.rooms.utils.orderChair;

public class Single extends Room {
	private boolean gameConsole;

	public Single(String numRoom, CustomDate dateEntry, CustomDate dateExit, String hourEntry, String hourExit, int numBeds, int numPerson, boolean wifi, boolean available, boolean gameConsole) {
		super(numRoom, dateEntry, dateExit, hourEntry, hourExit, numBeds, numPerson, wifi, available);
		this.gameConsole = gameConsole;
		this.calculatePrice();

	}

	public Single() throws ParseException { // Constructor para crear clases con valores por defectos.
		super();
		this.gameConsole = false;
	}

	public Single(String numRoom) {
		super(numRoom);
	}

	public boolean isGameConsole() {
		return gameConsole;
	}

	public void setGameConsole(boolean gameConsole) {
		this.gameConsole = gameConsole;
	}

	/**
	 * SetPrice de Single
	 * 
	 */
	public void calculatePrice() {
		int priceConsole = 0;
		float priceFinal = 10;

		if (this.gameConsole == true)
			priceConsole = 6;
		super.setPrice(priceFinal + priceConsole);
	}

	public static ArrayList<String> toGetVariableSingle() {
		ArrayList<String> AttributesRoom = new ArrayList<String>();
		AttributesRoom.addAll(Room.toGetVariablesRoom());
		AttributesRoom.add("gameConsole");
		return AttributesRoom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (gameConsole ? 1231 : 1237);
		return result;
	}

	@Override
	public int compareTo(Room arg0) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

	@Override
	public String toString() {
		Language language = Language.getInstance();
		this.calculatePrice();

		String chain = "";
		chain += orderChair.AddLineTitle(language.getProperty("single.TITLE"));
		chain += super.toString_No_Price();
		chain += orderChair.AddLineText(language.getProperty("single.GameConsole"), gameConsole);
		chain += super.toString_Price();
		return chain;
	}

}