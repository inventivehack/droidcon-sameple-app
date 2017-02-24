package com.inventive.hack.halotesting.common.domain;

import com.inventive.hack.halotesting.common.view.Presenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Dominio con un caso de uso asíncrono por default. Para comunicar las capa de presentación con
 * las
 * capa de dominio utiliza un {@link Observable} de RxJava.
 *
 * @see <p>Para más información investigar más sobre <a href="http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/">Clean
 * Architecture</a> y <a href="http://reactivex.io/intro.html">Programción Reactiva con
 * RxJava</a></p>
 */
public abstract class UseCase<T> {

  private final CompositeDisposable compositeDisposable;

  public UseCase() {
    this.compositeDisposable = new CompositeDisposable();
  }

  /**
   * Ejecuta el {@link Observable} del caso de uso y configura el {@link DisposableObserver}, como
   * es el
   * hilo en el cual se ejecutara el observable y en que hilo responderá. el cual esta implementado
   * en el {@link Presenter}.
   *
   * @param disposableObserver Es el {@link DisposableObserver} donde responderá el {@link
   * Observable},
   */
  @SuppressWarnings("unchecked") public void execute(DisposableObserver<T> disposableObserver) {
    compositeDisposable.add(buildObservableUseCase().subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(disposableObserver));

  }

  /**
   * Cancela la suscrición del actual  {@link DisposableObserver}.
   */
  public void dispose() {
    if (!compositeDisposable.isDisposed()) {
      compositeDisposable.dispose();
    }
  }

  /**
   * Crea la configuración del {@link Observable} que se comunicará de la capa de Datos a la capa
   * de Presentación, la clase que implemente este método definiera su comportamiento, pero generar
   * se comunica por medio del patrón repositorio.
   *
   * @return {@link Observable} construido.
   */
  protected abstract Observable<T> buildObservableUseCase();
}
