package com.inventive.hack.halotesting.domain;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.WeaponResponse;
import com.inventive.hack.halotesting.halo.domain.usecase.WeaponsUseCase;
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

@RunWith(MockitoJUnitRunner.class) public class WeaponsUseCaseTest {

  @Mock private HaloRepository mRepository;

  private UseCase<List<WeaponResponse>> mWeaponsResponseUseCase;

  @Before public void setup() {
    MockitoAnnotations.initMocks(this);
    mWeaponsResponseUseCase =
        new WeaponsUseCase(Schedulers.trampoline(), Schedulers.trampoline(), mRepository);
  }

  @Test public void shouldCallRepositoryTest() {

    Mockito.when(mRepository.getWeapons()).thenReturn(getFakeObservableWeaponsList());
    mWeaponsResponseUseCase.execute(new TestDisposableObserver());

    Mockito.verify(mRepository, only()).getWeapons();
  }

  private Observable<List<WeaponResponse>> getFakeObservableWeaponsList() {
    List<WeaponResponse> testList = new ArrayList<>();
    return Observable.just(testList);
  }

  private class TestDisposableObserver extends DisposableObserver<List<WeaponResponse>> {

    @Override public void onNext(List<WeaponResponse> weaponResponses) {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onComplete() {

    }
  }
}
