package com.inventive.hack.halotesting.halo.data.repository.datasource;

import com.inventive.hack.halotesting.BuildConfig;
import com.inventive.hack.halotesting.halo.data.cloud.HaloRestApi;
import com.inventive.hack.halotesting.halo.data.cloud.HaloRestApiImpl;
import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.WeaponEntityResponse;
import io.reactivex.Observable;
import java.util.List;

/**
 * 24/02/2017.
 */

public class HaloCloudDataSource implements HaloDataSource {

  private static HaloRestApi restApi;

  public HaloCloudDataSource() {
    if (restApi == null) {
      restApi = new HaloRestApiImpl(BuildConfig.BASE_URL);
    }
  }

  @Override public Observable<List<CampaignEntityResponse>> getCampaign() {
    return restApi.getCampaign();
  }

  @Override public Observable<List<EnemyEntityResponse>> getEnemies() {
    return restApi.getEnemies();
  }

  @Override public Observable<List<WeaponEntityResponse>> getWeapons() {
    return restApi.getWeapons();
  }
}
