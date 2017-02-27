package com.inventive.hack.halotesting.halo.view.viewmvp;

import com.inventive.hack.halotesting.common.view.Presenter;

/**
 * 26/02/2017.
 */

public interface EnemiesView extends Presenter.View {

  void showMessageErrorResponseNetwork(String messageError, int typeError);

}
