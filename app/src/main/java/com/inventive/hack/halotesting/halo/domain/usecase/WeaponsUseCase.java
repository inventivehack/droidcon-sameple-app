package com.inventive.hack.halotesting.halo.domain.usecase;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 24/02/2017.
 */

public class WeaponsUseCase extends UseCase<List<WeaponResponse>> {

  private HaloRepository mHaloRepository;

  @Inject public WeaponsUseCase(@Named("executor_thread") Scheduler executorThread,
      @Named("ui_thread") Scheduler uiThread, HaloRepository haloRepository) {
    super(executorThread, uiThread);
    mHaloRepository = haloRepository;
  }

  @Override public Observable<List<WeaponResponse>> buildObservableUseCase() {
    return mHaloRepository.getWeapons();
  }
}
