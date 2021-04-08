package framework.main;

import java.awt.HeadlessException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import framework.modules.Users.utils.Singletone_User;
import framework.modules.languages.Language;
import framework.modules.rooms.utils.Singletone;
import framework.utils.menu;

public class Menu_Rooms {

	public static void Menu_Room() throws HeadlessException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException {
		int selection = 0;
		Language language = Language.getInstance();
		String menuRoom[] = null;
		String logOut = language.getProperty("Logout");
		while (true) {
			if ("AAA_Invited".equals(Singletone_User.yourUser.getName()))
				logOut = language.getProperty("ReturnMenu");
			else if ("Admin".equals(Singletone_User.yourUser.getType()))
				logOut = language.getProperty("ReturnAdmin");
			menuRoom = new String[] { language.getProperty("TypeSingle"), language.getProperty("TypeTwice"), language.getProperty("TypeSuite"), language.getProperty("TypeConfig"), logOut };
			String exit[] = { "Continue in the System", "Exit" };
			Singletone.roomType = menu.menu_botons_no_closed_null(language.getProperty("ChooseRoom"), language.getProperty("TypeRoom"), menuRoom);
			// si li dones a eixir, ix fixe, solventar-ho
			switch (Singletone.roomType) {
				case SINGLE:/// SI ES SINGLE
				case TWICE://// SI ES TWICE
				case SUITE://// O SI S SUITE, ENTRARÁN EN ESTA FUNCIÓ
					Menu_CRUD.menu_CRUD();
					break;
				case CONFIG: {
					ConfigurationMenu.menu_Configuration();
					break;
				}
				case LOGOUT: {
					return;
				}
				default: {
					selection = menu.menu_botons(language.getProperty("MessageExitAsk"), language.getProperty("MessageExitAsk"), exit);
					if (selection == SALIR || selection == SALIR_NULL) {
						menu.exit();
					}
					JOptionPane.showMessageDialog(null, language.getProperty("MessageReturnMenu"), language.getProperty("OptionReturn"), JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	protected final static int SINGLE = 0;
	protected final static int TWICE = 1;
	protected final static int SUITE = 2;
	protected final static int CONFIG = 3;
	protected final static int LOGOUT = 4;
	protected final static int SALIR_NULL = -1;
	protected final static int SALIR = 1;
}
