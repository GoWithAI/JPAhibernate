package test.practice.enumWithType;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
	MALE(0), FEMALE(1);

	private final int genderId;

	private static final Map<Integer, Gender> lookup = new HashMap<Integer, Gender>();

	static {
		for (Gender g : Gender.values()) {
			lookup.put(g.getGenderId(), g);
		}
	}

	Gender(int genderId) {
		this.genderId = genderId;
	}

	public int getGenderId() {
		return genderId;
	}

	public static Gender get(int genderId) {
		return lookup.get(genderId);
	}
}