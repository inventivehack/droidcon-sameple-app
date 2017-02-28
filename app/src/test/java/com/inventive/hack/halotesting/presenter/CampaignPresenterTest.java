package com.inventive.hack.halotesting.presenter;

import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import com.inventive.hack.halotesting.halo.domain.usecase.CampaignUseCase;
import com.inventive.hack.halotesting.halo.view.presenter.CampaignPresenter;
import com.inventive.hack.halotesting.halo.view.viewmvp.CampaignView;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * 27/02/2017.
 */
public class CampaignPresenterTest {

  private CampaignPresenter mPresenter;

  @Mock private HaloRepository mRepositoryMock;
  @Mock private CampaignView mView;

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
    mPresenter = new CampaignPresenter(
        new CampaignUseCase(Schedulers.trampoline(), Schedulers.trampoline(), mRepositoryMock));
    mPresenter.setView(mView);
  }

  @Test public void shouldShowCampaignEmptyDataTest() {
    Mockito.when(mRepositoryMock.getCampaign()).thenReturn(getFakeObservableCampaignEmptyList());
    mPresenter.getCampaign();

    Mockito.verify(mView).disableRefresh();
    Mockito.verify(mView).hideMessageConnectionError();
    Mockito.verify(mView).showLoading();

    Mockito.verify(mView).hideLoading();
    Mockito.verify(mView).enableRefresh();
    Mockito.verify(mView).hideRefresh();

    Mockito.verify(mView).showCampaign(Mockito.anyList());
    Mockito.verify(mView).showMessageNotResults();
  }

  private Observable<List<CampaignResponse>> getFakeObservableCampaignEmptyList() {
    List<CampaignResponse> testList = new ArrayList<>();
    return Observable.just(testList);
  }

  @Test public void shouldShowCampaignDataTest() {
    Mockito.when(mRepositoryMock.getCampaign()).thenReturn(getFakeObservableCampaignList());
    mPresenter.getCampaign();

    Mockito.verify(mView).disableRefresh();
    Mockito.verify(mView).hideMessageConnectionError();
    Mockito.verify(mView).showLoading();

    Mockito.verify(mView).hideLoading();
    Mockito.verify(mView).enableRefresh();
    Mockito.verify(mView).hideRefresh();

    Mockito.verify(mView).showCampaign(Mockito.anyList());
    Mockito.verify(mView).hideMessageNotResults();
  }

  private Observable<List<CampaignResponse>> getFakeObservableCampaignList() {
    List<CampaignResponse> testList = new ArrayList<>();
    testList.add(new CampaignResponse("", "", "", "", ""));
    return Observable.just(testList);
  }

  @Test public void shouldShowErrorDataTest() {
    Mockito.when(mRepositoryMock.getCampaign()).thenReturn(getErrorObservableCampaignList());
    mPresenter.getCampaign();

    Mockito.verify(mView).disableRefresh();
    Mockito.verify(mView).hideMessageConnectionError();
    Mockito.verify(mView).showLoading();

    Mockito.verify(mView).hideLoading();
    Mockito.verify(mView).hideRefresh();
    Mockito.verify(mView).showMessageConnectionError();
  }

  private Observable<List<CampaignResponse>> getErrorObservableCampaignList() {
    return Observable.error(new Throwable("fake error"));
  }
}
