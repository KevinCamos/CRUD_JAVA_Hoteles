package framework.utils;

import java.awt.HeadlessException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;

import framework.modules.rooms.classes.Room;
import framework.modules.rooms.classes.Single;
import framework.modules.rooms.classes.Suite;
import framework.modules.rooms.classes.Twice;
import framework.modules.rooms.utils.Singletone;
import framework.modules.rooms.utils.valida_attribute;

public class reflection {

	public static ArrayList<String> extraerListaAtributos(Object room) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ArrayList<String> totalAttributs = new ArrayList<String>();
		////// SACAR LA LISTA DE ATRIBUTOS PRIMERO DE LA MADRE Y LUEGO DE LA HIJA
		Field[] listAttributMother = room.getClass().getSuperclass().getDeclaredFields(); // lista madre
		Field[] listSon = room.getClass().getDeclaredFields();
		///// SACAR DE CADA LISTA Y SU LISTA DE CARÁCTERES SU ATRIBUTO,
		//// ESTO SOLO SIRVE PARA SACAR LA LISTA DE ATRIBUTOS

		/// LISTA MADRE
		for (int i = 0; i < listAttributMother.length; i++) {
			String[] SplitDateMatrix = listAttributMother[i].toString().split("[ ]", 0);
			String[] SplitDateMatrix2 = SplitDateMatrix[(SplitDateMatrix.length) - 1].toString().split("[.]", 0);
//			System.out.println((SplitDateMatrix2[(SplitDateMatrix2.length) - 1]).toString());
			totalAttributs.add(SplitDateMatrix2[(SplitDateMatrix2.length) - 1]);
		}
		totalAttributs.remove("IVA");
		totalAttributs.remove("price");

		/// LISTA HIJA
		for (int i = 0; i < listSon.length; i++) {
			String[] SplitDateMatrix = listSon[i].toString().split("[ ]", 0);
			String[] SplitDateMatrix2 = SplitDateMatrix[(SplitDateMatrix.length - 1)].toString().split("[.]", 0);
			// System.out.println(SplitDateMatrix2[4].toString());
			totalAttributs.add(SplitDateMatrix2[(SplitDateMatrix2.length - 1)]);
		}
		return totalAttributs;
//		System.out.println(totalAttributs.toString());
//
//		String conjuntoDeCaracteres = JOptionPane.showInputDialog("Escriu un atribut");
//		Field line = room.getClass().getSuperclass().getDeclaredField(conjuntoDeCaracteres);
//		line.setAccessible(true); // puc canviar els datos de dins sense que salte el control de seguretat
//		//
//
//		line.set(room, "adeu");
//		System.out.println(line.get(room));

	}

	public static void createObject(String numRoom) throws HeadlessException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException {
		String[] OpcionesPrimitivo = { "String", "int", "float", "boolan" };
		String Attribute = null;
		Field AtributeModifingField = null;
		int OpcionesPrimitivoInt = 0;
		Room roomMakingOff = null;
		switch (Singletone.roomType) {
			case 0 -> roomMakingOff = new Single();
			case 1 -> roomMakingOff = new Twice();
			case 2 -> roomMakingOff = new Suite();
		}

		ArrayList<String> totalAttributString = reflection.extraerListaAtributos(roomMakingOff);
		String[] AttributeString = totalAttributString.toArray(new String[0]);
//		if (AtributeModifingField.getGenericType() == String.class) {
//		PARA SABER EL TIPO DEL VALIDADOR DE UN STRING
//		PRIMERO SACA TODOS LOS FIELDS DE LAS CLASES
//		SEGUNDO PASO: RECORRERLOS UNO POR UNO
//		TERCER PASO: SI TIENE ANOTIACIÓN, USAR ANOTACIONES PARA LOS VALIDADORES
//		SI NO TIENE ANOTACIÓN, BUSCAR EL TIPO DE DATO
//		}
//		if (AtributeModifingField.getAnnotation(validadorHoras.class) != null) {
//		AtributeModifingField = objectReflection.getClass().getSuperclass().getDeclaredField(Attribute);
//		AtributeModifingField.setAccessible(true);
//		AtributeModifingField.set(objectReflection, framework.rooms.utils.valida_attribute.RoomGetAttribute(4));
//	}

		for (int i = 0; i < AttributeString.length; i++) {
			Attribute = AttributeString[i];

//			System.out.println(Attribute);
			switch (Attribute) {

				case "type":
					AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, framework.modules.rooms.utils.valida_attribute.RoomGetAttributeString(0));
					break;

				case "numRoom":
					AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, numRoom);
					break;

				case "dateEntry":
					switch (Singletone.roomType) {
						case 0: {
							((Single) roomMakingOff).setDateEntry(valida_attribute.RoomGetAttributeCustomDateEntry());
							break;
						}
						case 1: {
							((Twice) roomMakingOff).setDateEntry(valida_attribute.RoomGetAttributeCustomDateEntry());
							break;
						}
						case 2: {
							((Suite) roomMakingOff).setDateEntry(valida_attribute.RoomGetAttributeCustomDateEntry());
							break;
						}
					}
					break;

				case "dateExit":
					switch (Singletone.roomType) {
						case 0: {
							((Single) roomMakingOff).setDateExit(valida_attribute.RoomGetAttributeCustomDateExit(((Single) roomMakingOff).getDateEntry()));
							break;
						}
						case 1: {
							((Twice) roomMakingOff).setDateExit(valida_attribute.RoomGetAttributeCustomDateExit(((Twice) roomMakingOff).getDateEntry()));
							break;

						}
						case 2: {
							((Suite) roomMakingOff).setDateExit(valida_attribute.RoomGetAttributeCustomDateExit(((Suite) roomMakingOff).getDateEntry()));
							break;
						}
					}
					break;

				case "hourEntry":
					AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeString(4));
					break;

				case "hourExit":
					AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeString(5));
					break;

				case "numBeds":
					AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeInt(0));
					break;

				case "numPerson":
					AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeInt(1));
					break;

				case "price":
					AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeFloat(0));
					break;

				case "wifi":
					AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeBoolean(0));
					break;

				case "available":
					AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeBoolean(1));
					break;

				case "gameConsole":
					AtributeModifingField = roomMakingOff.getClass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeBoolean(4));
					break;

				case "jacuzzi":
					AtributeModifingField = roomMakingOff.getClass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeBoolean(2));
					break;

				case "minibar":
					AtributeModifingField = roomMakingOff.getClass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeBoolean(3));
					break;

				case "welcomeGift":
					AtributeModifingField = roomMakingOff.getClass().getDeclaredField(Attribute);
					AtributeModifingField.setAccessible(true);
					AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeString(6));
					break;

				default:

					OpcionesPrimitivoInt = menu.menu_botons("No tenemos suficientes datos\nsobre " + Attribute + "\n¿Qué tipo de dato desea introducir?", "Tipo de dato", OpcionesPrimitivo);
					switch (OpcionesPrimitivoInt) {
						case 0:
							AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
							AtributeModifingField.setAccessible(true);
							AtributeModifingField.set(roomMakingOff, valida.valida_String("Enter " + Attribute, Attribute));
							break;

						case 1:
							AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
							AtributeModifingField.setAccessible(true);
							AtributeModifingField.set(roomMakingOff, valida.valida_int("Enter " + Attribute, Attribute));
							break;

						case 2:
							AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
							AtributeModifingField.setAccessible(true);
							AtributeModifingField.set(roomMakingOff, valida.valida_float("Enter " + Attribute, Attribute));
							break;

						case 3:
							AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
							AtributeModifingField.setAccessible(true);
							AtributeModifingField.set(roomMakingOff, valida.valida_boolean("Enter " + Attribute, Attribute));
							break;

					}

			}
		}
//		ACÍ GUARDEM ELS OBJECTES ROOM EN UNA ARRAYLIST
		switch (Singletone.roomType) {
			case 0 -> Singletone.roomSingle.add((Single) roomMakingOff);
			case 1 -> Singletone.roomTwice.add((Twice) roomMakingOff);
			case 2 -> Singletone.roomSuite.add((Suite) roomMakingOff);
		}

//		ACÍ DE TINDRE UN OBJECTE DISTINT A ROOM, AL SER REFLECTION PODRIEM CREAR UNA QUARTA ARRAY PER A OBJECTES QUE ENTRARA AL DEFAULT

	}

	public static Object UpdateObject(Object ObjectReflection) throws HeadlessException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException {

		Room roomMakingOff = (Room) ObjectReflection;
		ArrayList<String> totalAttributs = reflection.extraerListaAtributos(roomMakingOff);
		String[] AttributeString = totalAttributs.toArray(new String[0]);
		String[] OpcionesPrimitivo = { "String", "int", "float", "boolan" };
		String Attribute = null;
		Field AtributeModifingField = null;
		int OpcionesPrimitivoInt = 0;
		Attribute = menu.menu_combo("What attribute do you want modify?", "Update", AttributeString);

		switch (Attribute) {

//case "type":
//	AtributeModifingField = objectReflection.getClass().getSuperclass().getDeclaredField(Attribute);
//	AtributeModifingField.setAccessible(true);
//	AtributeModifingField.set(objectReflection,
//			framework.objectsclass.rooms.utils.valida_attribute.RoomGetAttributeString(0));
//	return objectReflection;

			case "numRoom":
				AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeString(1));
				return roomMakingOff;

			case "dateEntry":
				switch (Singletone.roomType) {
					case 0: {

						((Single) roomMakingOff).setDateEntry(valida_attribute.RoomGetAttributeCustomDateEntry(roomMakingOff.getDateExit()));
						break;
					}
					case 1: {
						((Twice) roomMakingOff).setDateEntry(valida_attribute.RoomGetAttributeCustomDateEntry(roomMakingOff.getDateExit()));
						break;
					}
					case 2: {
						((Suite) roomMakingOff).setDateEntry(valida_attribute.RoomGetAttributeCustomDateEntry(roomMakingOff.getDateExit()));
						break;
					}
				}
				break;

			case "dateExit":
				switch (Singletone.roomType) {
					case 0: {
						((Single) roomMakingOff).setDateExit(valida_attribute.RoomGetAttributeCustomDateExit(roomMakingOff.getDateEntry()));
						break;
					}
					case 1: {
						((Twice) roomMakingOff).setDateExit(valida_attribute.RoomGetAttributeCustomDateExit(roomMakingOff.getDateEntry()));
						break;

					}
					case 2: {
						((Suite) roomMakingOff).setDateExit(valida_attribute.RoomGetAttributeCustomDateExit(roomMakingOff.getDateEntry()));
						break;
					}
				}
				break;

			case "hourEntry":
				AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeString(4));
				return roomMakingOff;
			case "hourExit":
				AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeString(5));
				return roomMakingOff;
			case "numBeds":
				AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeInt(0));
				return roomMakingOff;
			case "numPerson":
				AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeInt(1));
				return roomMakingOff;
			case "price":
				AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeFloat(0));
				return roomMakingOff;
			case "wifi":
				AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeBoolean(0));
				return roomMakingOff;
			case "available":
				AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeBoolean(1));
				return roomMakingOff;
			case "consoleGame":
				AtributeModifingField = roomMakingOff.getClass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeBoolean(4));
				return roomMakingOff;
			case "jacuzzi":
				AtributeModifingField = roomMakingOff.getClass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeBoolean(2));
				return roomMakingOff;
			case "minibar":
				AtributeModifingField = roomMakingOff.getClass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeBoolean(3));
				return roomMakingOff;

			case "welcomeGift":
				AtributeModifingField = roomMakingOff.getClass().getDeclaredField(Attribute);
				AtributeModifingField.setAccessible(true);
				AtributeModifingField.set(roomMakingOff, valida_attribute.RoomGetAttributeString(6));
				return roomMakingOff;
			default:

				OpcionesPrimitivoInt = menu.menu_botons("No tenemos suficientes datos\nsobre " + Attribute + "\n¿Qué tipo de dato desea introducir?", "Tipo de dato", OpcionesPrimitivo);
				switch (OpcionesPrimitivoInt) {
					case 0:
						AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
						AtributeModifingField.setAccessible(true);
						AtributeModifingField.set(roomMakingOff, valida.valida_String("Enter " + Attribute, Attribute));
						return roomMakingOff;

					case 1:
						AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
						AtributeModifingField.setAccessible(true);
						AtributeModifingField.set(roomMakingOff, valida.valida_int("Enter " + Attribute, Attribute));
						return roomMakingOff;
					case 2:
						AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
						AtributeModifingField.setAccessible(true);
						AtributeModifingField.set(roomMakingOff, valida.valida_float("Enter " + Attribute, Attribute));
						return roomMakingOff;
					case 3:
						AtributeModifingField = roomMakingOff.getClass().getSuperclass().getDeclaredField(Attribute);
						AtributeModifingField.setAccessible(true);
						AtributeModifingField.set(roomMakingOff, valida.valida_boolean("Enter " + Attribute, Attribute));
						return roomMakingOff;
				}

		}
		return roomMakingOff;

	}
}

//
//String conjuntoDeCaracteres = JOptionPane.showInputDialog("Escriu un atribut");
//Field line = room.getClass().getSuperclass().getDeclaredField(conjuntoDeCaracteres);
//line.setAccessible(true); // puc canviar els datos de dins sense que salte el control de seguretat
////
//
//line.set(room, "adeu");
//System.out.println(line.get(room));
