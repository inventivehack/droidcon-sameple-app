package com.inventive.hack.halotesting.halo.domain.usecase;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * 24/02/2017.
 */

public class WeaponsUseCase extends UseCase<List<WeaponResponse>> {

  private HaloRepository mHaloRepository;

  @Inject public WeaponsUseCase(HaloRepository haloRepository) {
    mHaloRepository = haloRepository;
  }

  @Override protected Observable<List<WeaponResponse>> buildObservableUseCase() {
    return null;
  }
}
