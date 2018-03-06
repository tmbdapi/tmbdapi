package com.bd.tm.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Medium {

	BANGLA(1), ENGLISH(2), BANGLA_AND_ENGLISH(3);

	private final Integer value;

	private static final Map<Integer, Medium> lookup = new HashMap<Integer, Medium>();

	static {
		for (Medium medium : EnumSet.allOf(Medium.class))
			lookup.put(medium.getValue(), medium);
	}

	private Medium(Integer value) {
	    this.value = value;
	  }

	public Integer getValue() {
		return this.value;
	}

	public static Medium findByValue(Integer value) {
		Medium medium = lookup.get(value);
		if (medium == null) {
			throw new IllegalArgumentException("Invalid medium type");
		}
		return medium;
	}

}