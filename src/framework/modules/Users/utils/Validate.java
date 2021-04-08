package framework.modules.Users.utils;

import java.text.ParseException;

import javax.swing.JOptionPane;

import framework.utils.format;
import framework.utils.valida;

public class Validate {
	public static String valida_email(String Type) throws ParseException {
		String email = null;
		boolean validator = false;
		do {
			email = valida.valida_String("Writte your Email", "Email " + Type);
			validator = format.email(email);
			if (validator == false)
				JOptionPane.showMessageDialog(null, "You have not entered a Email valide", "ERROR", JOptionPane.INFORMATION_MESSAGE);

		} while (validator == false);
		return email;
	}
}
