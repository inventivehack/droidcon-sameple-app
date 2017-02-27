package com.inventive.hack.halotesting.halo.view.presenter;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.common.view.Presenter;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import com.inventive.hack.halotesting.halo.view.viewmodel.EnemyViewModel;
import com.inventive.hack.halotesting.halo.view.viewmodel.mapper.CampaingViewModelMapper;
import com.inventive.hack.halotesting.halo.view.viewmodel.mapper.EnemyViewModelMapper;
import com.inventive.hack.halotesting.halo.view.viewmvp.EnemiesView;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import javax.inject.Inject;

/**
 * 26/02/2017.
 */

public class EnemiesPresenter extends Presenter<EnemiesView> {

  private UseCase<List<EnemyResponse>> mUseCase;
  private EnemyViewModelMapper mMapper;


  @Inject public EnemiesPresenter(UseCase<List<EnemyResponse>> useCase) {
    mUseCase = useCase;
    mMapper = new EnemyViewModelMapper();
  }

  public void getEnemies() {
    getView().disableRefresh();
    getView().hideMessageConnectionError();
    getView().showLoading();
    mUseCase.execute(new GetEnemiesDisposable());
  }

  public void refreshEnemies() {
    mUseCase.execute(new GetEnemiesDisposable());
  }

  public void selectEnemy(EnemyViewModel viewModel) {
    getView().showDetailEnemy(viewModel);
  }

  @Override public void destroy() {
    mUseCase.dispose();

  }

  private class GetEnemiesDisposable extends DisposableObserver<List<EnemyResponse>> {
    @Override public void onComplete() {
      getView().hideLoading();
      getView().enableRefresh();
      getView().hideRefresh();
    }

    @Override public void onNext(List<EnemyResponse> enemyResponses) {
      List<EnemyViewModel> viewModels = mMapper.map(enemyResponses);
      getView().showEnemies(viewModels);

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
