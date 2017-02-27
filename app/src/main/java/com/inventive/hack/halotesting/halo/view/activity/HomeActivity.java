package com.inventive.hack.halotesting.halo.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.common.view.BaseNavigationActivity;
import com.inventive.hack.halotesting.halo.view.fragment.CampaignFragment;
import com.inventive.hack.halotesting.halo.view.fragment.EnemiesFragment;
import com.inventive.hack.halotesting.halo.view.fragment.WeaponsFragment;
import com.inventive.hack.halotesting.injector.HasComponent;
import com.inventive.hack.halotesting.injector.component.DaggerHaloComponent;
import com.inventive.hack.halotesting.injector.component.HaloComponent;

public class HomeActivity extends BaseNavigationActivity implements HasComponent<HaloComponent> {

  private HaloComponent mComponent;

  public static Intent provideIntent(Context context) {
    return new Intent(context, HomeActivity.class).addFlags(
        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
  }

  @Override protected Fragment getFragmentInstance() {
    return CampaignFragment.newInstance();
  }

  @Override protected void initView() {
    super.initView();
    initializeInjector();
  }

  private void initializeInjector() {
    mComponent = DaggerHaloComponent.builder().mainComponent(getApplicationComponent()).build();
  }

  @Override protected void selectNavigationHeader() {

  }

  @Override protected void selectNewItem(int itemId) {

    switch (itemId) {
      case R.id.drawer_item_campaign:
        replaceFragment(CampaignFragment.newInstance());
        break;
      case R.id.drawer_item_enemies:
        replaceFragment(EnemiesFragment.newInstance());
        break;
      case R.id.drawer_item_weapons:
        replaceFragment(WeaponsFragment.newInstance());
        break;
    }
  }

  @Override public HaloComponent getComponent() {
    return mComponent;
  }
}
