package com.inventive.hack.halotesting.halo.domain.usecase;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 24/02/2017.
 */

public class EnemiesUseCase extends UseCase<List<EnemyResponse>> {

  private HaloRepository mHaloRepository;

  @Inject
  public EnemiesUseCase(@Named("executor_thread") Scheduler executorThread,
      @Named("ui_thread") Scheduler uiThread, HaloRepository haloRepository) {
    super(executorThread, uiThread);
    mHaloRepository = haloRepository;
  }

  @Inject

  @Override public Observable<List<EnemyResponse>> buildObservableUseCase() {
    return mHaloRepository.getEnemies();
  }
}
