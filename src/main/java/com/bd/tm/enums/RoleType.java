package com.bd.tm.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum RoleType {

  GUARDIAN(1), TEACHER(2);

  private static final Map<Integer, RoleType> lookup = new HashMap<Integer, RoleType>();

  static {
    for (RoleType roleType : EnumSet.allOf(RoleType.class))
      lookup.put(roleType.getValue(), roleType);
  }

  private Integer value;

  private RoleType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public static RoleType findByValue(Integer value) {
    return Optional.ofNullable(lookup.get(value))
        .orElseThrow(() -> new IllegalArgumentException("Invalid role type"));
  }

}
