package framework.main;

import java.awt.HeadlessException;
import java.text.ParseException;

import framework.modules.Users.utils.Create_Users;
import framework.modules.Users.utils.Read_Users;
import framework.modules.Users.utils.Singletone_User;
import framework.modules.Users.utils.Update_Users;
import framework.modules.rooms.utils.funtions_CRUD.Order;
import framework.utils.menu;

public class Main_Admin {

	public static void Admin_Main() throws HeadlessException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException {
		while (true) {
			Order.Order_User();
			String[] OptionMain = { "Create User", "Read User", "Update User", "CRUD Main", "Log Out" };
			int OptionSelect = menu.menu_botons("Hello " + Singletone_User.yourUser.getName() + " ¿Do you want to do?", "Admin Main", OptionMain);
			switch (OptionSelect) {
				case CREATE_USERS -> Create_Users.Create_Choise_User();
				case READ_USERS -> Read_Users.Sellect_User();
				case UPDATE_USERS -> Update_Users.Sellect_User();
//			case DELATE_USERS -> 
				case CRUD -> Menu_Rooms.Menu_Room();
				default -> {
					return;
				}
			}
		}
	}

	protected final static int CREATE_USERS = 0;
	protected final static int READ_USERS = 1;
	protected final static int UPDATE_USERS = 2;
	protected final static int CRUD = 3;
//	protected final static int LOGOUT = 3;

}
