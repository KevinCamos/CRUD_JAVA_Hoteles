package framework.modules.Users.utils;

import java.util.ArrayList;

import framework.utils.menu;
import framework.utils.valida;

public class Update_Users {

	public static void Sellect_User() {
		String numRoomSelect = "";
		String[] OptionsList = { "Admin", "Employee", "Client" };
		int optionUser = menu.menu_botons_no_closed_null("Choose a Type User", "Choose User", OptionsList);
		String[] primaryKeyList = Search_ListUsers(optionUser);
		numRoomSelect = menu.menu_combo_no_closed_null("Elige un usuario que desees modificar", "Selecciona Usuario", primaryKeyList);
		for (int i = 0; i < Singletone_User.user.size(); i++) {
			if (numRoomSelect == Singletone_User.user.get(i).getName()) {
				Update_User(i);
				break;
			}
		}
	}

	public static void Update_User(int user) {
		String[] types = { "Admin", "Employee", "Client" };
		String[] primaryKeyList = { "Name", "Password", "Email", "Type" };
		int optionSelect = menu.menu_botons("¿Qué deseas modificar?", "Escoge sabiamente", primaryKeyList);

		switch (optionSelect) {
			case 0 -> Singletone_User.user.get(user).setName(valida.valida_String("Introduce un nombre de usuario", "User Name"));
			case 1 -> Singletone_User.user.get(user).setPassword(valida.valida_String("Introduce una contraseña", "User Password"));
			case 2 -> Singletone_User.user.get(user).setEmail(valida.valida_String("Introduce un correo electrónico", "User E-Mail"));
			case 3 -> Singletone_User.user.get(user).setType(menu.menu_combo("Elige un tipo de usuario", "User Type", types));

		}
	}

	public static void Update_User() {
		String[] types = { "Admin", "Employee", "Client" };
		String[] primaryKeyList = { "Name", "Password", "Email" };

		if ("Admin".equals(Singletone_User.yourUser.getType()))
			primaryKeyList = new String[] { "Name", "Password", "Email", "Type" };

		int optionSelect = menu.menu_botons_no_closed_null("¿Qué deseas modificar?", "Escoge sabiamente", primaryKeyList);

		switch (optionSelect) {
			case 0 -> Singletone_User.yourUser.setName(valida.valida_String("Introduce un nombre de usuario", "User Name"));
			case 1 -> Singletone_User.yourUser.setPassword(valida.valida_String("Introduce una contraseña", "User Password"));
			case 2 -> Singletone_User.yourUser.setEmail(valida.valida_String("Introduce un correo electrónico", "User E-Mail"));
			case 3 -> Singletone_User.yourUser.setType(menu.menu_combo("Elige un tipo de usuario", "User Type", types));

		}
	}

	public static String[] Search_ListUsers(int Option) {
		ArrayList<String> primaryKeyArray = new ArrayList<String>();
		String[] primaryKeyList = null;

		switch (Option) {
			case 0: {
				primaryKeyList = new String[Singletone_User.user.size()];
				for (int i = 0; i < Singletone_User.user.size(); i++) {
					if ("Admin".equals(Singletone_User.user.get(i).getType()))
						primaryKeyArray.add(Singletone_User.user.get(i).getName());
				}
				break;
			}
			case 1: {
				primaryKeyList = new String[Singletone_User.user.size()];
				for (int i = 0; i < Singletone_User.user.size(); i++) {
					if ("Employee".equals(Singletone_User.user.get(i).getType()))
						primaryKeyArray.add(Singletone_User.user.get(i).getName());
				}
				break;

			}
			case 2: {
				primaryKeyList = new String[Singletone_User.user.size()];
				for (int i = 0; i < Singletone_User.user.size(); i++) {
					if ("Client".equals(Singletone_User.user.get(i).getType()))
						primaryKeyArray.add(Singletone_User.user.get(i).getName());
				}
				break;

			}
		}
		primaryKeyList = primaryKeyArray.toArray(new String[0]);
		return primaryKeyList;
	}
//	public static boolean Find_if_Empty() {
//	boolean interruptor = false;
//	if (Singletone_User.user.isEmpty()) {
//		JOptionPane.showMessageDialog(null, "Aun no has creado ningung " + Select_Name_Room_String.GetNameRoom(),
//				"ERROR", JOptionPane.ERROR_MESSAGE);
//		return interruptor
//	}
//	return interruptor = true;
//}

}
