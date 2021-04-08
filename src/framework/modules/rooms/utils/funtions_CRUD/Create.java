package framework.modules.rooms.utils.funtions_CRUD;

import java.awt.HeadlessException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import framework.modules.rooms.classes.Room;
import framework.modules.rooms.classes.Single;
import framework.modules.rooms.classes.Suite;
import framework.modules.rooms.classes.Twice;
import framework.modules.rooms.utils.Singletone;
import framework.modules.rooms.utils.funtions_find;
import framework.modules.rooms.utils.valida_attribute;
import framework.utils.reflection;

public class Create {

	public static void Create_Room() throws ParseException, HeadlessException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		Room roomMakingOff = null;
		int location = -1;
		String numRoom = valida_attribute.RoomGetAttributeString(1);

		switch (Singletone.roomType) {
			case 0 -> roomMakingOff = new Single(numRoom);
			case 1 -> roomMakingOff = new Twice(numRoom);
			case 2 -> roomMakingOff = new Suite(numRoom);
		}
		location = funtions_find.find_Room(roomMakingOff);
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "¡Esta habitación ya está creada!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		} else {
			reflection.createObject(numRoom);
		}
		Order.Order_Room_Automatic();

	}

}
