package com.inventive.hack.halotesting.halo.data.repository;

import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.WeaponEntityResponse;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;
import io.reactivex.Observable;
import java.util.List;

/**
 * 24/02/2017.
 */

public interface HaloRepository {

  Observable<List<CampaignResponse>> getCampaign();

  Observable<List<EnemyResponse>> getEnemies();

  Observable<List<WeaponResponse>> getWeapons();
}
