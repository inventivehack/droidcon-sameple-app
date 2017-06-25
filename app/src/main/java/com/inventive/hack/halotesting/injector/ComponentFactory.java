package com.inventive.hack.halotesting.injector;

import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.inventive.hack.halotesting.injector.component.DaggerHaloComponent;
import com.inventive.hack.halotesting.injector.component.HaloComponent;
import com.inventive.hack.halotesting.injector.component.MainComponent;

/**
 * 25/06/2017.
 */

public final class ComponentFactory {

  @VisibleForTesting private static HaloComponent haloComponent;

  private ComponentFactory() {
  }

  public static HaloComponent getHaloComponent(MainComponent mainComponent) {
    if (haloComponent != null) {
      Log.d(ComponentFactory.class.getSimpleName(), "getHaloComponent not null");
      return haloComponent;
    } else {
      Log.d(ComponentFactory.class.getSimpleName(), "getHaloComponent  null");
      return DaggerHaloComponent.builder().mainComponent(mainComponent).build();
    }
  }

  @VisibleForTesting public static void setHaloComponent(HaloComponent haloComponent) {
    ComponentFactory.haloComponent = haloComponent;
  }
}
