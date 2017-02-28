package com.inventive.hack.halotesting.injector.module;

import android.app.Application;
import android.content.Context;
import com.inventive.hack.halotesting.MyApplication;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Componente principal de la aplicación para brindar las dependencias necesarias a otros
 * componentes.
 *
 * @see <p>Para más información sobre inyección de dependencias, ver el siguiente post <a
 * href="http://fernandocejas.com/2015/04/11/tasting-dagger-2-on-android/ "> Tasting Dagger 2 on
 * Android</a></p>
 */
@Module public class MainModule {

  private final Application application;

  public MainModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return application;
  }


}
