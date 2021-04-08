package framework.modules.Users.utils;

import java.util.ArrayList;

import framework.modules.Users.User;

public class Singletone_User {

	public static ArrayList<User> user;
	public static int userNum = 0;
	public static User yourUser = null;

	public Singletone_User() {

		Singletone_User.user = new ArrayList<User>();
	}

	public static void dommies() {
		User Invited = new User("AAA_Invited", "AAA_Invited", "invited@CRUD.com", "Invited");

		User Admin0 = new User("Admin", "Admin", "admin@gmail.com", "Admin");
		User Admin1 = new User("Kevin", "Kevin", "kevin@gmail.com", "Admin");
		User Admin2 = new User("Yomogan", "Yomogan", "yomogan@gmail.com", "Admin");
		User Admin3 = new User("Darth Vader", "Padme", "LordSith@gmail.com", "Admin");

		User Employee0 = new User("Employee", "Employee", "employee@gmail.com", "Employee");
		User Employee1 = new User("Pep", "Pep", "pep@gmail.com", "Employee");
		User Employee2 = new User("Carolina", "Carolina", "carolina@gmail.com", "Employee");
		User Employee3 = new User("Willow", "Willow", "willow_the_wizard@gmail.com", "Employee");

		User Client0 = new User("Client", "Client", "client@gmail.com", "Client");
		User Client1 = new User("Javi", "Javi", "javi@gmail.com", "Client");
		User Client2 = new User("Xiang Di", "Xiang Di", "xiangdistreamer@gmail.com", "Client");
		User Client3 = new User("Gollum", "Gollum", "gollum_my_precious@gmail.com", "Client");

		Singletone_User.user.add(Invited);

		Singletone_User.user.add(Admin0);
		Singletone_User.user.add(Admin1);
		Singletone_User.user.add(Admin2);
		Singletone_User.user.add(Admin3);

		Singletone_User.user.add(Employee0);
		Singletone_User.user.add(Employee1);
		Singletone_User.user.add(Employee2);
		Singletone_User.user.add(Employee3);

		Singletone_User.user.add(Client0);
		Singletone_User.user.add(Client1);
		Singletone_User.user.add(Client2);
		Singletone_User.user.add(Client3);

	}
}
