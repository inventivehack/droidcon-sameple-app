package com.inventive.hack.halotesting.halo.view.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.OnClick;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.common.view.BaseFragment;
import com.inventive.hack.halotesting.halo.view.adapter.EnemiesAdapter;
import com.inventive.hack.halotesting.halo.view.adapter.WeaponsAdapter;
import com.inventive.hack.halotesting.halo.view.presenter.EnemiesPresenter;
import com.inventive.hack.halotesting.halo.view.presenter.WeaponsPresenter;
import com.inventive.hack.halotesting.halo.view.viewmodel.EnemyViewModel;
import com.inventive.hack.halotesting.halo.view.viewmodel.WeaponViewModel;
import com.inventive.hack.halotesting.halo.view.viewmvp.WeaponsView;
import com.inventive.hack.halotesting.injector.component.HaloComponent;
import java.util.List;
import javax.inject.Inject;

/**
 * 26/02/2017.
 */

public class WeaponsFragment extends BaseFragment implements WeaponsView, SwipeRefreshLayout.OnRefreshListener{


  @BindView(R.id.progress_loading) ProgressBar mProgressLoading;
  @BindView(R.id.swipe_refresh) SwipeRefreshLayout mSwipeRefresh;
  @BindView(R.id.list_weapons) RecyclerView mListWeapons;
  @BindView(R.id.element_connection_error) LinearLayout mElementConnectionError;
  @BindView(R.id.element_not_results) FrameLayout mElementNotResults;

  @Inject WeaponsPresenter mPresenter;

  private WeaponsAdapter mAdapter;


  public static WeaponsFragment newInstance() {
    return new WeaponsFragment();
  }

  @Override protected int getFragmentLayout() {
    return R.layout.fragment_weapons;
  }

  @Override protected void initView(View view, Bundle savedInstanceState) {
    super.initView(view, savedInstanceState);
    initializeDagger();
    initializePresenter();
    initializeAdapter();
    initializeList();
    setupSwipeRefresh();
    mPresenter.getWeapons();
  }

  private void initializeDagger() {
    getComponent(HaloComponent.class).inject(this);
  }

  private void initializePresenter() {
    mPresenter.setView(this);
  }


  private void initializeAdapter() {
    if (mAdapter == null) mAdapter = new WeaponsAdapter(getContext(), mPresenter);
  }

  private void initializeList() {
    mListWeapons.setLayoutManager(new LinearLayoutManager(getContext()));
    mListWeapons.setAdapter(mAdapter);
  }

  private void setupSwipeRefresh() {
    mSwipeRefresh.setColorSchemeResources(R.color.accent);
    mSwipeRefresh.setOnRefreshListener(this);
  }

  @Override public void onRefresh() {
    mPresenter.refreshWeapons();
  }

  @OnClick(R.id.element_connection_error) public void clickConnectionError() {
    mPresenter.getWeapons();
  }

  @Override public void showLoading() {
    mProgressLoading.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    mProgressLoading.setVisibility(View.GONE);
  }

  @Override public void enableRefresh() {
    mSwipeRefresh.setEnabled(true);
  }

  @Override public void disableRefresh() {
    mSwipeRefresh.setEnabled(false);
  }

  @Override public void showRefresh() {
    mSwipeRefresh.setRefreshing(true);
  }

  @Override public void hideRefresh() {
    mSwipeRefresh.setRefreshing(false);
  }

  @Override public void showWeapons(List<WeaponViewModel> viewModels) {
    mAdapter.setAll(viewModels);
  }

  @Override public void showDetailWeapon(WeaponViewModel cardViewModel) {

  }

  @Override public void showMessageNotResults() {
    mElementNotResults.setVisibility(View.VISIBLE);
  }

  @Override public void hideMessageNotResults() {
    mElementNotResults.setVisibility(View.GONE);
  }

  @Override public void showMessageConnectionError() {
    if (mAdapter.isEmptyList()) {
      mElementConnectionError.setVisibility(View.VISIBLE);
    } else {
      showDefaultMessageSnackBar(R.string.message_error_network);
    }
  }

  @Override public void hideMessageConnectionError() {
    mElementConnectionError.setVisibility(View.GONE);
  }



}
