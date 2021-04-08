package framework.modules.rooms.utils;

public class orderChair {
	public static String SALTO_LINEA = "\n";
	public static String IGUAL = " => ";
	public static String BARRA = "---------------";

	public static String AddLineTitle(String title) {
		return title + SALTO_LINEA + BARRA + SALTO_LINEA + SALTO_LINEA;
	}

	public static String AddJumpLine() {
		return SALTO_LINEA + BARRA + SALTO_LINEA;
	}

	public static String AddLineText(String text, String value) {
		return text + IGUAL + value + SALTO_LINEA;
	}

	public static String AddLineText(String text, boolean value) {

		String SiNo = null;
		if (value == true) {
			SiNo = "Yes";
		} else {
			SiNo = "No";
		}

		return text + IGUAL + SiNo + SALTO_LINEA;
	}

	public static String AddLineText(String text, int value) {
		return text + IGUAL + value + SALTO_LINEA;
	}

	public static String AddLineText(String text, float value) {
		return text + IGUAL + value + SALTO_LINEA;
	}
}
