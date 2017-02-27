package com.inventive.hack.halotesting.halo.view.presenter;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.common.view.Presenter;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import com.inventive.hack.halotesting.halo.view.viewmodel.mapper.CampaingViewModelMapper;
import com.inventive.hack.halotesting.halo.view.viewmvp.CampaignView;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import javax.inject.Inject;

/**
 * 26/02/2017.
 */

public class CampaignPresenter extends Presenter<CampaignView> {

  private UseCase<List<CampaignResponse>> mUseCase;
  private CampaingViewModelMapper mMapper;

  @Inject public CampaignPresenter(UseCase<List<CampaignResponse>> useCase) {
    mUseCase = useCase;
    mMapper = new CampaingViewModelMapper();
  }

  public void getCampaign() {
    getView().disableRefresh();
    getView().hideMessageConnectionError();
    getView().showLoading();
    mUseCase.execute(new GetCampaignDisposable());
  }

  public void refreshCampaign() {
    mUseCase.execute(new GetCampaignDisposable());
  }

  public void selectCampaign(CampaignViewModel viewModel) {
    getView().showDetailCampaign(viewModel);
  }

  @Override public void destroy() {
    mUseCase.dispose();
  }

  private class GetCampaignDisposable extends DisposableObserver<List<CampaignResponse>> {

    @Override public void onComplete() {
      getView().hideLoading();
      getView().enableRefresh();
      getView().hideRefresh();
    }

    @Override public void onNext(List<CampaignResponse> campaignResponses) {
      List<CampaignViewModel> viewModels = mMapper.map(campaignResponses);
      getView().showCampaign(viewModels);

      if (!viewModels.isEmpty()) {
        getView().hideMessageNotResults();
      } else {
        getView().showMessageNotResults();
      }
    }

    @Override public void onError(Throwable e) {
      getView().hideLoading();
      getView().hideRefresh();
      getView().showMessageConnectionError();
      e.printStackTrace();
    }
  }
}
