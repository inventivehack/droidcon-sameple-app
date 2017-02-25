package com.inventive.hack.halotesting.halo.domain.usecase;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * 24/02/2017.
 */

public class EnemiesUseCase extends UseCase<List<EnemyResponse>> {

  private HaloRepository mHaloRepository;

  @Inject
  public EnemiesUseCase(HaloRepository haloRepository) {
    mHaloRepository = haloRepository;
  }

  @Override protected Observable<List<EnemyResponse>> buildObservableUseCase() {
    return mHaloRepository.getEnemies();
  }
}
