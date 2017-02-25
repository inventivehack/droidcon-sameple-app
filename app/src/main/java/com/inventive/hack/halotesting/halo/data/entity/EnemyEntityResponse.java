package com.inventive.hack.halotesting.halo.data.entity;

/**
 * 24/02/2017.
 */

public class EnemyEntityResponse {

  private String faction;
  private String name;
  private String description;
  private String largeIconImageUrl;
  private String smallIconImageUrl;
  private String id;
  private String contentId;

  public EnemyEntityResponse(String faction, String name, String description,
      String largeIconImageUrl, String smallIconImageUrl, String id, String contentId) {
    this.faction = faction;
    this.name = name;
    this.description = description;
    this.largeIconImageUrl = largeIconImageUrl;
    this.smallIconImageUrl = smallIconImageUrl;
    this.id = id;
    this.contentId = contentId;
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

  public String getId() {
    return id;
  }

  public String getContentId() {
    return contentId;
  }
}
