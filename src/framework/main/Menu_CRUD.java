package framework.main;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.util.ArrayList;

import framework.modules.Users.utils.Singletone_User;
import framework.modules.rooms.utils.funtions_CRUD.Create;
import framework.modules.rooms.utils.funtions_CRUD.Delate;
import framework.modules.rooms.utils.funtions_CRUD.Order;
import framework.modules.rooms.utils.funtions_CRUD.Read;
import framework.modules.rooms.utils.funtions_CRUD.Update;
import framework.utils.menu;

public class Menu_CRUD {

	public static void menu_CRUD() throws HeadlessException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException {
		int OptionsCRUD = 0;
		ArrayList<String> CRUDStrings = new ArrayList<String>();

		switch (Singletone_User.yourUser.getType()) {
			case "Admin":
				CRUDStrings.add("Create");
				CRUDStrings.add("Read");
				CRUDStrings.add("Update");
				CRUDStrings.add("Delete");
				CRUDStrings.add("Order");
				CRUDStrings.add("Return");
				break;
			case "Employee":
				CRUDStrings.add("Read");
				CRUDStrings.add("Update");
				CRUDStrings.add("Delete");
				CRUDStrings.add("Order");
				CRUDStrings.add("Return");
				break;
			case "Client":
				CRUDStrings.add("Read");
				CRUDStrings.add("Order");
				CRUDStrings.add("Return");
				break;
			default:
				CRUDStrings.add("Read");
				CRUDStrings.add("Order");
				CRUDStrings.add("Return");
		}
		String menuCRUD[] = CRUDStrings.toArray(new String[0]);
		while (true) {
			OptionsCRUD = menu.menu_botons("What function do you want to perform?", "CRUD", menuCRUD);
			OptionsCRUD = optionsCRUD_number(OptionsCRUD);
			switch (OptionsCRUD) {
				case CREATE -> Create.Create_Room();
				case READ -> Read.Read_Room();
				case UPDATE -> Update.Update_Room();
				case ORDER -> Order.Order_Room();
				case DELATE -> Delate.Delate_room();
				case RETURN -> {
					return;
				}
			}
		}
	}

	public static int optionsCRUD_number(int OptionsCRUD) {
		switch (Singletone_User.yourUser.getType()) {
			case "Admin":
				return OptionsCRUD;
			case "Employee":
				return OptionsCRUD + 1;
			default:
				switch (OptionsCRUD) {
					case 0 -> OptionsCRUD = READ;
					case 1 -> OptionsCRUD = ORDER;
					case 2 -> OptionsCRUD = RETURN;
				}
				return OptionsCRUD;
		}
	}

	protected final static int SALIR_NULL = -1;
	protected final static int CREATE = 0;
	protected final static int READ = 1;
	protected final static int UPDATE = 2;
	protected final static int DELATE = 3;
	protected final static int ORDER = 4;
	protected final static int RETURN = 5;
	protected final static int YES = 1;
	protected final static int RETURN_MENU = 1;

}