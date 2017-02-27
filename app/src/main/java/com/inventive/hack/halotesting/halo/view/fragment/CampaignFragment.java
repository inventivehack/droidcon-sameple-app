package com.inventive.hack.halotesting.halo.view.fragment;

import android.os.Bundle;
import android.view.View;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.common.view.BaseFragment;
import com.inventive.hack.halotesting.halo.view.presenter.CampaignPresenter;
import com.inventive.hack.halotesting.halo.view.viewmvp.CampaignView;
import com.inventive.hack.halotesting.injector.component.HaloComponent;
import javax.inject.Inject;

/**
 * 26/02/2017.
 */

public class CampaignFragment extends BaseFragment implements CampaignView {

  @Inject CampaignPresenter mPresenter;

  public static CampaignFragment newInstance() {
    return new CampaignFragment();
  }

  @Override protected int getFragmentLayout() {
    return R.layout.fragment_campaign;
  }

  @Override protected void initView(View view, Bundle savedInstanceState) {
    super.initView(view, savedInstanceState);
    initializeDagger();
    initializePresenter();
  }

  private void initializeDagger() {
    getComponent(HaloComponent.class).inject(this);
  }

  private void initializePresenter() {
    mPresenter.setView(this);
  }

  @Override public void showMessageErrorResponseNetwork(String messageError, int typeError) {
    showDefaultMessageSnackBar(R.string.message_error_response_network);
  }
}
