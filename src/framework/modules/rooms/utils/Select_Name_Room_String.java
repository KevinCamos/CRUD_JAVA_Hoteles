package framework.modules.rooms.utils;

public class Select_Name_Room_String {
	public static String GetNameRoom() {
		String nameType = "";
		switch (Singletone.roomType) {
		case 0 -> nameType = "Single";
		case 1 -> nameType = "Twice";
		case 2 -> nameType = "Suite";

		}

		return nameType;

	}
}