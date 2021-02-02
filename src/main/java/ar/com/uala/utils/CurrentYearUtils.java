package ar.com.uala.utils;

import org.joda.time.DateTime;

public enum CurrentYearUtils {
  INSTANCE;
  public int getCurrentYear() {
    DateTime dt = new DateTime();
    return dt.getYear();
  }
}
