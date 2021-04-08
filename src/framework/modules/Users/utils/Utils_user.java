package framework.modules.Users.utils;

import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import framework.modules.Users.User;
import framework.utils.format;

public class Utils_user {
	public static User login() {

		JTextField userName = new JTextField();
		JTextField password = new JPasswordField();
		Object[] message = { "Username:", userName, "Password:", password };
		while (true) {
			int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				Singletone_User.userNum = find_User_name_password(userName.getText(), password.getText());
				if (Singletone_User.userNum == -1) {
					JOptionPane.showMessageDialog(null, "El nombre de usuario o contraseña son incorretos", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					Singletone_User.yourUser = Singletone_User.user.get(Singletone_User.userNum);
					JOptionPane.showMessageDialog(null, "¡Hola " + Singletone_User.yourUser.getName() + "!\nNos alegramos de volver a verte", "Welcome", JOptionPane.INFORMATION_MESSAGE);
					return Singletone_User.yourUser;
				}
			} else {
				return null;
			}
		}
	}

	public static User Register() throws ParseException {
//		String name;
//		String password;
//		String password2;
//		String email;
//		String type = "Client";
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
						JOptionPane.showMessageDialog(null, "El usuario debe de tener entre 5 y 12 carácteres", "ERROR User Name", JOptionPane.ERROR_MESSAGE);
					} else if (find_User_name(userName.getText()) != -1) {
						JOptionPane.showMessageDialog(null, "Este nombre de usuario ya está en uso", "ERROR User Name", JOptionPane.ERROR_MESSAGE);
					} else if (format.email(email.getText()) != true) {
						JOptionPane.showMessageDialog(null, "El email no está en el formato correcto", "ERROR email", JOptionPane.ERROR_MESSAGE);
					} else if (find_User_email(email.getText()) != -1) {
						JOptionPane.showMessageDialog(null, "Este e-mail ya está en uso", "ERROR email", JOptionPane.ERROR_MESSAGE);
					} else if (firstPassword.getText().length() < 6 || (firstPassword.getText().length() > 13)) {
						JOptionPane.showMessageDialog(null, "La contraseña debe de tener entre 5 y 12 carácteres", "ERROR Password", JOptionPane.ERROR_MESSAGE);
					} else if (!firstPassword.getText().equals(passwordConfirm.getText())) {
						JOptionPane.showMessageDialog(null, "Introduce la misma contraseña en los dos campos", "ERROR Password", JOptionPane.ERROR_MESSAGE);
					} else {
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, rellene todo el formulario", "Login", JOptionPane.QUESTION_MESSAGE);
				}
			} else {
				return null;
			}
		}
		User Usuario = new User(userName.getText(), firstPassword.getText(), email.getText(), "Client");
		Singletone_User.user.add(Usuario);
		return Usuario;
	}

	public static int find_User_name(String name) {

		for (int i = 0; i < Singletone_User.user.size(); i++) {
			if ((Singletone_User.user.get(i).getName().equals(name))) {
				return 0;
			}
		}
		return -1;
	}

	public static int find_User_email(String email) {

		for (int i = 0; i < Singletone_User.user.size(); i++) {
			if ((Singletone_User.user.get(i).getEmail().equals(email))) {
				return 0;
			}
		}
		return -1;
	}

	public static int find_User_name_password(String name, String password) {

		for (int i = 0; i < Singletone_User.user.size(); i++) {
			if ((Singletone_User.user.get(i).getName().equals(name)) && (Singletone_User.user.get(i).getPassword().equals(password))) {
				return i;
			}
		}
		return -1;
	}

	public static int validaLogin(String name, String password) {

		for (int i = 0; i < Singletone_User.user.size(); i++) {
			if ((Singletone_User.user.get(i).getName().equals(name)) && (Singletone_User.user.get(i).getPassword().equals(password))) {
				return i;
			}
		}
		return -1;
	}
}
