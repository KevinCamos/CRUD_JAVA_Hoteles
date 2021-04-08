package framework.modules.order;

import java.util.Comparator;

import framework.modules.rooms.classes.Room;

public class OrderDateEntry implements Comparator<Room> {

	public int compare(Room dateEntry0, Room dateEntry1) {
//		if (dateEntry0.getDateEntry().getTimeDateLong() > dateEntry1.getDateEntry().getTimeDateLong()) {
//			return 1;
//		} else if (dateEntry0.getDateEntry().getTimeDateLong() < dateEntry1.getDateEntry().getTimeDateLong()) {
//			return -1;
//		}
//		return -0;
		return dateEntry0.getDateEntry().compareTo(dateEntry1.getDateEntry());

	}
}
