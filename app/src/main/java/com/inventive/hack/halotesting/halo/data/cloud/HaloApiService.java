package com.inventive.hack.halotesting.halo.data.cloud;

import com.inventive.hack.halotesting.common.data.cloud.ClientConstants;
import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.WeaponEntityResponse;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

public interface HaloApiService {

  @GET(ClientConstants.EndPointApi.CAMPAIGN) Observable<List<CampaignEntityResponse>> getCampaign();

  @GET(ClientConstants.EndPointApi.ENEMIES) Observable<List<EnemyEntityResponse>> getEnemies();

  @GET(ClientConstants.EndPointApi.WEAPONS) Observable<List<WeaponEntityResponse>> getWeapons();
}
