package framework.utils;

import javax.swing.JOptionPane;

public class menu {
	public final static int SALIR_NULL = -1;
	public final static int SALIR_BOTON = 2;
	public final static int MENU_PRINCIPAL = 1;

	public static int menu_botons(String message, String title, String[] OpcionsMenuBotonsSTRING) {
		int OpcionsMenuInt = 0;

		OpcionsMenuInt = JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.QUESTION_MESSAGE, null,
				OpcionsMenuBotonsSTRING, OpcionsMenuBotonsSTRING[0]);
		if (OpcionsMenuInt == SALIR_NULL) {
			exit();
		}
		return OpcionsMenuInt;
	}

	public static int menu_botons_no_closed_null(String message, String title, String[] OpcionsMenuBotonsSTRING) {
		int OpcionsMenuInt = 0;

		OpcionsMenuInt = JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.QUESTION_MESSAGE, null,
				OpcionsMenuBotonsSTRING, OpcionsMenuBotonsSTRING[0]);
		return OpcionsMenuInt;
	}

//	public static int menu_botons(String message, String title, String[] OpcionsMenuBotonsSTRING) {
//		int OpcionsMenuInt = 0;
//
//		OpcionsMenuInt = JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.QUESTION_MESSAGE, null,
//				OpcionsMenuBotonsSTRING, OpcionsMenuBotonsSTRING[0]);
//		if (OpcionsMenuInt == SALIR_NULL) {
//			exit();
//		}
//		return OpcionsMenuInt;
//	}

	public static String menu_combo(String message, String title, Object[] suite1) {
		Object menuPrincipal = null;
		String menuPrincipalString = "";
		menuPrincipal = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null, suite1,
				suite1[0]);
		if (menuPrincipal == null) {
			exit();
		}
		menuPrincipalString = menuPrincipal.toString();
		return menuPrincipalString;

	}

	public static String menu_combo_no_closed_null(String message, String title, Object[] room) {
		Object menuPrincipal = null;
		String menuPrincipalString = "";
		menuPrincipal = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null, room,
				room[0]);
		if (menuPrincipal == null) {

			return menuPrincipalString;
		}
		menuPrincipalString = menuPrincipal.toString();
		return menuPrincipalString;

	}

	public static int modifyAttributesRoom_or_exit() {
		String[] options = { "Modiffy Attribute", "Return CRUD", "Exit Program" };
		int selector = 0;
		selector = JOptionPane.showOptionDialog(null, " ¿What do you want to do?", "Choose an Option", 0,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (selector == SALIR_NULL || selector == SALIR_BOTON) {
			exit();

		}
		return selector;
	}

	public static int button_backToMenu() {
		String[] options = { "Stay Here", "Change Type Room", "Exit Program" };
		int selector = 0;
		selector = JOptionPane.showOptionDialog(null, "¿What do you want to do?" + "Choose an Option", null, 0,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (selector == SALIR_NULL || selector == SALIR_BOTON) {
			exit();
		}
		return selector;
	}

//	public static void messageInformation(String message, String title) {
//		String[] options = { Language.getInstance().getProperty("OK") };
//		JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.INFORMATION_MESSAGE, null, options,
//				options[0]);
//	}

	public static void exit() {
//		messageInformation("SDAS", "ASD");
		JOptionPane.showMessageDialog(null, "Exit System", "Exit", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
