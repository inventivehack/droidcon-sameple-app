package com.inventive.hack.halotesting.halo.domain.model;

/**
 * 24/02/2017.
 */

public class WeaponResponse {

  private String name;
  private String description;
  private String type;
  private String largeIconImageUrl;
  private String smallIconImageUrl;
  private boolean isUsableByPlayer;

  public WeaponResponse(String name, String description, String type,
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
