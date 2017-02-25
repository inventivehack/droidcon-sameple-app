package com.inventive.hack.halotesting.halo.data.repository;

import com.inventive.hack.halotesting.halo.data.repository.datasource.HaloDataSource;
import com.inventive.hack.halotesting.halo.data.repository.datasource.HaloDataSourceFactory;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;
import com.inventive.hack.halotesting.halo.domain.model.mapper.CampaingResponseMapper;
import com.inventive.hack.halotesting.halo.domain.model.mapper.EnemyResponseMapper;
import com.inventive.hack.halotesting.halo.domain.model.mapper.WeaponResponseMapper;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * 24/02/2017.
 */

public class HaloDataRespository implements HaloRepository {
  private final HaloDataSourceFactory mSourceFactory;
  private final CampaingResponseMapper mCampaingResponseMapper;
  private final EnemyResponseMapper mEnemyResponseMapper;
  private final WeaponResponseMapper mWeaponResponseMapper;

  @Inject public HaloDataRespository() {
    mSourceFactory = new HaloDataSourceFactory();
    mCampaingResponseMapper = new CampaingResponseMapper();
    mEnemyResponseMapper = new EnemyResponseMapper();
    mWeaponResponseMapper = new WeaponResponseMapper();
  }

  @Override public Observable<List<CampaignResponse>> getCampaign() {
    final HaloDataSource haloDataSource = mSourceFactory.createCloudDataSource();
    return haloDataSource.getCampaign().map(mCampaingResponseMapper::map);
  }

  @Override public Observable<List<EnemyResponse>> getEnemies() {
    final HaloDataSource haloDataSource = mSourceFactory.createCloudDataSource();
    return haloDataSource.getEnemies().map(mEnemyResponseMapper::map);
  }

  @Override public Observable<List<WeaponResponse>> getWeapons() {
    final HaloDataSource haloDataSource = mSourceFactory.createCloudDataSource();
    return haloDataSource.getWeapons().map(mWeaponResponseMapper::map);
  }
}
