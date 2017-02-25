package com.inventive.hack.halotesting.halo.data.repository.datasource;

import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.WeaponsEntityResponse;
import io.reactivex.Observable;

/**
 * 24/02/2017.
 */

public interface HaloDataSource {

  Observable<CampaignEntityResponse> getCampaign();

  Observable<EnemyEntityResponse> getEnemies();

  Observable<WeaponsEntityResponse> getWeapons();
}
