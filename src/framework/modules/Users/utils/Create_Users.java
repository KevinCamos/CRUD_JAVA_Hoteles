package framework.modules.Users.utils;

import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import framework.modules.Users.User;
import framework.utils.format;
import framework.utils.menu;
import framework.utils.valida;

public class Create_Users {

	public static void Create_Choise_User() throws ParseException {

		String[] types = { "Admin", "Employee", "Client" };
		String type = menu.menu_combo("Elige un tipo de usuario", "User Type", types);
		JTextField userName = new JTextField();
		JTextField email = new JTextField();
		JTextField firstPassword = new JPasswordField();
		JTextField passwordConfirm = new JPasswordField();

		;

		Object[] message = { "Username:", userName, "E-mail: ", email, "Password:", firstPassword, "Password confirm", passwordConfirm };
		while (true) {
			int option = JOptionPane.showConfirmDialog(null, message, "Register", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				if (!userName.getText().equals("") && !email.getText().equals("") && !firstPassword.getText().equals("") && !passwordConfirm.getText().equals("")) {
					if (userName.getText().length() < 6 && (userName.getText().length() > 13)) {
						JOptionPane.showMessageDialog(null, "El usuario debe de tener entre 5 y 12 car�cteres", "ERROR User Name", JOptionPane.ERROR_MESSAGE);
					} else if (Utils_user.find_User_name(userName.getText()) != -1) {
						JOptionPane.showMessageDialog(null, "Este nombre de usuario ya est� en uso", "ERROR User Name", JOptionPane.ERROR_MESSAGE);
					} else if (format.email(email.getText()) != true) {
						JOptionPane.showMessageDialog(null, "El email no est� en el formato correcto", "ERROR email", JOptionPane.ERROR_MESSAGE);
					} else if (Utils_user.find_User_email(email.getText()) != -1) {
						JOptionPane.showMessageDialog(null, "Este e-mail ya est� en uso", "ERROR email", JOptionPane.ERROR_MESSAGE);
					} else if (firstPassword.getText().length() < 6 || (firstPassword.getText().length() > 13)) {
						JOptionPane.showMessageDialog(null, "La contrase�a debe de tener entre 5 y 12 car�cteres", "ERROR Password", JOptionPane.ERROR_MESSAGE);
					} else if (!firstPassword.getText().equals(passwordConfirm.getText())) {
						JOptionPane.showMessageDialog(null, "Introduce la misma contrase�a en los dos campos", "ERROR Password", JOptionPane.ERROR_MESSAGE);
					} else {
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, rellene todo el formulario", "Login", JOptionPane.QUESTION_MESSAGE);
				}
			} else {
				return;
			}
		}
		User Usuario = new User(userName.getText(), firstPassword.getText(), email.getText(), type);
		Singletone_User.user.add(Usuario);

	}

	public static User Register() {
		String password;
		String password2;
		String type = "Client";
		String name = valida.valida_String("Introduce un nombre de usuario", type + " Name");
		while (true) {
			password = valida.valida_String("Introduce una contrase�a", type + " Password");
			password2 = valida.valida_String("Vuelve a introducir una contrase�a", type + " Password");
			if (password2 != password) {
				JOptionPane.showMessageDialog(null, "No has introducido la misma contrase�a", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else
				break;
		}
		String email = valida.valida_String("Introduce un correo electr�nico", type + " E-Mail");
		User Usuario = new User(name, password, email, type);

		return Usuario;

	}

//	public static User Register.sadasd() {
//		String type = "Client";
//		String name = valida.valida_String("Introduce un nombre de usuario", type + " Name");
//		String password = valida.valida_String("Introduce una contrase�a", type + " Password");
//		String email = valida.valida_String("Introduce un correo electr�nico", type + " E-Mail");
//		User Usuario = new User(name, password, email, type);
//
//		return Usuario;
//
//	}
}
