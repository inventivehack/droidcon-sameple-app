package com.inventive.hack.halotesting.domain;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import com.inventive.hack.halotesting.halo.domain.usecase.CampaignUseCase;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.only;

/**
 * 27/02/2017.
 */

@RunWith(MockitoJUnitRunner.class) public class CampaignUseCaseTest {

  @Mock private HaloRepository mRepository;

  private UseCase<List<CampaignResponse>> mCampaignResponseUseCase;

  @Before public void setup() {
    MockitoAnnotations.initMocks(this);
    mCampaignResponseUseCase =
        new CampaignUseCase(Schedulers.trampoline(), Schedulers.trampoline(), mRepository);
  }

  @Test public void shouldCallRepositoryTest() {

    Mockito.when(mRepository.getCampaign()).thenReturn(getFakeObservableCampaignList());
    mCampaignResponseUseCase.execute(new TestDisposableObserver());

    Mockito.verify(mRepository, only()).getCampaign();
  }

  private Observable<List<CampaignResponse>> getFakeObservableCampaignList() {
    List<CampaignResponse> testList = new ArrayList<>();
    return Observable.just(testList);
  }

  private class TestDisposableObserver extends DisposableObserver<List<CampaignResponse>> {
    @Override public void onNext(List<CampaignResponse> campaignResponses) {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onComplete() {

    }
  }
}
