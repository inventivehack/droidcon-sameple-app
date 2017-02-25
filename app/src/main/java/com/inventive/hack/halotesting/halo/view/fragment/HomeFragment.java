package com.inventive.hack.halotesting.halo.view.fragment;

import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.common.view.BaseFragment;

/**
 * 13/02/2017.
 */

public class HomeFragment extends BaseFragment {

  public static HomeFragment newInstance() {
    return new HomeFragment();
  }

  @Override protected int getFragmentLayout() {
    return R.layout.fragment_home;
  }
}
