package framework.modules.rooms.utils.funtions_CRUD;

import framework.modules.rooms.utils.Singletone;

public class getPrimaryKey {
	public static String[] getPrimaryKeyListRooms() {
		String[] primaryKeyList = null;
		switch (Singletone.roomType) {
			case SINGLE: {
				primaryKeyList = new String[Singletone.roomSingle.size()];
				for (int i = 0; i < Singletone.roomSingle.size(); i++) {
					primaryKeyList[i] = (Singletone.roomSingle.get(i).getNumRoom());
				}
				break;
			}
			case TWICE: {
				primaryKeyList = new String[Singletone.roomTwice.size()];
				for (int i = 0; i < Singletone.roomTwice.size(); i++) {
					primaryKeyList[i] = (Singletone.roomTwice.get(i).getNumRoom());
				}
				break;
			}
			case SUITE: {
				primaryKeyList = new String[Singletone.roomSuite.size()];
				for (int i = 0; i < Singletone.roomSuite.size(); i++) {
					primaryKeyList[i] = (Singletone.roomSuite.get(i).getNumRoom());
				}
				break;
			}
		}
		return primaryKeyList;

	}

	protected final static int SINGLE = 0;
	protected final static int TWICE = 1;
	protected final static int SUITE = 2;
}
