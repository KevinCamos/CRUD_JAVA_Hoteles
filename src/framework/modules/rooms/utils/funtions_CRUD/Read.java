package framework.modules.rooms.utils.funtions_CRUD;

import javax.swing.JOptionPane;

import framework.modules.rooms.utils.Select_Name_Room_String;
import framework.modules.rooms.utils.Singletone;
import framework.modules.rooms.utils.valida_attribute;
import framework.utils.menu;

public class Read {

	public static void Read_Room() {

		if (Find_if_Empty() == true)
			Menu_Read_Room();
	}

	public static boolean Find_if_Empty() {
		boolean interruptor = false;
		if ((Singletone.roomSingle.isEmpty() && Singletone.roomType == 0) || (Singletone.roomTwice.isEmpty() && Singletone.roomType == 1)

				|| (Singletone.roomSuite.isEmpty() && Singletone.roomType == 2)) {
			JOptionPane.showMessageDialog(null, "Aun no has creado ningunga " + Select_Name_Room_String.GetNameRoom(), "ERROR", JOptionPane.ERROR_MESSAGE);
			return interruptor;
		}
		return interruptor = true;
	}

	public static void Menu_Read_Room() {
		String[] OptionsMenu = { "Leer una habitación", "Leer todas las habitaciones", "Buscar y leer una habitación" };
		int OptionValue = menu.menu_botons("¿Que deseas hacer?", "Menu de busqueda " + Select_Name_Room_String.GetNameRoom(), OptionsMenu);
		switch (OptionValue) {
			case 0 -> Read_One_Room();
			case 1 -> Read_All_Rooms();
			case 2 -> Read_Search_Room();
		}
	}

	public static void Read_One_Room() {

		String numRoomSelect = "";

		switch (Singletone.roomType) {
			case SINGLE: {
				String[] primaryKeyList = getPrimaryKey.getPrimaryKeyListRooms();
				numRoomSelect = menu.menu_combo_no_closed_null("Elige una habitación", "Selecciona habitación " + Select_Name_Room_String.GetNameRoom(), primaryKeyList);
				for (int i = 0; i < Singletone.roomSingle.size(); i++) {
					if (numRoomSelect == Singletone.roomSingle.get(i).getNumRoom()) {
						JOptionPane.showMessageDialog(null, Singletone.roomSingle.get(i).toString(), "Room " + numRoomSelect, JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
				break;
			}
			case TWICE: {
				String[] primaryKeyList = getPrimaryKey.getPrimaryKeyListRooms();
				numRoomSelect = menu.menu_combo_no_closed_null("Elige una habitación", "Selecciona habitación " + Select_Name_Room_String.GetNameRoom(), primaryKeyList);
				for (int i = 0; i < Singletone.roomTwice.size(); i++) {
					if (numRoomSelect == Singletone.roomTwice.get(i).getNumRoom()) {
						JOptionPane.showMessageDialog(null, Singletone.roomTwice.get(i).toString(), "Room " + numRoomSelect, JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
				break;
			}
			case SUITE: {
				String[] primaryKeyList = getPrimaryKey.getPrimaryKeyListRooms();
				numRoomSelect = menu.menu_combo_no_closed_null("Elige una habitación", "Selecciona habitación " + Select_Name_Room_String.GetNameRoom(), primaryKeyList);
				for (int i = 0; i < Singletone.roomSuite.size(); i++) {
					if (numRoomSelect == Singletone.roomSuite.get(i).getNumRoom()) {
						JOptionPane.showMessageDialog(null, Singletone.roomSuite.get(i).toString(), "Room " + numRoomSelect, JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
			}
				break;
		}

	}

	public static void Read_All_Rooms() {

		String numRoomSelect = "";

		switch (Singletone.roomType) {
			case SINGLE: {
				for (int i = 0; i < Singletone.roomSingle.size(); i++) {
					JOptionPane.showMessageDialog(null, Singletone.roomSingle.get(i).toString(), "Room " + numRoomSelect, JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			}
			case TWICE: {
				for (int i = 0; i < Singletone.roomTwice.size(); i++) {
					JOptionPane.showMessageDialog(null, Singletone.roomTwice.get(i).toString(), "Room " + numRoomSelect, JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			}

			case SUITE: {
				for (int i = 0; i < Singletone.roomSuite.size(); i++) {
					JOptionPane.showMessageDialog(null, Singletone.roomSuite.get(i).toString(), "Room " + numRoomSelect, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	public static void Read_Search_Room() {

		String numRoomSelect = "";

		switch (Singletone.roomType) {
			case SINGLE: {
				numRoomSelect = valida_attribute.RoomGetAttributeString(1);
				for (int i = 0; i < Singletone.roomSingle.size(); i++) {
					if (numRoomSelect.equals(Singletone.roomSingle.get(i).getNumRoom())) {
						JOptionPane.showMessageDialog(null, Singletone.roomSingle.get(i).toString(), "Room " + numRoomSelect, JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Esta habitación no existe", "ERROR - Room " + numRoomSelect, JOptionPane.ERROR_MESSAGE);
				break;
			}
			case TWICE: {
				numRoomSelect = valida_attribute.RoomGetAttributeString(1);
				for (int i = 0; i < Singletone.roomTwice.size(); i++) {
					if (numRoomSelect == Singletone.roomTwice.get(i).getNumRoom()) {
						JOptionPane.showMessageDialog(null, Singletone.roomTwice.get(i).toString(), "Room " + numRoomSelect, JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Esta habitación no existe", "ERROR - Room " + numRoomSelect, JOptionPane.ERROR_MESSAGE);
				break;
			}
			case SUITE: {
				numRoomSelect = valida_attribute.RoomGetAttributeString(1);
				for (int i = 0; i < Singletone.roomSuite.size(); i++) {
					if (numRoomSelect == Singletone.roomSuite.get(i).getNumRoom()) {
						JOptionPane.showMessageDialog(null, Singletone.roomSuite.get(i).toString(), "Room " + numRoomSelect, JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Esta habitación no existe", "ERROR - Room " + numRoomSelect, JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}

	protected final static int SINGLE = 0;
	protected final static int TWICE = 1;
	protected final static int SUITE = 2;
}
