package com.inventive.hack.halotesting.halo.view.viewmvp;

import com.inventive.hack.halotesting.common.view.Presenter;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import java.util.List;

/**
 * 26/02/2017.
 */

public interface CampaignView extends Presenter.View {

  void showLoading();

  void hideLoading();

  void enableRefresh();

  void disableRefresh();

  void showRefresh();

  void hideRefresh();

  void showCampaign(List<CampaignViewModel> viewModels);

  void showDetailCampaign(CampaignViewModel cardViewModel);


  void showMessageNotResults();

  void hideMessageNotResults();

  void showMessageConnectionError();

  void hideMessageConnectionError();



}
