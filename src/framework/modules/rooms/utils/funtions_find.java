package framework.modules.rooms.utils;

import framework.modules.rooms.classes.Room;

public class funtions_find {

	public static int find_Room(Room room) {
		for (int i = 0; i < Singletone.roomSingle.size(); i++) {
			if ((Singletone.roomSingle.get(i).equals(room)))
				return i;
		}
		for (int i = 0; i < Singletone.roomTwice.size(); i++) {
			if ((Singletone.roomTwice.get(i).equals(room)))
				return i;
		}
		for (int i = 0; i < Singletone.roomSuite.size(); i++) {
			if ((Singletone.roomSuite.get(i).equals(room)))
				return i;
		}
		return -1;
	}

}
