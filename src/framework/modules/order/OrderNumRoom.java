package framework.modules.order;

import java.util.Comparator;

import framework.modules.rooms.classes.Room;

public class OrderNumRoom implements Comparator<Room> {

	public int compare(Room numRoom0, Room numRoom1) {
		String roomString0 = numRoom0.getNumRoom();
		String roomString1 = numRoom1.getNumRoom();
//// 123-A
		char roomChar0 = roomString0.charAt(4);
		char roomChar1 = roomString1.charAt(4);

		String[] arrSplit0 = roomString0.split("-");
		String[] arrSplit1 = roomString1.split("-");

		int numberRoom0 = Integer.parseInt(arrSplit0[0]);
		int numberRoom1 = Integer.parseInt(arrSplit1[0]);

		if (roomChar0 > roomChar1) {
			return 1;
		} else if (roomChar0 == roomChar1) {
			if (numberRoom0 > numberRoom1) {
				return 1;
			} else if (numberRoom0 == numberRoom1) {
				return 0;
			} else {
				return -1;

			}

		} else {
			return -1;
//			
//			if (roomChar0 > roomChar1 && numberRoom0 > numberRoom1) {
//				return 1;
//			} else if (roomChar0 < roomChar1 && numberRoom0 < numberRoom1) {
//				return -1;
//			}
		}
	}
}
