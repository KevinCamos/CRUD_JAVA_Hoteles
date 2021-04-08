
import java.awt.Font;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.UIManager;

import framework.main.Main_Admin;
import framework.main.Menu_Rooms;
import framework.modules.Users.User;
import framework.modules.Users.utils.Singletone_User;
import framework.modules.Users.utils.Utils_user;
import framework.modules.config.ConfigProgram;
import framework.modules.languages.Language;
import framework.modules.rooms.classes.Single;
import framework.modules.rooms.classes.Suite;
import framework.modules.rooms.classes.Twice;
import framework.modules.rooms.utils.Singletone;
import framework.modules.rooms.utils.funtions_CRUD.Order;
import framework.utils.menu;

public class Main_Menu {

	public static void main(String[] args) throws ParseException, HeadlessException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		String[] OptionDummies = { "YES", "NO" };
		UIManager.put("Button.font", Font.ITALIC);
		ConfigProgram.getInstance();
		Language language = Language.getInstance();
		Singletone.roomSingle = new ArrayList<Single>();
		Singletone.roomTwice = new ArrayList<Twice>();
		Singletone.roomSuite = new ArrayList<Suite>();
		Singletone.roomType = 0;
		Singletone_User.user = new ArrayList<User>();
		Singletone_User.dommies();
		Order.Order_User();
		String[] OptionUser = { language.getProperty("Main_Menu.OptionUser.MenuCrud"), language.getProperty("Main_Menu.OptionUser.IniciarSesion"), language.getProperty("Main_Menu.OptionUser.CrearUsuario") };
		if (menu.menu_botons(language.getProperty("Main_Menu.Dummies.Message"), language.getProperty("Main_Menu.Dummies.Title"), OptionDummies) == 0)
			Singletone.dommies();

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		while (true) {
			do {
				int UserOption = menu.menu_botons(language.getProperty("Main_Menu.UserOption.Message"), language.getProperty("Main_Menu.UserOption.Title"), OptionUser);
				switch (UserOption) {
					case MENU_CRUD -> Singletone_User.yourUser = Singletone_User.user.get(0);
					case INICIAR_SESION -> Singletone_User.yourUser = Utils_user.login();
					case CREAR_USUARIO -> Singletone_User.yourUser = Utils_user.Register();
				}
			} while (Singletone_User.yourUser == null);

			switch (Singletone_User.yourUser.getType()) {
				case ADMINISTRATOR -> Main_Admin.Admin_Main();
				default -> Menu_Rooms.Menu_Room();
			}
		}
	}

	protected final static int MENU_CRUD = 0;
	protected final static int INICIAR_SESION = 1;
	protected final static int CREAR_USUARIO = 2;
	protected final static String ADMINISTRATOR = "Admin";

}
