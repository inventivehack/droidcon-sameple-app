package com.inventive.hack.halotesting.halo.data.cloud;

import com.inventive.hack.halotesting.common.data.cloud.ApiClient;
import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.WeaponsEntityResponse;
import io.reactivex.Observable;

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

  @Override public Observable<CampaignEntityResponse> getCampaign() {
    return apiService.getCampaign();
  }

  @Override public Observable<EnemyEntityResponse> getEnemies() {
    return apiService.getEnemies();
  }

  @Override public Observable<WeaponsEntityResponse> getWeapons() {
    return apiService.getWeapons();
  }

}
