package com.inventive.hack.halotesting.halo.view.viewmvp;

import com.inventive.hack.halotesting.common.view.Presenter;

/**
 * 27/02/2017.
 */

public interface CampaignDetailView extends Presenter.View {
  void showImageCampaign(String imageUrl);

  void showNameCampaign(String name);

  void showDescriptionCampaign(String description);
}
