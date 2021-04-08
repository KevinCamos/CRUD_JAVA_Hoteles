package framework.modules.fecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import framework.modules.config.ConfigProgram;

public class CustomDate {

	private GregorianCalendar dateGregorian;
	private Date dateInDate;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public CustomDate() throws ParseException {
		LocalDate dateLocal = LocalDate.now();
		DateTimeFormatter formatDateFor_LOCAL_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formatLocalDateToString = dateLocal.format(formatDateFor_LOCAL_DATE);
		this.dateGregorian = (GregorianCalendar) GregorianCalendar.getInstance();
		this.dateInDate = dateFormat.parse(formatLocalDateToString);
	}

	public CustomDate(String date) throws ParseException {

		this.dateInDate = dateFormat.parse(date);

		this.dateGregorian = (GregorianCalendar) GregorianCalendar.getInstance();
		this.dateGregorian.setTime(this.dateInDate);
	}

	public CustomDate(int day, int month, int year) throws ParseException {
		this.dateGregorian = (GregorianCalendar) GregorianCalendar.getInstance();
		this.dateGregorian.set(year, month, day);
		String dateString = day + "/" + month + "/" + year;
		this.dateInDate = dateFormat.parse(dateString);
	}

	public CustomDate(GregorianCalendar date) throws ParseException {
		this.dateGregorian = date;
		String dateString = this.dateFormat.format(date);
		this.dateInDate = dateFormat.parse(dateString);

	}

	public GregorianCalendar getDateGregorian() {
		return dateGregorian;
	}

	public void setDateGregorian(GregorianCalendar dateGregorian) {
		this.dateGregorian = dateGregorian;
	}

	public Date getDateInDate() {
		return dateInDate;
	}

	public void setDateInDate(Date dateInDate) {
		this.dateInDate = dateInDate;
	}

	public int compareTo(CustomDate previousDate) {
		int compareResult = this.dateGregorian.compareTo(previousDate.dateGregorian);
		return compareResult;
	}

	public int compareTo_WithMessage(CustomDate previousDate) {
		int compareResult = this.dateGregorian.compareTo(previousDate.dateGregorian);
		if (compareResult == -1) {
			JOptionPane.showMessageDialog(null, "You are entering a before the date of entry", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
		return compareResult;
	}

	public int compareToAfter(CustomDate previousDate) {
		int compareResult = this.dateGregorian.compareTo(previousDate.dateGregorian);
		if (compareResult == 1) {
			JOptionPane.showMessageDialog(null, "You are entering a check-in date after the check-out date", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
		return compareResult;
	}

	public int compareTo() throws ParseException {
		CustomDate dataBase = new CustomDate();
		int compareResult = this.dateGregorian.compareTo(dataBase.dateGregorian);
		if (compareResult == -1)
			JOptionPane.showMessageDialog(null, "You are entering a date before the current one", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		return compareResult;
	}

	public int diferencesInDaysGregorian(CustomDate secondDate) {

		double time = this.dateGregorian.getTimeInMillis();
		double timeSecond = secondDate.dateGregorian.getTimeInMillis();

		double diference = (timeSecond - time);
		double days = diference / 1000 / 60 / 60 / 24;

		return (int) days;

	}

	public int diferencesInDays(CustomDate secondDate) {

		int days = (int) ((secondDate.getTimeDateLong() - getTimeDateLong()) / 86400000);
		return days;

	}

	public long getTimeDateLong() {

		return this.dateInDate.getTime();

	}

	public String weekday() throws ParseException {

//		int day = 86400000;
		CustomDate DataBase = new CustomDate("01/01/1990");
		String dayString = null;
		int day = DataBase.diferencesInDays(CustomDate.this);
		while (day >= 7) {
			if (day >= 700) {
				day = day - 700;
			} else if (day >= 70) {
				day = day - 70;
			} else {
				day = day - 7;
			}
//		int days = (int) ((secondDate.getTimeDateLong() - getTimeDateLong()) / 86400000);
			switch (day) {
				case 0 -> dayString = "Monday";
				case 1 -> dayString = "Tuesday";
				case 2 -> dayString = "Wednesday";
				case 3 -> dayString = "Thursday";
				case 4 -> dayString = "Friday";
				case 5 -> dayString = "Saturday";
				case 6 -> dayString = "Sunday";
			}

		}
		return dayString;

	}

	public String toString() {
		this.dateFormat = ConfigProgram.getInstance().getDateFormat();
		String chair = null;
		try {
			chair = CustomDate.this.weekday() + ", " + this.dateFormat.format(this.dateInDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return chair;

	}
}