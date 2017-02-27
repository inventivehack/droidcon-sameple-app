package com.inventive.hack.halotesting.halo.view.activity;

import android.support.v4.app.Fragment;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.common.view.BaseFragActivity;
import com.inventive.hack.halotesting.halo.view.fragment.CampaignDetailFragment;
import com.inventive.hack.halotesting.injector.HasComponent;
import com.inventive.hack.halotesting.injector.component.DaggerHaloComponent;
import com.inventive.hack.halotesting.injector.component.HaloComponent;

/**
 * 26/02/2017.
 */

public class CampaignDetailActivity extends BaseFragActivity
    implements HasComponent<HaloComponent> {

  private HaloComponent mHaloComponent;

  @Override protected Fragment getFragmentInstance() {
    return CampaignDetailFragment.newInstance();
  }

  @Override protected int getIdFragmentContainer() {
    return R.id.fragment_container;
  }

  @Override protected int getLayout() {
    return R.layout.activity_campaign_detail;
  }

  @Override protected void initView() {
    super.initView();
    initializeInjector();
  }

  private void initializeInjector() {
    mHaloComponent =
        DaggerHaloComponent.builder().mainComponent(getApplicationComponent()).build();
  }

  @Override public HaloComponent getComponent() {
    return mHaloComponent;
  }
}