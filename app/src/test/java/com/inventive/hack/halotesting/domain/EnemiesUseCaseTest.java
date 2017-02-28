package com.inventive.hack.halotesting.domain;

import com.inventive.hack.halotesting.common.domain.UseCase;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.EnemyResponse;
import com.inventive.hack.halotesting.halo.domain.usecase.EnemiesUseCase;
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

@RunWith(MockitoJUnitRunner.class) public class EnemiesUseCaseTest {

  @Mock private HaloRepository mRepository;

  private UseCase<List<EnemyResponse>> mEnemiesResponseUseCase;

  @Before public void setup() {
    MockitoAnnotations.initMocks(this);
    mEnemiesResponseUseCase =
        new EnemiesUseCase(Schedulers.trampoline(), Schedulers.trampoline(), mRepository);
  }

  @Test public void shouldCallRepositoryTest() {

    Mockito.when(mRepository.getEnemies()).thenReturn(getFakeObservableEnemiesList());
    mEnemiesResponseUseCase.execute(new TestDisposableObserver());

    Mockito.verify(mRepository, only()).getEnemies();
  }

  private Observable<List<EnemyResponse>> getFakeObservableEnemiesList() {
    List<EnemyResponse> testList = new ArrayList<>();
    return Observable.just(testList);
  }

  private class TestDisposableObserver extends DisposableObserver<List<EnemyResponse>> {

    @Override public void onNext(List<EnemyResponse> enemyResponses) {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onComplete() {

    }
  }
}
