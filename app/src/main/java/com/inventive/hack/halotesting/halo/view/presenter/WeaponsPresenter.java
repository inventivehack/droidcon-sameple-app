package com.inventive.hack.halotesting.halo.view.presenter;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.common.view.Presenter;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;
import com.inventive.hack.halotesting.halo.view.viewmodel.WeaponViewModel;
import com.inventive.hack.halotesting.halo.view.viewmodel.mapper.WeaponViewModelMapper;
import com.inventive.hack.halotesting.halo.view.viewmvp.WeaponsView;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import javax.inject.Inject;

/**
 * 26/02/2017.
 */

public class WeaponsPresenter extends Presenter<WeaponsView> {

  private UseCase<List<WeaponResponse>> mUseCase;
  private WeaponViewModelMapper mMapper;

  @Inject public WeaponsPresenter(UseCase<List<WeaponResponse>> useCase) {
    mUseCase = useCase;
    mMapper = new WeaponViewModelMapper();
  }

  public void getWeapons() {
    getView().disableRefresh();
    getView().hideMessageConnectionError();
    getView().showLoading();
    mUseCase.execute(new GetWeaponsDisposable());
  }

  public void refreshWeapons() {
    mUseCase.execute(new GetWeaponsDisposable());
  }

  @Override public void destroy() {
    mUseCase.dispose();
  }

  public void selectWeapon(WeaponViewModel viewModel) {
    getView().showDetailWeapon(viewModel);
  }

  private class GetWeaponsDisposable extends DisposableObserver<List<WeaponResponse>> {

    @Override public void onComplete() {
      getView().hideLoading();
      getView().enableRefresh();
      getView().hideRefresh();
    }

    @Override public void onNext(List<WeaponResponse> weaponResponses) {
      List<WeaponViewModel> viewModels = mMapper.map(weaponResponses);
      getView().showWeapons(viewModels);

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
