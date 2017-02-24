package com.inventive.hack.halotesting;

import android.app.Application;
import com.inventive.hack.halotesting.injector.component.DaggerMainComponent;
import com.inventive.hack.halotesting.injector.component.MainComponent;
import com.inventive.hack.halotesting.injector.module.MainModule;

/**
 * {@link Application} que inicia la configuración de la injección de dependencias.
 */
public class MyApplication extends Application {

  private MainComponent mainComponent;

  @Override public void onCreate() {
    super.onCreate();
    initializeInjector();
  }

  private void initializeInjector() {
    mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
  }

  public MainComponent getMainComponent() {
    return mainComponent;
  }
}
