package com.inventive.hack.halotesting.halo.view.viewmodel.mapper;

import com.inventive.hack.halotesting.common.domain.Mapper;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;
import com.inventive.hack.halotesting.halo.view.viewmodel.EnemyViewModel;

/**
 * 24/02/2017.
 */

public class EnemyViewModelMapper extends Mapper<EnemyResponse, EnemyViewModel> {
  @Override public EnemyViewModel map(EnemyResponse value) {
    return new EnemyViewModel(value.getFaction(), value.getName(), value.getDescription(),
        value.getLargeIconImageUrl(), value.getSmallIconImageUrl());
  }
}
