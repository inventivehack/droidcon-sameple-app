package com.inventive.hack.halotesting.halo.view.presenter;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.common.view.Presenter;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;
import com.inventive.hack.halotesting.halo.view.viewmvp.CampaignView;
import com.inventive.hack.halotesting.halo.view.viewmvp.EnemiesView;
import java.util.List;
import javax.inject.Inject;

/**
 * 26/02/2017.
 */

public class EnemiesPresenter extends Presenter<EnemiesView> {

  private UseCase<List<EnemyResponse>> mUseCase;

  @Inject
  public EnemiesPresenter(UseCase<List<EnemyResponse>> useCase) {
    mUseCase = useCase;
  }

  @Override public void destroy() {

  }
}
