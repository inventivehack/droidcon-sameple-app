package com.inventive.hack.halotesting.halo.view.viewmvp;

import com.inventive.hack.halotesting.common.view.Presenter;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import com.inventive.hack.halotesting.halo.view.viewmodel.EnemyViewModel;
import com.inventive.hack.halotesting.halo.view.viewmodel.WeaponViewModel;
import java.util.List;

/**
 * 26/02/2017.
 */

public interface WeaponsView extends Presenter.View {

  void showLoading();

  void hideLoading();

  void enableRefresh();

  void disableRefresh();

  void showRefresh();

  void hideRefresh();

  void showWeapons(List<WeaponViewModel> viewModels);

  void showDetailWeapon(WeaponViewModel cardViewModel);


  void showMessageNotResults();

  void hideMessageNotResults();

  void showMessageConnectionError();

  void hideMessageConnectionError();


}
