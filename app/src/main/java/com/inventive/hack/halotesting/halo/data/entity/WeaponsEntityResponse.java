package com.inventive.hack.halotesting.halo.data.entity;

/**
 * 24/02/2017.
 */

public class WeaponsEntityResponse {

  private String name;
  private String description;
  private String type;
  private String largeIconImageUrl;
  private String smallIconImageUrl;
  private boolean isUsableByPlayer;
  private String id;
  private String contentId;

  public WeaponsEntityResponse(String name, String description, String type,
      String largeIconImageUrl, String smallIconImageUrl, boolean isUsableByPlayer, String id,
      String contentId) {
    this.name = name;
    this.description = description;
    this.type = type;
    this.largeIconImageUrl = largeIconImageUrl;
    this.smallIconImageUrl = smallIconImageUrl;
    this.isUsableByPlayer = isUsableByPlayer;
    this.id = id;
    this.contentId = contentId;
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

  public String getId() {
    return id;
  }

  public String getContentId() {
    return contentId;
  }
}
