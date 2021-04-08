package framework.utils;

public class format {
	public static boolean date(String date) {
		return date.matches("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)");

	}
//
//	public static boolean date(CustomDate date) {
//		if 
//		return date.matches()}

	public static boolean date2(String date) {

		return true;
	}

	public static boolean nameRoom(String nameRoom) {
		return nameRoom.matches("\\d{3}[-][A-Z]");
	}

	public static boolean hour(String hour) {

		return hour.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
	}

	public static boolean price(float price) {
		String chairPrice = Float.toString(price);
		return chairPrice.matches("^[0-9]{1,5}(\\.[0-9]{0,2})?$");

	}

	public static boolean email(String email) {
		return email.matches("^(.+)@(.+)$");
	}
}
