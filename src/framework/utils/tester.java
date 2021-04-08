package framework.utils;

import java.text.ParseException;

import framework.modules.fecha.CustomDate;
import framework.modules.rooms.classes.Single;

public class tester {

	public static void main(String[] args) throws ParseException {
		// TODO Esbozo de método generado automáticamente
		CustomDate dayEntry = new CustomDate("12/12/2020");
		CustomDate dayExit = new CustomDate("15/12/2020");
		Single singleDommie1 = new Single("015-A", dayEntry, dayExit, "12:00", "12:30", 1, 9999, 3, true, true, true);
		dayEntry = new CustomDate("12/10/2019");
		System.out.println(singleDommie1.toString());
	}

}
