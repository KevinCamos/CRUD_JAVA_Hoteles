package framework.modules.rooms.utils.funtions_CRUD;

import java.awt.HeadlessException;
import java.text.ParseException;

import framework.modules.rooms.utils.Singletone;
import framework.utils.menu;

public class Delate {

	public static void Delate_room() throws ParseException, HeadlessException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		String numRoomSelect = "";

		switch (Singletone.roomType) {
			case SINGLE: {
				if (Read.Find_if_Empty() == true) {

					String[] primaryKeyList = getPrimaryKey.getPrimaryKeyListRooms();
					numRoomSelect = menu.menu_combo_no_closed_null("Elige la habitación que deseas eliminar", "Selecciona habitación " + framework.modules.rooms.utils.Select_Name_Room_String.GetNameRoom(), primaryKeyList);
					for (int i = 0; i < Singletone.roomSingle.size(); i++) {
						if (numRoomSelect == Singletone.roomSingle.get(i).getNumRoom()) {
							Singletone.roomSingle.remove(i);
							return;
						}
					}
				}
				return;
			}
			case TWICE: {
				if (Read.Find_if_Empty() == true) {
					String[] primaryKeyList = getPrimaryKey.getPrimaryKeyListRooms();
					numRoomSelect = menu.menu_combo_no_closed_null("Elige la habitación que deseas eliminar", "Selecciona habitación " + framework.modules.rooms.utils.Select_Name_Room_String.GetNameRoom(), primaryKeyList);
					for (int i = 0; i < Singletone.roomTwice.size(); i++) {
						if (numRoomSelect == Singletone.roomTwice.get(i).getNumRoom()) {
							Singletone.roomTwice.remove(i);
							return;
						}
					}
				}
				return;
			}
			case SUITE: {
				if (Read.Find_if_Empty() == true) {
					String[] primaryKeyList = getPrimaryKey.getPrimaryKeyListRooms();
					numRoomSelect = menu.menu_combo_no_closed_null("Elige la habitación que deseas eliminar", "Selecciona habitación " + framework.modules.rooms.utils.Select_Name_Room_String.GetNameRoom(), primaryKeyList);
					for (int i = 0; i < Singletone.roomSuite.size(); i++) {
						if (numRoomSelect == Singletone.roomSuite.get(i).getNumRoom()) {
							Singletone.roomSingle.remove(i);
							return;
						}
					}
				}
				return;
			}

		}
	}

	protected final static int SINGLE = 0;
	protected final static int TWICE = 1;
	protected final static int SUITE = 2;
}
