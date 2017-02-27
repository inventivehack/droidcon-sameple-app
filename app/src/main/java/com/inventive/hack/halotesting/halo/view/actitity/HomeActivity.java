package com.inventive.hack.halotesting.halo.view.actitity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.common.view.BaseNavigationActivity;
import com.inventive.hack.halotesting.halo.view.fragment.CampaignFragment;
import com.inventive.hack.halotesting.halo.view.fragment.EnemiesFragment;
import com.inventive.hack.halotesting.halo.view.fragment.WeaponsFragment;

public class HomeActivity extends BaseNavigationActivity {

  public static Intent provideIntent(Context context) {
    return new Intent(context, HomeActivity.class).addFlags(
        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
  }

  @Override protected Fragment getFragmentInstance() {
    return CampaignFragment.newInstance();
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
}
