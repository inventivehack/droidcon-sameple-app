package com.inventive.hack.halotesting.halo.view.fragment;

import android.os.Bundle;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.common.view.BaseFragment;

/**
 * 26/02/2017.
 */

public class CampaignDetailFragment extends BaseFragment {

  public static CampaignDetailFragment newInstance(Bundle bundle) {

    CampaignDetailFragment campaignDetailFragment = new CampaignDetailFragment();
    campaignDetailFragment.setArguments(bundle);
    return campaignDetailFragment;
  }

  @Override protected int getFragmentLayout() {
    return R.layout.fragment_campaign_detail;
  }
}
