package framework.main;

import framework.modules.Users.utils.Singletone_User;
import framework.modules.Users.utils.Update_Users;
import framework.modules.config.ConfigProgram;
import framework.modules.languages.Language;

public class ConfigurationMenu {
	public static void menu_Configuration() {
		boolean interruptor = false;
		int OptionConfig = 0;
		Language language = Language.getInstance();
		String menuConfig[] = null;
		do {
			if ("AAA_Invited".equals(Singletone_User.yourUser.getName())) {
				menuConfig = new String[] { Language.getInstance().getProperty("OptionLanguage"), language.getProperty("OptionFormate"), language.getProperty("OptionReturn") };

			} else {
				menuConfig = new String[] { Language.getInstance().getProperty("OptionLanguage"), language.getProperty("OptionFormate"), "User Configuration", (language.getProperty("OptionReturn")) };

			}

			OptionConfig = framework.utils.menu.menu_botons(language.getProperty("MessageMenuConfig"), language.getProperty("TitleMenuConfig"), menuConfig);

//			if (OptionConfig == SALIR_NULL) {
//				framework.utils.menu.exit();
//			}
			if ("Invited".equals(Singletone_User.yourUser.getName()) && OptionConfig == USER_CONFIG)
				OptionConfig = RETURN;

			switch (OptionConfig) {
				case LANGUAGE: {
					ConfigProgram.getInstance().setLanguage();
					break;
				}
				case FORMAT: {
					ConfigProgram.getInstance().setDateFormat();
					break;
				}
				case USER_CONFIG: {
					Update_Users.Update_User();
					break;
				}
				default: {
					interruptor = true;
				}
			}
		} while (interruptor == false);

	}

	protected final static int LANGUAGE = 0;
	protected final static int FORMAT = 1;
	protected final static int USER_CONFIG = 2;
	protected final static int RETURN = 3;

	protected final static int SALIR_NULL = -1;

}
