package com.inventive.hack.halotesting.halo.view.presenter;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.common.view.Presenter;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;
import com.inventive.hack.halotesting.halo.view.viewmodel.WeaponViewModel;
import com.inventive.hack.halotesting.halo.view.viewmvp.WeaponsView;
import java.util.List;
import javax.inject.Inject;

/**
 * 26/02/2017.
 */

public class WeaponsPresenter extends Presenter<WeaponsView> {

  private UseCase<List<WeaponResponse>> mUseCase;

  @Inject public WeaponsPresenter(UseCase<List<WeaponResponse>> useCase) {
    mUseCase = useCase;
  }

  @Override public void destroy() {

  }

  public void selectWeapon(WeaponViewModel viewModel) {


  }
}
