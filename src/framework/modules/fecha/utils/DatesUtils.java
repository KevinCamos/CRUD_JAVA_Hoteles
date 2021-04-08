package framework.modules.fecha.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import framework.modules.fecha.CustomDate;
import framework.utils.menu;

public class DatesUtils { //// OJO QUE FUNCIONA

//	public static void main(String[] args) throws ParseException {
////		int dateLong1 = 0;
//
////		CustomDate date1 = new CustomDate(27, 2, 2020);
////		CustomDate date2 = new CustomDate(03, 2, 2020);
////		dateLong1 = date1.diferencesInDays(date2);
////		CustomDate DataBase = new CustomDate("06/01/2020");
////		long day1 = DataBase.getTimeDateLong();
//		CustomDate date1 = new CustomDate(27, 2, 2020);
//		String day1 = date1.weekday();
//		System.out.println(day1);
//
//	}

	/**
	 * Date1 debe de ser la primera fecha, Date2 la posterior..
	 * 
	 * @param date1
	 * @param date2
	 */
	public static boolean compareDate_TrueFalse(CustomDate date1, CustomDate date2) {
		long diferencesDays = 0;
		boolean TheDateItsPosible = false;

		diferencesDays = date2.compareTo_WithMessage(date1);
		if (diferencesDays >= 0) {
			TheDateItsPosible = true;
			return TheDateItsPosible;
		}
		return TheDateItsPosible;
	}

	public static boolean compareDate_TrueFalse(CustomDate date1) throws ParseException {
		CustomDate date2 = new CustomDate();
		long diferencesDays = 0;
		boolean TheDateItsPosible = false;

		diferencesDays = date1.diferencesInDays(date2);
		if (diferencesDays > 0) {
			TheDateItsPosible = true;
			return TheDateItsPosible;
		}
		return TheDateItsPosible;
	}

	public static int diferencesDays(CustomDate date1) throws ParseException {
		CustomDate date2 = new CustomDate();
		int diferencesDays = (int) date1.diferencesInDays(date2);
		return diferencesDays;
	}

	public static int diferencesDays(CustomDate date1, CustomDate date2) {
		int diferencesDays = (int) date2.diferencesInDays(date1);
		return diferencesDays;
	}

	public static int elapsed(Calendar before, Calendar after, int field) {
		Calendar clone = (Calendar) before.clone(); // Otherwise changes are been reflected.
		int elapsed = -1;
		while (!clone.after(after)) {
			clone.add(field, 1);
			elapsed++;
		}
		return elapsed;
	}

	public static boolean ValidaDate(int day, int month, int year) {

		month = month - 1;
		if ((month < 0) || (month > 11)) {
			return false;
		}
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (month == 1) {
			int febMax = 28;
			if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0)) {
				febMax = 29;
			}
			if ((day < 1) || (day > febMax)) {
				return false;
			}
		} else if ((day < 1) || (day > months[month])) {
		}
		return true;
	}

	public static boolean ValidaDate(String date) {
		String[] SplitArray = null;
		int day = 1;
		int month = 0;//
		int year = 2000;
		SplitArray = date.split("/");
		try {

			day = Integer.parseInt(SplitArray[0]);
			month = Integer.parseInt(SplitArray[1]) - 1;// -1 para que el sea entre 0 y 11
			year = Integer.parseInt(SplitArray[2]);
		} catch (Exception e) {

			return false;
		}
		if ((month < 0) || (month > 11)) {
			return false;
		}
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (month == 1) {
			int febMax = 28;
			if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0)) {
				febMax = 29;
			}
			if ((day < 1) || (day > febMax)) {
				return false;
			}
		} else if ((day < 1) || (day > months[month])) {
		}
		return true;
	}

	public static CustomDate ValidaDate_int(String Title) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CustomDate TodayCustomDate = new CustomDate();

		java.util.Date TodayInDate = TodayCustomDate.getDateInDate();

		String today = dateFormat.format(TodayInDate);
		String[] SplitArray = null;
		SplitArray = today.split("/");
		int day = Integer.parseInt(SplitArray[0]);
		int month = Integer.parseInt(SplitArray[1]);
		int year = Integer.parseInt(SplitArray[2]);

		int yearSelect = 0;
		int monthSelect = 0;
		int daySelect = 0;

		Integer[] yearArray = new Integer[5];
		Integer[] monthArray = null;
		Integer[] dayArray = new Integer[31];

		for (int i = year; i < (year + 5); i++) {
			yearArray[i - year] = i;
		}
		yearSelect = Integer.parseInt(menu.menu_combo("Selecciona un año", Title, yearArray));
		if (yearSelect == year) {
			monthArray = new Integer[12 - month + 1];
			for (int i = month; i <= 12; i++) {
				monthArray[i - month] = i;
			}
		} else {
			monthArray = new Integer[12];
			for (int i = 0; i < 12; i++) {
				monthArray[i] = i + 1;
			}
		}
		monthSelect = Integer.parseInt(menu.menu_combo("Selecciona un mes", Title, monthArray));

//		if (((month - 1) < 0) || ((month - 1) > 11)) {
//			return false;
//		}
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (((month - 1) == 1) && (monthSelect - 1 == 1)) {
			int febMax = 28;
			dayArray = new Integer[28 - day];

			if (((yearSelect % 4) == 0) && ((yearSelect % 100) != 0) || ((yearSelect % 400) == 0)) {
				febMax = 29;
			}
			dayArray = new Integer[29 - day];
			for (int i = day; i <= febMax; i++) {
				dayArray[i - day] = i;
			}
		} else if ((monthSelect - 1) == 1) {
			int febMax = 28;
			dayArray = new Integer[28];
			if (((yearSelect % 4) == 0) && ((yearSelect % 100) != 0) || ((yearSelect % 400) == 0)) {
				febMax = 29;
				dayArray = new Integer[29];

			}
			for (int i = 0; i < febMax; i++) {
				dayArray[i] = i + 1;
			}
		} else if (monthSelect == month) {
			dayArray = new Integer[months[monthSelect - 1] - day + 1];
			for (int i = day; i <= months[monthSelect - 1]; i++) {
				dayArray[i - day] = i;
			}

		} else {

			for (int i = 0; i < months[monthSelect - 1]; i++) {
				dayArray[i] = i + 1;
			}
		}
		daySelect = Integer.parseInt(menu.menu_combo("Selecciona un dia", Title, dayArray));
		CustomDate date = new CustomDate(daySelect, monthSelect, yearSelect);
		System.out.println(date.toString());

		return date;
	}
}
