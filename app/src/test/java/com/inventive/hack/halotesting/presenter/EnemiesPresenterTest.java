package com.inventive.hack.halotesting.presenter;

import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;
import com.inventive.hack.halotesting.halo.domain.usecase.EnemiesUseCase;
import com.inventive.hack.halotesting.halo.view.presenter.EnemiesPresenter;
import com.inventive.hack.halotesting.halo.view.viewmvp.EnemiesView;
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
public class EnemiesPresenterTest {

  private EnemiesPresenter mPresenter;

  @Mock private HaloRepository mRepositoryMock;
  @Mock private EnemiesView mView;

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
    mPresenter = new EnemiesPresenter(
        new EnemiesUseCase(Schedulers.trampoline(), Schedulers.trampoline(), mRepositoryMock));
    mPresenter.setView(mView);
  }

  @Test public void shouldShowCampaignEmptyDataTest() {
    Mockito.when(mRepositoryMock.getEnemies()).thenReturn(getFakeObservableCampaignEmptyList());
    mPresenter.getEnemies();

    Mockito.verify(mView).disableRefresh();
    Mockito.verify(mView).hideMessageConnectionError();
    Mockito.verify(mView).showLoading();

    Mockito.verify(mView).hideLoading();
    Mockito.verify(mView).enableRefresh();
    Mockito.verify(mView).hideRefresh();

    Mockito.verify(mView).showEnemies(Mockito.anyList());
    Mockito.verify(mView).showMessageNotResults();
  }

  private Observable<List<EnemyResponse>> getFakeObservableCampaignEmptyList() {
    List<EnemyResponse> testList = new ArrayList<>();
    return Observable.just(testList);
  }

  @Test public void shouldShowCampaignDataTest() {
    Mockito.when(mRepositoryMock.getEnemies()).thenReturn(getFakeObservableEnemiesList());
    mPresenter.getEnemies();

    Mockito.verify(mView).disableRefresh();
    Mockito.verify(mView).hideMessageConnectionError();
    Mockito.verify(mView).showLoading();

    Mockito.verify(mView).hideLoading();
    Mockito.verify(mView).enableRefresh();
    Mockito.verify(mView).hideRefresh();

    Mockito.verify(mView).showEnemies(Mockito.anyList());
    Mockito.verify(mView).hideMessageNotResults();
  }

  private Observable<List<EnemyResponse>> getFakeObservableEnemiesList() {
    List<EnemyResponse> testList = new ArrayList<>();
    testList.add(new EnemyResponse("", "", "", "", ""));
    return Observable.just(testList);
  }

  @Test public void shouldShowErrorDataTest() {
    Mockito.when(mRepositoryMock.getEnemies()).thenReturn(getErrorObservableEnemiesList());
    mPresenter.getEnemies();

    Mockito.verify(mView).disableRefresh();
    Mockito.verify(mView).hideMessageConnectionError();
    Mockito.verify(mView).showLoading();

    Mockito.verify(mView).hideLoading();
    Mockito.verify(mView).hideRefresh();
    Mockito.verify(mView).showMessageConnectionError();
  }

  private Observable<List<EnemyResponse>> getErrorObservableEnemiesList() {
    return Observable.error(new Throwable("fake error"));
  }
}
