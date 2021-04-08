package framework.modules.languages;

import java.io.IOException;
import java.util.Properties;

import framework.modules.config.ConfigProgram;

public class Language extends Properties {

	private static final long serialVersionUID = 4424580175082238561L;
	private static Language instance;

	public Language() {

		switch (ConfigProgram.getInstance().getLanguage()) {
		case ENGLISH:
			getProperties("english.properties");
			break;
		case ESPAÑOL:
			getProperties("espanol.properties");
			break;
		case KLINGON:
			getProperties("klingon.properties");
			break;
		default:
			getProperties("espanol.properties");
		}

	}

	public void setLanguage(int idioma) {
		switch (ConfigProgram.getInstance().getLanguage()) {
		case ENGLISH:
			getProperties("english.properties");
			break;
		case ESPAÑOL:
			getProperties("espanol.properties");
			break;
		case KLINGON:
			getProperties("klingon.properties");
			break;
		default:
			getProperties("espanol.properties");
		}

	}

	public void getProperties(String idioma) {
		try {
			this.load(getClass().getResourceAsStream(idioma));
		} catch (IOException ex) {
		}
	}

	public static Language getInstance() {
		if (instance == null) {
			instance = new Language();
		}
		return instance;
	}

	protected final static int ENGLISH = 0;
	protected final static int ESPAÑOL = 1;
	protected final static int KLINGON = 2;
}
