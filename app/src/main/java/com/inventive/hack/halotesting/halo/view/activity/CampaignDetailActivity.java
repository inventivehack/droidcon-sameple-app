package com.inventive.hack.halotesting.halo.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.common.view.BaseFragActivity;
import com.inventive.hack.halotesting.halo.view.fragment.CampaignDetailFragment;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import com.inventive.hack.halotesting.injector.ComponentFactory;
import com.inventive.hack.halotesting.injector.HasComponent;
import com.inventive.hack.halotesting.injector.component.HaloComponent;

/**
 * 26/02/2017.
 */

public class CampaignDetailActivity extends BaseFragActivity
    implements HasComponent<HaloComponent> {

  public static final String CAMPAIGN_ARGS = "campaign";
  private HaloComponent mComponent;

  public static Intent provideIntent(Context context, CampaignViewModel campaignViewModel) {
    return new Intent(context, CampaignDetailActivity.class).putExtra(CAMPAIGN_ARGS,
        campaignViewModel);
  }

  @Override protected Fragment getFragmentInstance() {
    return CampaignDetailFragment.newInstance(getIntent().getExtras());
  }

  @Override protected int getIdFragmentContainer() {
    return R.id.fragment_container;
  }

  @Override protected int getLayout() {
    return R.layout.activity_campaign_detail;
  }

  @Override protected void setupActionBar(ActionBar actionBar) {
    super.setupActionBar(actionBar);
    actionBar.setDisplayHomeAsUpEnabled(true);
  }

  @Override protected void initView() {
    super.initView();
    initializeInjector();
  }

  private void initializeInjector() {
    mComponent = ComponentFactory.getHaloComponent(getApplicationComponent());
    ;
  }

  @Override public HaloComponent getComponent() {
    return mComponent;
  }
}
