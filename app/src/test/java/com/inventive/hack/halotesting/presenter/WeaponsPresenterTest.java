package com.inventive.hack.halotesting.presenter;

import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;
import com.inventive.hack.halotesting.halo.domain.usecase.WeaponsUseCase;
import com.inventive.hack.halotesting.halo.view.presenter.WeaponsPresenter;
import com.inventive.hack.halotesting.halo.view.viewmvp.WeaponsView;
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
public class WeaponsPresenterTest {

  private WeaponsPresenter mPresenter;

  @Mock private HaloRepository mRepositoryMock;
  @Mock private WeaponsView mView;

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
    mPresenter = new WeaponsPresenter(
        new WeaponsUseCase(Schedulers.trampoline(), Schedulers.trampoline(), mRepositoryMock));
    mPresenter.setView(mView);
  }

  @Test public void shouldShowCampaignEmptyDataTest() {
    Mockito.when(mRepositoryMock.getWeapons()).thenReturn(getFakeObservableWeaponsEmptyList());
    mPresenter.getWeapons();

    Mockito.verify(mView).disableRefresh();
    Mockito.verify(mView).hideMessageConnectionError();
    Mockito.verify(mView).showLoading();

    Mockito.verify(mView).hideLoading();
    Mockito.verify(mView).enableRefresh();
    Mockito.verify(mView).hideRefresh();

    Mockito.verify(mView).showWeapons(Mockito.anyList());
    Mockito.verify(mView).showMessageNotResults();
  }

  private Observable<List<WeaponResponse>> getFakeObservableWeaponsEmptyList() {
    List<WeaponResponse> testList = new ArrayList<>();
    return Observable.just(testList);
  }

  @Test public void shouldShowCampaignDataTest() {
    Mockito.when(mRepositoryMock.getWeapons()).thenReturn(getFakeObservableEnemiesList());
    mPresenter.getWeapons();

    Mockito.verify(mView).disableRefresh();
    Mockito.verify(mView).hideMessageConnectionError();
    Mockito.verify(mView).showLoading();

    Mockito.verify(mView).hideLoading();
    Mockito.verify(mView).enableRefresh();
    Mockito.verify(mView).hideRefresh();

    Mockito.verify(mView).showWeapons(Mockito.anyList());
    Mockito.verify(mView).hideMessageNotResults();
  }

  private Observable<List<WeaponResponse>> getFakeObservableEnemiesList() {
    List<WeaponResponse> testList = new ArrayList<>();
    testList.add(new WeaponResponse("", "", "", "", "", false));
    return Observable.just(testList);
  }

  @Test public void shouldShowErrorDataTest() {
    Mockito.when(mRepositoryMock.getWeapons()).thenReturn(getErrorObservableWeaponsList());
    mPresenter.getWeapons();

    Mockito.verify(mView).disableRefresh();
    Mockito.verify(mView).hideMessageConnectionError();
    Mockito.verify(mView).showLoading();

    Mockito.verify(mView).hideLoading();
    Mockito.verify(mView).hideRefresh();
    Mockito.verify(mView).showMessageConnectionError();
  }

  private Observable<List<WeaponResponse>> getErrorObservableWeaponsList() {
    return Observable.error(new Throwable("fake error"));
  }
}
