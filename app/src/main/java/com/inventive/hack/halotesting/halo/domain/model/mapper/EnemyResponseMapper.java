package com.inventive.hack.halotesting.halo.domain.model.mapper;

import com.inventive.hack.halotesting.common.domain.Mapper;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;

/**
 * 24/02/2017.
 */

public class EnemyResponseMapper extends Mapper<EnemyEntityResponse, EnemyResponse> {
  @Override public EnemyResponse map(EnemyEntityResponse value) {
    return new EnemyResponse(value.getFaction(), value.getName(), value.getDescription(),
        value.getLargeIconImageUrl(), value.getSmallIconImageUrl());
  }
}
