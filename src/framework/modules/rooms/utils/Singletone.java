package framework.modules.rooms.utils;

import java.text.ParseException;
import java.util.ArrayList;

import framework.modules.fecha.CustomDate;
import framework.modules.rooms.classes.Single;
import framework.modules.rooms.classes.Suite;
import framework.modules.rooms.classes.Twice;
import framework.modules.rooms.utils.funtions_CRUD.Order;

public class Singletone {

	public static ArrayList<Single> roomSingle;
	public static ArrayList<Twice> roomTwice;
	public static ArrayList<Suite> roomSuite;
	public static int roomType = 0;
	public static int selectOption = 0;

	public Singletone() {
		Singletone.roomSingle = new ArrayList<Single>();
		Singletone.roomTwice = new ArrayList<Twice>();
		Singletone.roomSuite = new ArrayList<Suite>();
	}

	public static void dommies() throws ParseException {

		CustomDate dayEntry = new CustomDate("12/12/2020");
		CustomDate dayExit = new CustomDate("15/12/2020");
		Single singleDommie1 = new Single("015-A", dayEntry, dayExit, "12:00", "12:30", 1, 1, true, true, true);
		dayEntry = new CustomDate("12/10/2019");
		dayExit = new CustomDate("01/02/2020");
		Single singleDommie2 = new Single("122-B", dayEntry, dayExit, "12:00", "12:30", 1, 1, true, true, false);
		dayEntry = new CustomDate("05/03/2021");
		dayExit = new CustomDate("15/03/2021");
		Single singleDommie3 = new Single("123-A", dayEntry, dayExit, "12:00", "12:30", 1, 1, true, true, false);
		dayEntry = new CustomDate("05/05/2021");
		dayExit = new CustomDate("15/06/2021");
		Single singleDommie4 = new Single("015-B", dayEntry, dayExit, "12:00", "12:30", 1, 1, false, false, false);
		dayEntry = new CustomDate("12/12/2020");
		dayExit = new CustomDate("15/12/2020");
		Twice twiceDommie1 = new Twice("123-C", dayEntry, dayExit, "12:00", "12:30", 2, 2, true, true, "Death Star");
		dayEntry = new CustomDate("12/10/2019");
		dayExit = new CustomDate("01/02/2020");
		Twice twiceDommie2 = new Twice("121-D", dayEntry, dayExit, "12:00", "12:30", 1, 2, true, false, "Death Star");
		dayEntry = new CustomDate("05/03/2021");
		dayExit = new CustomDate("15/03/2021");
		Twice twiceDommie3 = new Twice("125-C", dayEntry, dayExit, "12:00", "12:30", 2, 4, false, false, "Death Star");
		dayEntry = new CustomDate("05/05/2021");
		dayExit = new CustomDate("15/06/2021");
		Twice twiceDommie4 = new Twice("003-D", dayEntry, dayExit, "12:00", "12:30", 3, 4, false, true, "Death Star");
		dayEntry = new CustomDate("12/12/2020");
		dayExit = new CustomDate("15/12/2020");
		Suite suiteDommie1 = new Suite("298-E", dayEntry, dayExit, "12:00", "12:30", 1, 2, true, false, true, true, "Death Star");
		dayEntry = new CustomDate("12/10/2019");
		dayExit = new CustomDate("01/02/2020");
		Suite suiteDommie2 = new Suite("255-F", dayEntry, dayExit, "12:00", "12:30", 2, 2, false, true, false, true, "Death Star");
		dayEntry = new CustomDate("05/03/2021");
		dayExit = new CustomDate("15/03/2021");
		Suite suiteDommie3 = new Suite("200-F", dayEntry, dayExit, "12:00", "12:30", 4, 6, true, false, false, false, "Death Star");
		dayEntry = new CustomDate("05/05/2021");
		dayExit = new CustomDate("15/06/2021");
		Suite suiteDommie4 = new Suite("105-E", dayEntry, dayExit, "12:00", "12:30", 5, 6, true, false, true, false, "Death Star");
		Singletone.roomSingle.add(singleDommie1);
		Singletone.roomSingle.add(singleDommie2);
		Singletone.roomSingle.add(singleDommie3);
		Singletone.roomSingle.add(singleDommie4);

		Singletone.roomTwice.add(twiceDommie1);
		Singletone.roomTwice.add(twiceDommie2);
		Singletone.roomTwice.add(twiceDommie3);
		Singletone.roomTwice.add(twiceDommie4);

		Singletone.roomSuite.add(suiteDommie1);
		Singletone.roomSuite.add(suiteDommie2);
		Singletone.roomSuite.add(suiteDommie3);
		Singletone.roomSuite.add(suiteDommie4);
		Order.Order_Room_Automatic();

	}

//	public static Singletone getInstance() {
//		if (instance == null) {
//			instance = new Singletone();
//		}
//		return instance;
//	}

}
