package framework.modules.order;

import java.util.Comparator;

import framework.modules.rooms.classes.Room;

public class OrderBeds implements Comparator<Room> {

	public int compare(Room numRoom0, Room numRoom1) {
		if (numRoom0.getNumBeds() > numRoom1.getNumBeds()) {
			return 1;
		} else if (numRoom0.getNumBeds() < numRoom1.getNumBeds()) {
			return -1;
		}
		return -0;

	}
}
