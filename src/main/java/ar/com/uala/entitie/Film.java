package ar.com.uala.entitie;

public class Film extends Item {
  public Film(String itemId, int duration, int releaseYear, int oscarQty) {
    setItemId(itemId);
    setDuration(duration);
    setReleaseYear(releaseYear);
    this.setOscarQty(oscarQty);
  }

  private int oscarQty;

  public int getOscarQty() {
    return oscarQty;
  }

  public void setOscarQty(int oscarQty) {
    this.oscarQty = oscarQty;
  }

  @Override
  public boolean isIntersting() {
    if (oscarQty > 0) {
      return true;
    }
    return false;
  }
}
