package framework.utils;

import java.text.ParseException;

import javax.swing.JOptionPane;

import framework.modules.fecha.CustomDate;
import framework.modules.fecha.utils.DatesUtils;

public class valida {
	public final static int SALIR_NULL = -1;
	public final static int SI = 0;
	public final static int NO = 1;

	public static int valida_int(String message, String title) {

		int numUno = 0;
		String convertir = "";

		// --------INTRODUIR INT-----
		while (true) {
			try {
				convertir = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				if (convertir == null) {
					JOptionPane.showMessageDialog(null, "Saliendo de la aplicación", "Saliendo", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);// Si cliques en tancar, et trau fora i canceles l'ejecució del programa.
				} else {
					numUno = Integer.parseInt(convertir);
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un num int", "Error", JOptionPane.ERROR_MESSAGE);
				continue;
			}
		}

		return numUno;
	}

	public static float valida_float(String message, String title) {

		float numUno = 0;
		String convertir = "";

		// --------INTRODUIR INT-----
		while (true) {
			try {
				convertir = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				if (convertir == null) {
					JOptionPane.showMessageDialog(null, "Saliendo de la aplicación", "Saliendo", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);// Si cliques en tancar, et trau fora i canceles l'ejecució del programa.
				} else {
					numUno = Float.parseFloat(convertir);
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un num float", "Error", JOptionPane.ERROR_MESSAGE);
				continue;
			}
		}

		return numUno;
	}

	public static char valida_char(String message, String title) {

		String convertir;
		char continuarChar;

		while (true) {
			try {
				convertir = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				if (convertir == null) {
					System.exit(0);
					;

				} else {
					continuarChar = convertir.charAt(0);
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido una letra", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return continuarChar;
	}

	public static String valida_String(String message, String title) {
		String conjuntoDeCaracteres = "";
		while (true) {
			conjuntoDeCaracteres = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
			if (conjuntoDeCaracteres == null) {
				JOptionPane.showMessageDialog(null, "Saliendo de la aplicación", "Saliendo", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} else if (conjuntoDeCaracteres.equals("")) {
				JOptionPane.showMessageDialog(null, "Error de introducción de datos", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				break;

			}
		}
		return conjuntoDeCaracteres;
	}

	public static boolean valida_boolean(String message, String title) {
		int selectorSiNo = SI;
		boolean returnSiNo = true;
		String SiNoMatriz[] = { "SI", "NO" };
		selectorSiNo = JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.QUESTION_MESSAGE, null, SiNoMatriz, SiNoMatriz[0]);
		if (selectorSiNo == SALIR_NULL) {
			System.exit(0);
		} else if (selectorSiNo == NO) {
			returnSiNo = false;
		}

		return returnSiNo;

	}
//
//	public static CustomDate valida_CustomDate(String message) throws ParseException {
//		String AttributeValue = "";
//		while (true) {
//			AttributeValue = framework.utils.valida.valida_String(message + "\n\nFORMAT:\ndd/mm/yyyy", message);
//			boolean validate = framework.modules.fecha.utils.DatesUtils.ValidaDate(AttributeValue);
//			if (validate == false) {
//				JOptionPane.showMessageDialog(null, "Introduce una fecha en el formato correcto", "ERROR",
//						JOptionPane.ERROR_MESSAGE);
//			} else {
//				CustomDate date = new CustomDate(AttributeValue);
//				return date;
//			}
//
//		}
//	}

	public static CustomDate valida_CustomDate_botons(String message) throws ParseException {
		return DatesUtils.ValidaDate_int(message);
	}

}
