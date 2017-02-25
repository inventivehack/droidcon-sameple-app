package com.inventive.hack.halotesting.halo.domain.model;

/**
 * 24/02/2017.
 */

public class CampaignResponse {

  private String missionNumber;
  private String name;
  private String description;
  private String imageUrl;
  private String type;

  public CampaignResponse(String missionNumber, String name, String description, String imageUrl,
      String type) {
    this.missionNumber = missionNumber;
    this.name = name;
    this.description = description;
    this.imageUrl = imageUrl;
    this.type = type;
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

}
