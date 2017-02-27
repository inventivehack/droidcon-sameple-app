package com.inventive.hack.halotesting.injector.component;

import com.inventive.hack.halotesting.halo.view.fragment.CampaignFragment;
import com.inventive.hack.halotesting.halo.view.fragment.EnemiesFragment;
import com.inventive.hack.halotesting.halo.view.fragment.WeaponsFragment;
import com.inventive.hack.halotesting.injector.Activity;
import com.inventive.hack.halotesting.injector.module.HaloModule;
import dagger.Component;

/**
 * 24/02/2017.
 */
@Activity @Component(dependencies = MainComponent.class, modules = HaloModule.class)
public interface HaloComponent {

  void inject(CampaignFragment campaignFragment);

  void inject(EnemiesFragment enemiesFragment);

  void inject(WeaponsFragment weaponsFragment);
}
