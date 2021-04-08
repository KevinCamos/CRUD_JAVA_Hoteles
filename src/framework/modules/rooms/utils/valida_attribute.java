package framework.modules.rooms.utils;

import java.text.ParseException;

import javax.swing.JOptionPane;

import framework.modules.fecha.CustomDate;
import framework.utils.format;
import framework.utils.valida;

public class valida_attribute {

	/**
	 * Esta función devuelve los String dentro de un cuadro JOptionPane en el que se
	 * introducen los datos para los atributos
	 * 
	 * @param AttributeNumber
	 * @return
	 */
	public static String RoomGetAttributeString(int AttributeNumber) {
		String AttributeValue = "";
		boolean validate = true;
		switch (AttributeNumber) {
			case 0: {
				do {

					AttributeValue = valida.valida_String("Insert Room Type", "Room Type");
				} while (validate == false);
				break;
			}
			case 1: {

				do {
					AttributeValue = valida.valida_String("Insert Room Name\nFORMAT 000-A", "Room Name");
					AttributeValue = AttributeValue.toUpperCase();
					validate = format.nameRoom(AttributeValue);
					if (validate == false)
						JOptionPane.showMessageDialog(null, "You have not entered a Room Name correctly", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				} while (validate == false);
				break;

			}
			case 2: {

				do {
					AttributeValue = valida.valida_String("Insert Entry Date\n\nFORMAT:\ndd/mm/yyyy", "Entry Date");
					validate = format.date(AttributeValue);
					if (validate == false)
						JOptionPane.showMessageDialog(null, "You have not entered a date correctly", "ERROR", JOptionPane.INFORMATION_MESSAGE);

				} while (validate == false);
				break;

			}
//		case 3: {
//
//			do {
//				AttributeValue = valida.valida_String("Insert Exit Date\n\nFORMAT:\ndd/mm/yyyy", "Exit Date");
//				validate = DatesUtils.ValidaDate(AttributeValue);
//
//				if (validate == false)
//					JOptionPane.showMessageDialog(null, "You have not entered a date correctly", "ERROR",
//							JOptionPane.INFORMATION_MESSAGE);
//			} while (validate == false);
//
//		}
			case 4: {

				do {
					AttributeValue = framework.utils.valida.valida_String("Insert Entry Hour\nFORMAT: 00:00", "Entry Hour");
					validate = format.hour(AttributeValue);
					if (validate == false)
						JOptionPane.showMessageDialog(null, "You have not entered a hour correctly", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				} while (validate == false);
				break;
			}
			case 5: {

				do {

					AttributeValue = valida.valida_String("Insert Exit Hour\nFORMAT: 00:00", "Exit Hour");
					validate = format.hour(AttributeValue);
					if (validate == false)
						JOptionPane.showMessageDialog(null, "You have not entered a hour correctly", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				} while (validate == false);
				break;

			}
			case 6: {

				do {

					AttributeValue = valida.valida_String("What welcome gift does this room have?", "Welcome Gift");
				} while (validate == false);
				break;

			}
			default: {
				JOptionPane.showMessageDialog(null, "This Attribute doesn't exist", "ERROR", JOptionPane.ERROR_MESSAGE);

			} // End Create
		}
		return AttributeValue;

	}

	/**
	 * Esta función devuelve los "int" dentro de un cuadro JOptionPane en el que se
	 * introducen los datos para los atributos
	 * 
	 * @author Kevin Camós Soto
	 * @param AttributeNumber
	 * @return
	 */
	public static int RoomGetAttributeInt(int AttributeNumber) {
		int AttributeValue = 0;
		String cadMessage = "";
		String cadTitle = "";

		if (AttributeNumber == 0) {
			cadMessage = "Inserta el número de camas";
			cadTitle = "Camas";
		} else if (AttributeNumber == 1) {
			cadMessage = "Inserta el número de personas";
			cadTitle = "Personas";

		}
		if (AttributeNumber >= 0 || AttributeNumber <= 1) {
			AttributeValue = valida.valida_int(cadMessage, cadTitle);

		} else {
			JOptionPane.showMessageDialog(null, "NO EXISTE ESTE ATRIBUTO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return AttributeValue;
	}// End Create

	/**
	 * Esta función devuelve los "float" dentro de un cuadro JOptionPane en el que
	 * se introducen los datos para los atributos
	 * 
	 * @author Kevin Camós Soto
	 * @param AttributeNumber
	 * @return
	 */
	public static float RoomGetAttributeFloat(int AttributeNumber) {
		float AttributeValue = 0;
		boolean validate = true;
		if (AttributeNumber == 0) {
			do {
				AttributeValue = valida.valida_float("Insert Price\nINTEGER,XX", "Price");
				validate = framework.utils.format.price(AttributeValue);
				if (validate == false)
					JOptionPane.showMessageDialog(null, "You have not entered a price correctly", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			} while (validate == false);

		} else {
			JOptionPane.showMessageDialog(null, "NO EXISTE ESTE ATRIBUTO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return AttributeValue;
	}// End Create

	/**
	 * Esta función devuelve los "boolean" dentro de un cuadro JOptionPane en el que
	 * se introducen los datos para los atributos
	 * 
	 * @author Kevin Camós Soto
	 * @param AttributeNumber
	 * @return
	 */
	public static boolean RoomGetAttributeBoolean(int AttributeNumber) {
		boolean AttributeValue = false;
		String cadMessage = "";
		String cadTitle = "";
		switch (AttributeNumber) {
			case 0: {
				cadMessage = "¿Tiene WI-FI?";
				cadTitle = "WI-FI";
				break;

			}
			case 1: {
				cadMessage = "¿Se encuentra actualmente disponible?";
				cadTitle = "Disponibilidad";
				break;

			}
			case 2: {
				cadMessage = "¿Tiene Jacuzzi?";
				cadTitle = "Jacuzzi";
				break;

			}
			case 3: {
				cadMessage = "¿Tiene minibar?";
				cadTitle = "Minibar";
				break;

			}
			case 4: {
				cadMessage = "¿Tiene videoconsola?";
				cadTitle = "gameConsole";
				break;

			}
		}

		if (AttributeNumber >= 0 || AttributeNumber <= 1) {
			AttributeValue = valida.valida_boolean(cadMessage, cadTitle);

		} else {
			JOptionPane.showMessageDialog(null, "NO EXISTE ESTE ATRIBUTO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return AttributeValue;
	}// End Create
		////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		// VALIDADOR DE ATRIBUTOS ESPECÍFICOS

	public static CustomDate RoomGetAttributeCustomDateEntry() throws ParseException {
		while (true) {
			CustomDate date = valida.valida_CustomDate_botons("Insert Entry Date");
			if (date.compareTo() != -1)
				return date;
		}

	}

	public static CustomDate RoomGetAttributeCustomDateEntry(CustomDate date1) throws ParseException {
		while (true) {
			CustomDate date = valida.valida_CustomDate_botons("Insert Entry Date");
			if (date.compareToAfter(date1) != 1)
				return date;
		}

	}

	public static CustomDate RoomGetAttributeCustomDateExit(CustomDate date2) throws ParseException {
		while (true) {
			CustomDate date = valida.valida_CustomDate_botons("Insert Exit Date");
			if (date.compareTo_WithMessage(date2) != -1)
				return date;
		}

	}
}
