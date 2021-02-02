package ar.com.uala.entitie;

import ar.com.uala.utils.CurrentYearUtils;

public abstract class Item {
  private String itemId;
  private int duration;
  private int releaseYear;
  public abstract boolean isIntersting();

  public boolean isOld() {
    int currentYear = CurrentYearUtils.INSTANCE.getCurrentYear();
    if ((currentYear - this.getReleaseYear()) > 2) {
      return true;
    }
    return false;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
}
