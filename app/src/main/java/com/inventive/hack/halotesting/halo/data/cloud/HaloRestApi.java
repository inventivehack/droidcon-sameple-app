package com.inventive.hack.halotesting.halo.data.cloud;

import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.WeaponEntityResponse;
import io.reactivex.Observable;
import java.util.List;

/**
 * 24/02/2017.
 */

public interface HaloRestApi {

  Observable<List<CampaignEntityResponse>> getCampaign();

  Observable<List<EnemyEntityResponse>> getEnemies();

  Observable<List<WeaponEntityResponse>> getWeapons();
}
