package com.bd.tm.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum TeacherStatus {
  
  AVAILABLE(1), UNAVAILABLE(0);

  private static final Map<Integer, TeacherStatus> lookup = new HashMap<Integer, TeacherStatus>();

  static {
    for (TeacherStatus teacherStatus : EnumSet.allOf(TeacherStatus.class)){
      lookup.put(teacherStatus.getValue(), teacherStatus);
    }
  }

  private final Integer value;

  private TeacherStatus(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
  
  public static TeacherStatus findByValue(Integer value) {
    return Optional.ofNullable(lookup.get(value))
        .orElseThrow(() -> new IllegalArgumentException("Invalid driver status"));
  }

}
