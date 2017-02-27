package com.inventive.hack.halotesting.halo.view.presenter;

import com.inventive.hack.halotesting.common.view.Presenter;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import com.inventive.hack.halotesting.halo.view.viewmvp.CampaignDetailView;
import javax.inject.Inject;

/**
 * 27/02/2017.
 */

public class CampaignDetailPresenter extends Presenter<CampaignDetailView> {

  @Inject
  public CampaignDetailPresenter() {
  }

  public void setViewModel(CampaignViewModel viewModel) {
    getView().showImageCampaign(viewModel.getImageUrl());
    getView().showNameCampaign(viewModel.getName());
    getView().showDescriptionCampaign(viewModel.getDescription());

  }

  @Override public void destroy() {

  }

}
