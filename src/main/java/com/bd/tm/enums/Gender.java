package com.bd.tm.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Gender {

  MALE(0), FEMALE(1);

  private final Integer value;

  private static final Map<Integer, Gender> lookup = new HashMap<Integer, Gender>();

  static {
    for (Gender gender : EnumSet.allOf(Gender.class))
      lookup.put(gender.getValue(), gender);
  }

  private Gender(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }

  public static Gender findByValue(Integer value) {
    Gender gender = lookup.get(value);
    if (gender == null) {
      throw new IllegalArgumentException("Invalid gender type");
    }
    return gender;
  }
  
}
