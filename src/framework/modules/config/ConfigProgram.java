package framework.modules.config;

import java.text.SimpleDateFormat;

import framework.modules.languages.Language;
import framework.utils.menu;

public class ConfigProgram {

	private int language;
	private SimpleDateFormat dateFormat;

	private static ConfigProgram instance;

	public ConfigProgram(int English0_Español1_Klingon2, String dateFormat) {
		this.language = English0_Español1_Klingon2;
		this.dateFormat = new SimpleDateFormat(dateFormat);
	}

	public ConfigProgram() {
		String[] languages = { "English/Inglés", "Español/Spanish", "tlhIngan/Klingon" };
		this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.language = menu.menu_botons("Selecciona un idioma", "Selector de idioma", languages);
	}

	public int getLanguage() {
		return language;
	}

	/**
	 * English 0 / Español 1 / Klingon 2
	 */
	public void setLanguage(int English0_Español1_Klingon2) {
		this.language = English0_Español1_Klingon2;
		Language.getInstance().setLanguage(English0_Español1_Klingon2);
	}

	public void setLanguage() {
		String[] languages = { "English/Inglés", "Español/Spanish", "tlhIngan/Klingon" };

		this.language = framework.utils.menu.menu_botons(Language.getInstance().getProperty("MessageIdiomSelector"), Language.getInstance().getProperty("TitleIdiomSelector"), languages);
		Language.getInstance().setLanguage(this.language);
	}

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat() {
		String[] formate = { "dd/MM/yyyy", "dd-MM-yyyy", "dd.MM.yyyy" };
		this.dateFormat = new SimpleDateFormat(framework.utils.menu.menu_combo(Language.getInstance().getProperty("MessageFormatSelector"), Language.getInstance().getProperty("TitleFormatSelector"), formate));
	}

	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = new SimpleDateFormat(dateFormat);
	}

	public static ConfigProgram getInstance() {
		if (instance == null) {
			instance = new ConfigProgram();
		}
		return instance;
	}

//	public String toString(ConfigProgram config) {
//		String cad = "";
//		cad = cad + (Languages.message("toStringlanguage", config, 0) + this.getLanguage() + "\n");
//		cad = cad + (Languages.message("toStringdate", config, 0) + this.getDate() + "\n");
//		cad = cad + (Languages.message("toStringcurrency", config, 0) + this.getCurrency() + "\n");
//		cad = cad + (Languages.message("toStringdecimal", config, 0) + this.getDecimal() + "\n");
//		return cad;
//	}
	protected final static int ENGLISH = 0;
	protected final static int ESPAÑOL = 1;
	protected final static int KLINGON = 2;
}
