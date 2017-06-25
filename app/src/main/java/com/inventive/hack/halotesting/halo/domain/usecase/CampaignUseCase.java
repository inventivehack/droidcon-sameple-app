package com.inventive.hack.halotesting.halo.domain.usecase;

import android.util.Log;
import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 24/02/2017.
 */

public class CampaignUseCase extends UseCase<List<CampaignResponse>> {

  private HaloRepository mHaloRepository;

  @Inject public CampaignUseCase(@Named("executor_thread") Scheduler executorThread,
      @Named("ui_thread") Scheduler uiThread, HaloRepository haloRepository) {
    super(executorThread, uiThread);
    mHaloRepository = haloRepository;
  }

  @Override public Observable<List<CampaignResponse>> buildObservableUseCase() {
    return mHaloRepository.getCampaign();
  }
}
