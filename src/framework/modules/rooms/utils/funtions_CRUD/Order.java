package framework.modules.rooms.utils.funtions_CRUD;

import java.util.Collections;

import framework.modules.Users.utils.Singletone_User;
import framework.modules.order.OrderBeds;
import framework.modules.order.OrderDateEntry;
import framework.modules.order.OrderNumRoom;
import framework.modules.order.OrderUsers;
import framework.modules.rooms.utils.Singletone;
import framework.utils.menu;

public class Order {

	public static void Order_Room() {
		String[] optionOrder = { "Numero de Habitación", "Fecha de entrada", "Número de camas" };
		Singletone.selectOption = menu.menu_botons("¿Por qué valor deseas ordenar las habitaciones?", "Ordenar", optionOrder);

		switch (Singletone.selectOption) {
			case SINGLE: {
				Collections.sort(Singletone.roomSingle, new OrderNumRoom());
				Collections.sort(Singletone.roomTwice, new OrderNumRoom());
				Collections.sort(Singletone.roomSuite, new OrderNumRoom());
				break;
			}
			case TWICE: {
				Collections.sort(Singletone.roomSingle, new OrderDateEntry());
				Collections.sort(Singletone.roomTwice, new OrderDateEntry());
				Collections.sort(Singletone.roomSuite, new OrderDateEntry());
				break;
			}
			case SUITE: {
				Collections.sort(Singletone.roomSingle, new OrderBeds());
				Collections.sort(Singletone.roomTwice, new OrderBeds());
				Collections.sort(Singletone.roomSuite, new OrderBeds());
				break;
			}
		}
	}

	public static void Order_Room_Automatic() {
		switch (Singletone.selectOption) {
			case SINGLE: {
				Collections.sort(Singletone.roomSingle, new OrderNumRoom());
				Collections.sort(Singletone.roomTwice, new OrderNumRoom());
				Collections.sort(Singletone.roomSuite, new OrderNumRoom());
				break;
			}
			case TWICE: {
				Collections.sort(Singletone.roomSingle, new OrderDateEntry());
				Collections.sort(Singletone.roomTwice, new OrderDateEntry());
				Collections.sort(Singletone.roomSuite, new OrderDateEntry());
				break;
			}
			case SUITE: {
				Collections.sort(Singletone.roomSingle, new OrderBeds());
				Collections.sort(Singletone.roomTwice, new OrderBeds());
				Collections.sort(Singletone.roomSuite, new OrderBeds());
				break;
			}
		}
	}

	public static void Order_User() {
		Collections.sort(Singletone_User.user, new OrderUsers());
	}

	protected final static int SINGLE = 0;
	protected final static int TWICE = 1;
	protected final static int SUITE = 2;
}
