package com.inventive.hack.halotesting.halo.domain.model.mapper;

import com.inventive.hack.halotesting.common.domain.Mapper;
import com.inventive.hack.halotesting.halo.data.entity.WeaponEntityResponse;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;

/**
 * 24/02/2017.
 */

public class WeaponResponseMapper extends Mapper<WeaponEntityResponse, WeaponResponse> {
  @Override public WeaponResponse map(WeaponEntityResponse value) {
    return new WeaponResponse(value.getName(), value.getDescription(), value.getType(),
        value.getLargeIconImageUrl(), value.getSmallIconImageUrl(), value.isUsableByPlayer());
  }
}