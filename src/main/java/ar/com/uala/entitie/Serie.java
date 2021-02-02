package ar.com.uala.entitie;

public class Serie extends Item {
  public Serie(String itemId, int duration, int releaseYear, int seasons){
    setItemId(itemId);
    setDuration(duration);
    setReleaseYear(releaseYear);
    this.setSeason(seasons);
  }
  private int season;
  @Override
  public boolean isIntersting() {
    if (season == 4 ||  season == 5) {
      return  true;
    }
    return false;
  }

  public int getSeason() {
    return season;
  }

  public void setSeason(int season) {
    this.season = season;
  }
}
