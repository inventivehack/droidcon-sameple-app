package com.inventive.hack.halotesting.halo.data.entity;

/**
 * 24/02/2017.
 */

public class CampaignEntityResponse {

  private String missionNumber;
  private String name;
  private String description;
  private String imageUrl;
  private String type;
  private String id;
  private String contentId;

  public CampaignEntityResponse(String missionNumber, String name, String description,
      String imageUrl, String type, String id, String contentId) {
    this.missionNumber = missionNumber;
    this.name = name;
    this.description = description;
    this.imageUrl = imageUrl;
    this.type = type;
    this.id = id;
    this.contentId = contentId;
  }

  public String getMissionNumber() {
    return missionNumber;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public String getType() {
    return type;
  }

  public String getId() {
    return id;
  }

  public String getContentId() {
    return contentId;
  }
}
