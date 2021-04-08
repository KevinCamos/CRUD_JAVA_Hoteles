package framework.modules.rooms.utils.funtions_CRUD;

import java.awt.HeadlessException;
import java.text.ParseException;

import framework.modules.rooms.classes.Single;
import framework.modules.rooms.classes.Suite;
import framework.modules.rooms.classes.Twice;
import framework.modules.rooms.utils.Singletone;
import framework.utils.menu;

public class Update {

	public static void Update_Room() throws HeadlessException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException {

		String numRoomSelect = "";
		switch (Singletone.roomType) {
			case SINGLE: {
				if (Read.Find_if_Empty() == true) {
					String[] primaryKeyList = getPrimaryKey.getPrimaryKeyListRooms();
					numRoomSelect = menu.menu_combo_no_closed_null("Elige una habitación que desees modificar", "Selecciona habitación", primaryKeyList);
					for (int i = 0; i < Singletone.roomSingle.size(); i++) {
						if (numRoomSelect == Singletone.roomSingle.get(i).getNumRoom()) {
							Update.Update_with_reflection(i);
							i = Singletone.roomSingle.size();
							break;
						}
					}
				}
				break;
			}
			case TWICE: {
				if (Read.Find_if_Empty() == true) {
					String[] primaryKeyList = getPrimaryKey.getPrimaryKeyListRooms();
					numRoomSelect = menu.menu_combo_no_closed_null("Elige una habitación que desees modificar", "Selecciona habitación", primaryKeyList);
					for (int i = 0; i < Singletone.roomTwice.size(); i++) {
						if (numRoomSelect == Singletone.roomTwice.get(i).getNumRoom()) {
							Update.Update_with_reflection(i);
							break;
						}
					}
				}
				break;
			}
			case SUITE: {
				if (Read.Find_if_Empty() == true) {
					String[] primaryKeyList = getPrimaryKey.getPrimaryKeyListRooms();
					numRoomSelect = menu.menu_combo_no_closed_null("Elige una habitación que desees modificar", "Selecciona habitación", primaryKeyList);
					for (int i = 0; i < Singletone.roomSuite.size(); i++) {
						if (numRoomSelect == Singletone.roomSuite.get(i).getNumRoom()) {
							Update.Update_with_reflection(i);
							break;
						}
					}
				}
			}
				break;
		}
		Order.Order_Room_Automatic();

	}

	public static void Update_with_reflection(int i) throws HeadlessException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException {
		switch (Singletone.roomType) {
			case SINGLE: {
				Single roomMakingOff = Singletone.roomSingle.get(i);
				roomMakingOff = (Single) framework.utils.reflection.UpdateObject(roomMakingOff);
				Singletone.roomSingle.remove(i);
				Singletone.roomSingle.add(roomMakingOff);
				break;
			}
			case TWICE: {
				Twice roomMakingOff = Singletone.roomTwice.get(i);
				roomMakingOff = (Twice) framework.utils.reflection.UpdateObject(roomMakingOff);
				Singletone.roomTwice.remove(i);
				Singletone.roomTwice.add(roomMakingOff);
				break;

			}
			case SUITE: {
				Suite roomMakingOff = Singletone.roomSuite.get(i);
				roomMakingOff = (Suite) framework.utils.reflection.UpdateObject(roomMakingOff);
				Singletone.roomSuite.remove(i);
				Singletone.roomSuite.add(roomMakingOff);
				break;

			}
		}

	}

	protected final static int SINGLE = 0;
	protected final static int TWICE = 1;
	protected final static int SUITE = 2;
}
