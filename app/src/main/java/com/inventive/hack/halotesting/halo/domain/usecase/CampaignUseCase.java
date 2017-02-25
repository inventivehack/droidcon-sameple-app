package com.inventive.hack.halotesting.halo.domain.usecase;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * 24/02/2017.
 */

public class CampaignUseCase extends UseCase<List<CampaignResponse>> {

  private HaloRepository mHaloRepository;

  @Inject
  public CampaignUseCase(HaloRepository haloRepository) {
    mHaloRepository = haloRepository;
  }

  @Override protected Observable<List<CampaignResponse>> buildObservableUseCase() {
    return mHaloRepository.getCampaign();
  }
}
