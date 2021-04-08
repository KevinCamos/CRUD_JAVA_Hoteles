package framework.modules.rooms.utils;

import java.text.ParseException;
import java.util.ArrayList;

import framework.modules.fecha.CustomDate;
import framework.modules.rooms.classes.Room;
import framework.modules.rooms.classes.Single;
import framework.modules.rooms.classes.Suite;
import framework.modules.rooms.classes.Twice;

/**
 * Esta clase ha sido creada para hacer funciones relacionadas con el
 * polimorfismo.
 * 
 * 
 * @author Kevin Camós Soto
 *
 */
public class polymorphism {
	public static Room createRoom(int RoomType) throws ParseException {
		Room roomMakingOff = null;

		String numRoom, dateEntrySTRING, dateExitSTRING, hourEntry, hourExit, welcomeGift;
		int numBeds, numPerson;
		float price;
		boolean wifi = false, available = false, jacuzzi = false, minibar = false, gameConsole = false;
		// String

//		type = framework.objectsclass.rooms.utils.valida_attribute.RoomGetAttributeString(0);
		numRoom = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(1);
		dateEntrySTRING = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(2);
		dateExitSTRING = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(3);
		CustomDate dateEntry = new CustomDate(dateEntrySTRING);
		CustomDate dateExit = new CustomDate(dateExitSTRING);
		hourEntry = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(4);
		hourExit = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(5);
		// int

		numBeds = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeInt(0);
		numPerson = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeInt(1);
		// float
		price = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeFloat(0);
		// boolean
		wifi = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(0);
		available = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(1);
		if (RoomType == 0) {// Single Room

			gameConsole = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(4);

			roomMakingOff = new Single(numRoom, dateEntry, dateExit, hourEntry, hourExit, numBeds, price, numPerson,
					wifi, available, gameConsole);
			return roomMakingOff;

		} else if (RoomType == 1)// Twice Room
		{

			welcomeGift = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(6);

			roomMakingOff = new Twice(numRoom, dateEntry, dateExit, hourEntry, hourExit, numBeds, price, numPerson,
					wifi, available, welcomeGift);
			return roomMakingOff;
		} else if (RoomType == 2)// suite
		{

			welcomeGift = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(6);

			jacuzzi = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(2);
			minibar = framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(3);

			roomMakingOff = new Suite(numRoom, dateEntry, dateExit, hourEntry, hourExit, numBeds, price, numPerson,
					wifi, available, jacuzzi, minibar, welcomeGift);
			return roomMakingOff;
		}
		return roomMakingOff;

	}

	/**
	 * Hay que crear esta función para modificar atributos. UPDATE
	 * 
	 * @param roomMakingOff
	 * @return
	 * @throws ParseException
	 */
	public static Object modifyAttributesRoom(Object roomMakingOff, int roomType) throws ParseException {
		String OptionsAttribute;

		ArrayList<String> AttributeName = new ArrayList<String>();

		if (roomType == 0) {
			AttributeName.addAll(framework.modules.rooms.classes.Single.toGetVariableSingle());
		} else if (roomType == 1) {
			AttributeName.addAll(framework.modules.rooms.classes.Twice.toGetVariableTwice());

		} else if (roomType == 2) {
			AttributeName.addAll(framework.modules.rooms.classes.Suite.toGetVariableSuite());
			// String UpdateString = funciones.menu.menu_combo("¿Qué atributo deseas
			// modificar?", "Update", );
		}

		String[] AttributeString = AttributeName.toArray(new String[0]);

		OptionsAttribute = framework.utils.menu.menu_combo_no_closed_null("What attribute do you want modify?",
				"Update", AttributeString);
		roomMakingOff = UpdateAttributes(roomMakingOff, OptionsAttribute, roomType);
		return roomMakingOff;

	}

	private static Object UpdateAttributes(Object roomMakingOff, String OptionsAttribute, int roomType)
			throws ParseException {
///private static object si al final faig la 
		if (roomType == 0) {
			switch (OptionsAttribute) {

//			case "type" -> ((single) roomMakingOff)
//					.setType(framework.objectsclass.rooms.utils.valida_attribute.RoomGetAttributeString(0));
			case "numRoom" -> ((Single) roomMakingOff)
					.setNumRoom(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(1));
			case "dateEntry" -> ((Single) roomMakingOff)
					.setDateEntry(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(2));
			case "dateExit" -> ((Single) roomMakingOff)
					.setDateExit(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(3));
			case "hourEntry" -> ((Single) roomMakingOff)
					.setHourEntry(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(4));
			case "hourExit" -> ((Single) roomMakingOff)
					.setHourExit(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(5));
			case "numBeds" -> ((Single) roomMakingOff)
					.setNumBeds(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeInt(0));
			case "numPerson" -> ((Single) roomMakingOff)
					.setNumPerson(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeInt(1));
			case "price" -> ((Single) roomMakingOff)
					.setPrice(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeFloat(0));
			case "wifi" -> ((Single) roomMakingOff)
					.setWifi(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(0));
			case "available" -> ((Single) roomMakingOff)
					.setAvailable(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(1));
			case "consoleGame" -> ((Single) roomMakingOff)
					.setGameConsole(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(4));
			}
		} else if (roomType == 1) {
			switch (OptionsAttribute) {

//			case "type" -> ((twice) roomMakingOff)
//					.setType(framework.objectsclass.rooms.utils.valida_attribute.RoomGetAttributeString(0));
			case "numRoom" -> ((Twice) roomMakingOff)
					.setNumRoom(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(1));
			case "dateEntry" -> ((Twice) roomMakingOff)
					.setDateEntry(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(2));
			case "dateExit" -> ((Twice) roomMakingOff)
					.setDateExit(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(3));
			case "hourEntry" -> ((Twice) roomMakingOff)
					.setHourEntry(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(4));
			case "hourExit" -> ((Twice) roomMakingOff)
					.setHourExit(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(5));
			case "numBeds" -> ((Twice) roomMakingOff)
					.setNumBeds(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeInt(0));
			case "numPerson" -> ((Twice) roomMakingOff)
					.setNumPerson(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeInt(1));
			case "price" -> ((Twice) roomMakingOff)
					.setPrice(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeFloat(0));
			case "wifi" -> ((Twice) roomMakingOff)
					.setWifi(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(0));
			case "available" -> ((Twice) roomMakingOff)
					.setAvailable(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(1));
			case "welcomeGift" -> ((Twice) roomMakingOff)
					.setWelcomeGift(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(6));
			}

		} else if (roomType == 2) {
			switch (OptionsAttribute) {

//			case "type" -> ((suite) roomMakingOff)
//					.setType(framework.objectsclass.rooms.utils.valida_attribute.RoomGetAttributeString(0));
			case "numRoom" -> ((Suite) roomMakingOff)
					.setNumRoom(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(1));
			case "dateEntry" -> ((Suite) roomMakingOff)
					.setDateEntry(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(2));
			case "dateExit" -> ((Suite) roomMakingOff)
					.setDateExit(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(3));
			case "hourEntry" -> ((Suite) roomMakingOff)
					.setHourEntry(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(4));
			case "hourExit" -> ((Suite) roomMakingOff)
					.setHourExit(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(5));
			case "numBeds" -> ((Suite) roomMakingOff)
					.setNumBeds(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeInt(0));
			case "numPerson" -> ((Suite) roomMakingOff)
					.setNumPerson(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeInt(1));
			case "price" -> ((Suite) roomMakingOff)
					.setPrice(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeFloat(0));
			case "wifi" -> ((Suite) roomMakingOff)
					.setWifi(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(0));
			case "available" -> ((Suite) roomMakingOff)
					.setAvailable(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(1));
			case "jacuzzi" -> ((Suite) roomMakingOff)
					.setJacuzzi(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(2));
			case "minibar" -> ((Suite) roomMakingOff)
					.setMinibar(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeBoolean(3));
			case "welcomeGift" -> ((Suite) roomMakingOff)
					.setWelcomeGift(framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(6));
			}
		}
		return roomMakingOff;

	}
}