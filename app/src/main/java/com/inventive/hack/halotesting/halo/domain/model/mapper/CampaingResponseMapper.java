package com.inventive.hack.halotesting.halo.domain.model.mapper;

import com.inventive.hack.halotesting.common.domain.Mapper;
import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;

/**
 * 24/02/2017.
 */

public class CampaingResponseMapper extends Mapper<CampaignEntityResponse, CampaignResponse> {
  @Override public CampaignResponse map(CampaignEntityResponse value) {
    return new CampaignResponse(value.getMissionNumber(), value.getName(), value.getDescription(),
        value.getImageUrl(), value.getType());
  }
}
