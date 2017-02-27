package com.inventive.hack.halotesting.halo.view.viewmodel;

import java.io.Serializable;

/**
 * 24/02/2017.
 */

public class WeaponViewModel implements Serializable{

  private String name;
  private String description;
  private String type;
  private String largeIconImageUrl;
  private String smallIconImageUrl;
  private boolean isUsableByPlayer;

  public WeaponViewModel(String name, String description, String type,
      String largeIconImageUrl, String smallIconImageUrl, boolean isUsableByPlayer) {
    this.name = name;
    this.description = description;
    this.type = type;
    this.largeIconImageUrl = largeIconImageUrl;
    this.smallIconImageUrl = smallIconImageUrl;
    this.isUsableByPlayer = isUsableByPlayer;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getType() {
    return type;
  }

  public String getLargeIconImageUrl() {
    return largeIconImageUrl;
  }

  public String getSmallIconImageUrl() {
    return smallIconImageUrl;
  }

  public boolean isUsableByPlayer() {
    return isUsableByPlayer;
  }

}
