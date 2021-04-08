package framework.modules.Users.utils;

import javax.swing.JOptionPane;

import framework.utils.menu;

public class Read_Users {
	public static void Sellect_User() {
		String numRoomSelect = "";
		String[] OptionsList = { "Admin", "Employee", "Client" };
		int optionUser = menu.menu_botons_no_closed_null("Choose a Type User", "Choose User", OptionsList);
		String[] primaryKeyList = Update_Users.Search_ListUsers(optionUser);
		numRoomSelect = menu.menu_combo_no_closed_null("Elige un usuario que desees modificar", "Selecciona Usuario", primaryKeyList);
		for (int i = 0; i < Singletone_User.user.size(); i++) {
			if (numRoomSelect == Singletone_User.user.get(i).getName()) {
				JOptionPane.showMessageDialog(null, Singletone_User.user.get(i).toString(), "Data Users", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}
}
