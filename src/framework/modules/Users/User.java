package framework.modules.Users;

import java.text.ParseException;

import framework.modules.Users.utils.Create_Users;
import framework.modules.rooms.utils.orderChair;
import framework.utils.valida;

public class User implements Comparable<User> {

	private String name;
	private String password;
	private String email;
	private String type;

	public User(String name, String password, String email, String type) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.type = type;
	}

	public User() throws ParseException {
		Create_Users.Create_Choise_User();
	}

	public User(int Admin0_Employee1_Client2) {
		this.name = valida.valida_String("Introduce un nombre de usuario", "User Name");
		this.password = valida.valida_String("Introduce una contraseña", "User Password");
		this.email = valida.valida_String("Introduce un correo electrónico", "User E-Mail");

		switch (Admin0_Employee1_Client2) {
			case 0 -> this.type = "Admin";
			case 1 -> this.type = "Employee";
			case 2 -> this.type = "Client";
			default -> this.type = "Client";
		}

	}

	public User(String name) {
		this.name = valida.valida_String("Introduce un nombre de usuario", "User Name");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		String chair = "";
		chair += orderChair.AddLineTitle("User " + type);
		chair += orderChair.AddLineText("Name", name);
		chair += orderChair.AddLineText("Name", email);
		return chair;
	}

	@Override
	public int compareTo(User arg0) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
