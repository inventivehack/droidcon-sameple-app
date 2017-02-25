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
import java.util.List;

/**
 * 24/02/2017.
 */

@Module public class HaloModule {

  @Provides @Activity UseCase<List<CampaignResponse>> provideCampaignUserCase(
      CampaignUseCase campaignUseCase) {
    return campaignUseCase;
  }


  @Provides @Activity UseCase<List<EnemyResponse>> provideEnemiesUserCase(EnemiesUseCase campaignUseCase) {
    return campaignUseCase;
  }

  @Provides @Activity UseCase<List<WeaponResponse>> provideWeaponsUserCase(
      WeaponsUseCase campaignUseCase) {
    return campaignUseCase;
  }


  @Provides @Activity HaloRepository provideHaloRepository(
      HaloDataRepository haloDataRepository) {
    return haloDataRepository;
  }




}
