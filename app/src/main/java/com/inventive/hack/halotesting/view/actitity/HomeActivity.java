package com.inventive.hack.halotesting.view.actitity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.inventive.hack.halotesting.common.view.BaseNavigationActivity;
import com.inventive.hack.halotesting.view.fragment.HomeFragment;

public class HomeActivity extends BaseNavigationActivity {

  public static Intent provideIntent(Context context) {
    return new Intent(context, HomeActivity.class).addFlags(
        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
  }

  @Override protected Fragment getFragmentInstance() {
    return HomeFragment.newInstance();
  }

  @Override protected void selectNavigationHeader() {

  }

  @Override protected void selectNewItem(int itemId) {

  }
}
