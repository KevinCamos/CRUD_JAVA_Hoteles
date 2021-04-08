package framework.modules.order;

import java.util.Comparator;

import framework.modules.Users.User;

public class OrderUsers implements Comparator<User> {
	public int compare(User userName0, User userName1) {

		return userName0.getName().compareTo(userName1.getName());

	}
}
