package ar.com.uala;

import ar.com.uala.entitie.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UalaExamTest {

  @Test
  public void testOldProduct() {
    Item film = new Film("the great gatsby", 142, 2012, 0);
    assertEquals(true, film.isOld());

    Item documentary = new Documentary("High Score", 46, 2020);
    assertEquals(false, documentary.isOld());
  }

  @Test
  public void testInterestingProduct() {
    Item film = new Film("Gladiator", 190, 2000, 1);
    assertEquals(true, film.isIntersting());

    Item serie = new Serie("Stranger Things", 45, 2017, 4);
    assertEquals(true, serie.isIntersting());

    Item documentary = new Documentary("Balckhat - unofficial", 90, 2015);
    assertEquals(true, documentary.isIntersting());
  }

  @Test
  public void testUserTags() {
    User nicolas = new User("nicolas123", Mood.HAPPY) ;
    Item film = new Film("Gladiator", 190, 2000, 1);
    Item documentary = new Documentary("High Score", 46, 2020);

    nicolas.watchItem(film);
    nicolas.setTags();
    assertEquals(2,nicolas.getTags().size());

    nicolas.watchItem(documentary);
    nicolas.setTags();
    assertEquals(1,nicolas.getTags().size());

  }

  @Test
  public void testRecomendation(){
    Item film = new Film("the great gatsby", 142, 2012, 0);
    Item documentary = new Documentary("High Score", 46, 2020);
    Item film2 = new Film("Gladiator", 190, 2000, 1);
    Item serie = new Serie("Stranger Things", 45, 2017, 4);
    List<Item> allItems  = new ArrayList<>();
    allItems.add(film);
    allItems.add(documentary);
    allItems.add(film2);
    allItems.add(serie);
    User nicolas = new User("nicolas123", Mood.HAPPY) ;

    List<Item> recomendedItemsHappy = nicolas.requestRecomendation(allItems);
    assertEquals(4,recomendedItemsHappy.size());

    nicolas.setMood(Mood.MELANCHOLIC);
    List<Item> recomendedItemsMelancholic = nicolas.requestRecomendation(allItems);
    assertEquals(1,recomendedItemsMelancholic.size());

    nicolas.setMood(Mood.SAD);
    List<Item> recomendedItemsSad = nicolas.requestRecomendation(allItems);
    assertEquals(2,recomendedItemsSad.size());

  }
}
