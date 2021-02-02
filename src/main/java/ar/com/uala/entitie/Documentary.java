package ar.com.uala.entitie;

public class Documentary extends Item {
  public Documentary(String itemId, int duration, int releaseYear){
    setItemId(itemId);
    setDuration(duration);
    setReleaseYear(releaseYear);
    this.setInteresting(itemId.toLowerCase().contains(keyword));
  }
  private static String keyword = "unofficial";

  private boolean isInteresting;

  @Override
  public boolean isIntersting() {
    return isInteresting;
  }

  public boolean isInteresting() {
    return isInteresting;
  }

  public void setInteresting(boolean interesting) {
    isInteresting = interesting;
  }
}
