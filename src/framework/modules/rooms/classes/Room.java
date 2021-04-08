package framework.modules.rooms.classes;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import framework.modules.fecha.CustomDate;
import framework.modules.languages.Language;
import framework.modules.rooms.utils.orderChair;

public abstract class Room implements Comparable<Room> {
	// PROPIEDADES DEL OBJETO
	private String numRoom;
	private CustomDate dateEntry;
	private CustomDate dateExit;
//	@validadorHoras()
	private String hourEntry;
	private String hourExit;
	private int numBeds;
	private int numPerson;
	private float price;
	public final float IVA = (float) 0.10;
	private boolean wifi;
	private boolean available;

	public Room(String numRoom, CustomDate dateEntry, CustomDate dateExit, String hourEntry, String hourExit, int numBeds, int numPerson, boolean wifi, boolean available) {
		super();
		this.numRoom = numRoom;
		this.dateEntry = dateEntry;
		this.dateExit = dateExit;
		this.hourEntry = hourEntry;
		this.hourExit = hourExit;
		this.numBeds = numBeds;
		this.numPerson = numPerson;
//		this.price = price;
		this.wifi = wifi;
		this.available = available;
	}

	public Room() throws ParseException {
		super();
		CustomDate dateActually = new CustomDate();
		this.numRoom = "default";
		this.dateEntry = dateActually;
		this.dateExit = dateActually;
		this.hourEntry = "default";
		this.hourExit = "default";
		this.numBeds = 0;
		this.numPerson = 0;
		this.price = 0;
		this.wifi = false;
		this.available = false;
	}

	public float getPriceTotal_With_IVA() {
		return this.price * getDaysDifference() * (1 + this.IVA);
	}

	public float getPriceTotal_Without_IVA() {
		return this.price * getDaysDifference();
	}

	public float getDiscount() {

		float discount = 0;
		if (getDaysDifference() > 7)
			discount = (float) 0.15;
		return discount;

	}

	public Room(String numRoom) {
		this.numRoom = numRoom;
	}

	public String getNumRoom() {
		return numRoom;
	}

	public void setNumRoom(String numRoom) {
		this.numRoom = numRoom;
	}

	public int getDaysDifference() {
		return dateEntry.diferencesInDays(dateExit);
	}

	public CustomDate getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(CustomDate dateEntry) {
		this.dateEntry = dateEntry;
	}

	public void setDateEntry(String dateEntry) throws ParseException {
		CustomDate dateEntryCustomDate = new CustomDate(dateEntry);
		this.dateEntry = dateEntryCustomDate;
	}

	public CustomDate getDateExit() {
		return dateExit;
	}

	public void setDateExit(CustomDate dateExit) {
		this.dateExit = dateExit;
	}

	public void setDateExit(String dateExit) throws ParseException {
		CustomDate dateExitCustomDate = new CustomDate(dateExit);

		this.dateExit = dateExitCustomDate;
	}

	public String getHourEntry() {
		return hourEntry;
	}

	public void setHourEntry(String hourEntry) {
		this.hourEntry = hourEntry;
	}

	public String getHourExit() {
		return hourExit;
	}

	public void setHourExit(String hourExit) {
		this.hourExit = hourExit;
	}

	public int getNumBeds() {
		return numBeds;
	}

	public void setNumBeds(int numBeds) {
		this.numBeds = numBeds;
	}

	public int getNumPerson() {
		return numPerson;
	}

	public void setNumPerson(int numPerson) {
		this.numPerson = numPerson;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float prices) {
		this.price = 0;
		float priceWifi = 0;
		if (this.wifi == true)
			priceWifi = 3;
		this.price = (this.numBeds * 7) + (this.numPerson * 5) + priceWifi;
		this.price += prices;
		this.price -= (0.05);

	}

//	public void setPrice(float price) {
//		this.price = price;
//	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	protected static ArrayList<String> toGetVariablesRoom() {

		ArrayList<String> AttributesRoom = new ArrayList<String>();
//		AttributesRoom.add("type");
		AttributesRoom.add("numRoom");
		AttributesRoom.add("dateEntry");
		AttributesRoom.add("dateExit");
		AttributesRoom.add("hourEntry");
		AttributesRoom.add("hourExit");
		AttributesRoom.add("numBeds");
		AttributesRoom.add("numPerson");
		AttributesRoom.add("price");
		AttributesRoom.add("wifi");
		AttributesRoom.add("available");

		return AttributesRoom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numRoom == null) ? 0 : numRoom.hashCode());
		return result;
	}

	public boolean equals(Object obj) {

		return getNumRoom().equals(((Room) obj).getNumRoom());
	}

	public String toString_No_Price() {
		Language language = Language.getInstance();
		DecimalFormat twoDecimal = new DecimalFormat("#.##€");
		String chain = "";

		chain += orderChair.AddLineText(language.getProperty("room.NumRoom"), this.numRoom);
		chain += orderChair.AddLineText(language.getProperty("room.PriceForDay"), twoDecimal.format(this.price));

		chain += orderChair.AddLineText(language.getProperty("room.EntryDate"), this.dateEntry.toString());
		chain += orderChair.AddLineText(language.getProperty("room.ExitDate"), this.dateExit.toString());
		chain += orderChair.AddLineText(language.getProperty("room.DifferenceDays"), getDaysDifference());
		chain += orderChair.AddLineText(language.getProperty("room.EntryHour"), this.hourEntry + "h");
		chain += orderChair.AddLineText(language.getProperty("room.ExitHour"), this.hourExit + "h");
		chain += orderChair.AddLineText(language.getProperty("room.Beds"), this.numBeds);
		chain += orderChair.AddLineText(language.getProperty("room.Persons"), this.numPerson);
		chain += orderChair.AddLineText(language.getProperty("room.Wifi"), this.wifi);
		chain += orderChair.AddLineText(language.getProperty("room.Available"), this.available);

		return chain;
	}

	public String toString_Price() {
		Language language = Language.getInstance();
		DecimalFormat twoDecimal = new DecimalFormat("#.##€");
		float priceWithoutIVA = getPriceTotal_Without_IVA();
		float discount = getDiscount();

		String chain = orderChair.AddJumpLine();
		if (getDiscount() != 0) {
			chain += orderChair.AddLineText(language.getProperty("room.Subtotal"), twoDecimal.format(priceWithoutIVA));
			chain += orderChair.AddLineText(language.getProperty("room.Discount"), (int) (discount * 100) + "%");
			chain += orderChair.AddLineText(language.getProperty("room.TotalDiscount"), twoDecimal.format(priceWithoutIVA * discount));
			chain += orderChair.AddLineText(language.getProperty("room.SubtotalWithDiscount"), twoDecimal.format(priceWithoutIVA * (1 - discount)));
			chain += orderChair.AddLineText(language.getProperty("room.IVA"), language.getProperty("room.IVAInt"));
			chain += orderChair.AddLineText(language.getProperty("room.TotalIVA"), ((twoDecimal.format(priceWithoutIVA * (1 - discount) * IVA))));
			chain += orderChair.AddLineText(language.getProperty("room.TotalPrice"), twoDecimal.format(getPriceTotal_With_IVA() * (1 - discount)));
		} else {
			chain += orderChair.AddLineText(language.getProperty("room.Subtotal"), twoDecimal.format(priceWithoutIVA));
			chain += orderChair.AddLineText(language.getProperty("room.IVA"), language.getProperty("room.IVAInt"));
			chain += orderChair.AddLineText(language.getProperty("room.TotalIVA"), ((twoDecimal.format(priceWithoutIVA * IVA))));
			chain += orderChair.AddLineText(language.getProperty("room.TotalPrice"), twoDecimal.format(getPriceTotal_With_IVA()));
		}

		return chain;
	}
//	 public ArrayList<String> GetVariables() {
///

//	}

}
