package com.inventive.hack.halotesting.injector.module;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.halo.data.repository.HaloDataRepository;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;
import com.inventive.hack.halotesting.halo.domain.usecase.CampaignUseCase;
import com.inventive.hack.halotesting.halo.domain.usecase.EnemiesUseCase;
import com.inventive.hack.halotesting.halo.domain.usecase.WeaponsUseCase;
import com.inventive.hack.halotesting.injector.Activity;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Named;

/**
 * 24/02/2017.
 */

@Module public class HaloModule {

  @Provides @Activity
  public HaloRepository provideHaloRepository(HaloDataRepository haloDataRepository) {
    return haloDataRepository;
  }

  @Provides @Activity
  public UseCase<List<CampaignResponse>> provideCampaignUserCase(CampaignUseCase campaignUseCase) {
    return campaignUseCase;
  }

  @Provides @Activity
  public UseCase<List<EnemyResponse>> provideEnemiesUserCase(EnemiesUseCase campaignUseCase) {
    return campaignUseCase;
  }

  @Provides @Activity
  public UseCase<List<WeaponResponse>> provideWeaponsUserCase(WeaponsUseCase campaignUseCase) {
    return campaignUseCase;
  }

  @Provides @Activity @Named("executor_thread") public Scheduler provideExecutorThread() {
    return Schedulers.newThread();
  }

  @Provides @Activity @Named("ui_thread") public Scheduler provideUiThread() {
    return AndroidSchedulers.mainThread();
  }
}
