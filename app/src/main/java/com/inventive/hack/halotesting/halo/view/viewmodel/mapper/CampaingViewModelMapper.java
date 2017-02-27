package com.inventive.hack.halotesting.halo.view.viewmodel.mapper;

import com.inventive.hack.halotesting.common.domain.Mapper;
import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;

/**
 * 24/02/2017.
 */

public class CampaingViewModelMapper extends Mapper<CampaignResponse, CampaignViewModel> {
  @Override public CampaignViewModel map(CampaignResponse value) {
    return new CampaignViewModel(value.getMissionNumber(), value.getName(), value.getDescription(),
        value.getImageUrl(), value.getType());
  }
}
