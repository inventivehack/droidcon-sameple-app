package com.inventive.hack.halotesting.halo.view.viewmodel.mapper;

import com.inventive.hack.halotesting.common.domain.Mapper;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;
import com.inventive.hack.halotesting.halo.view.viewmodel.WeaponViewModel;

/**
 * 24/02/2017.
 */

public class WeaponViewModelMapper extends Mapper<WeaponResponse, WeaponViewModel> {
  @Override public WeaponViewModel map(WeaponResponse value) {
    return new WeaponViewModel(value.getName(), value.getDescription(), value.getType(),
        value.getLargeIconImageUrl(), value.getSmallIconImageUrl(), value.isUsableByPlayer());
  }
}