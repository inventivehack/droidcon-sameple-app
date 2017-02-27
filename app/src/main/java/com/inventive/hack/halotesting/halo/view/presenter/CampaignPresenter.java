package com.inventive.hack.halotesting.halo.view.presenter;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.common.view.Presenter;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import com.inventive.hack.halotesting.halo.view.viewmvp.CampaignView;
import java.util.List;
import javax.inject.Inject;

/**
 * 26/02/2017.
 */

public class CampaignPresenter extends Presenter<CampaignView> {

  private UseCase<List<CampaignResponse>> mUseCase;

  @Inject
  public CampaignPresenter(UseCase<List<CampaignResponse>> useCase) {
    mUseCase = useCase;
  }

  @Override public void destroy() {

  }

  public void selectCampaign(CampaignViewModel viewModel) {

  }
}
