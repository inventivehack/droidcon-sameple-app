package com.inventive.hack.halotesting.halo.domain.model;

/**
 * 24/02/2017.
 */

public class EnemyResponse {

  private String faction;
  private String name;
  private String description;
  private String largeIconImageUrl;
  private String smallIconImageUrl;

  public EnemyResponse(String faction, String name, String description,
      String largeIconImageUrl, String smallIconImageUrl) {
    this.faction = faction;
    this.name = name;
    this.description = description;
    this.largeIconImageUrl = largeIconImageUrl;
    this.smallIconImageUrl = smallIconImageUrl;
  }

  public String getFaction() {
    return faction;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getLargeIconImageUrl() {
    return largeIconImageUrl;
  }

  public String getSmallIconImageUrl() {
    return smallIconImageUrl;
  }

}
