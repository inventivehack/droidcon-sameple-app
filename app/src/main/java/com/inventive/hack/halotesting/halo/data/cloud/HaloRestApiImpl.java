package com.inventive.hack.halotesting.halo.data.cloud;

import com.inventive.hack.halotesting.common.data.cloud.ApiClient;
import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.WeaponEntityResponse;
import io.reactivex.Observable;
import java.util.List;

/**
 * 24/02/2017.
 */

public class HaloRestApiImpl extends ApiClient<HaloApiService> implements HaloRestApi {

  public HaloRestApiImpl(String url) {
    super(url);
  }

  @Override protected Class<HaloApiService> getApiService() {
    return HaloApiService.class;
  }

  @Override public Observable<List<CampaignEntityResponse>> getCampaign() {
    return apiService.getCampaign();
  }

  @Override public Observable<List<EnemyEntityResponse>> getEnemies() {
    return apiService.getEnemies();
  }

  @Override public Observable<List<WeaponEntityResponse>> getWeapons() {
    return apiService.getWeapons();
  }
}
