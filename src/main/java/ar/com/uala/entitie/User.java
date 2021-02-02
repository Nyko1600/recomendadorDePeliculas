package ar.com.uala.entitie;

import ar.com.uala.utils.CurrentYearUtils;

import java.util.*;
import java.util.stream.Collectors;

public class User {
  public User(String userId, Mood mood) {
    this.userId = userId;
    this.mood = mood;
  }

  private String userId;
  private Mood mood;
  private Double balance = 100.00;
  private List<Item> itemsConsumed = new ArrayList<>();
  private List<String> tags = new ArrayList<>();
  private static String oldUser = "Es un cliente antiguo";
  private static String interestingItems = "Mira productos interesantes";


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Mood getMood() {
    return mood;
  }

  public void setMood(Mood mood) {
    this.mood = mood;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public List<Item> getItemsConsumed() {
    return itemsConsumed;
  }

  public void watchItem(Item item) {
    this.itemsConsumed.add(item);
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags() {
    if (itemsConsumed.isEmpty()) {
      return;
    }
    tags.clear();
    boolean oldItemOnlly = true;
    int qtyInteretingsItems = 0;
    for (Item item : itemsConsumed) {
      if (!item.isOld()) {
        oldItemOnlly = false;
      }
      if (item.isIntersting()) {
        qtyInteretingsItems++;
      }
    }
    if (oldItemOnlly) {
      tags.add(oldUser);
    }
    if (qtyInteretingsItems > 0) {
      tags.add(interestingItems);
    }
  }

  public List<Item> requestRecomendation(List<Item> availableItems) {
    List<Item> recomendedItems  = new ArrayList<>();
    switch (this.mood) {
      case SAD:
        recomendedItems = availableItems.stream().filter(
            item -> item.getDuration() > 120
        ).collect(Collectors.toList());
        return recomendedItems;
      case MELANCHOLIC:
        int currentYear = CurrentYearUtils.INSTANCE.getCurrentYear();
        recomendedItems = availableItems.stream().filter(
            item -> currentYear -item.getReleaseYear() > 10
        ).collect(Collectors.toList());

        return recomendedItems;
      case HAPPY:
        return availableItems;
    }
    return recomendedItems;
  }
}
