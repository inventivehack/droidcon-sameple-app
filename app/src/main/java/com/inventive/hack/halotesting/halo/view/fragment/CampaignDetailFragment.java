package com.inventive.hack.halotesting.halo.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.common.view.BaseFragment;
import com.inventive.hack.halotesting.halo.view.activity.CampaignDetailActivity;
import com.inventive.hack.halotesting.halo.view.presenter.CampaignDetailPresenter;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import com.inventive.hack.halotesting.halo.view.viewmvp.CampaignDetailView;
import com.inventive.hack.halotesting.injector.component.HaloComponent;
import javax.inject.Inject;

/**
 * 26/02/2017.
 */

public class CampaignDetailFragment extends BaseFragment implements CampaignDetailView {

  @BindView(R.id.image_campaign) ImageView mImageCampaign;
  @BindView(R.id.label_name_campaign) TextView mLabelNameCampaign;
  @BindView(R.id.label_description_campaign) TextView mLabelDescriptionCampaign;

  @Inject CampaignDetailPresenter mPresenter;

  public static CampaignDetailFragment newInstance(Bundle bundle) {
    CampaignDetailFragment campaignDetailFragment = new CampaignDetailFragment();
    campaignDetailFragment.setArguments(bundle);
    return campaignDetailFragment;
  }

  @Override protected int getFragmentLayout() {
    return R.layout.fragment_campaign_detail;
  }

  @Override protected void initView(View view, Bundle savedInstanceState) {
    super.initView(view, savedInstanceState);
    initializeDagger();
    initializePresenter();
    mPresenter.setViewModel(getCampaignViewModelFromArgs());
  }

  private CampaignViewModel getCampaignViewModelFromArgs() {
    return (CampaignViewModel) getArguments().getSerializable(CampaignDetailActivity.CAMPAIGN_ARGS);
  }

  private void initializeDagger() {
    getComponent(HaloComponent.class).inject(this);
  }

  private void initializePresenter() {
    mPresenter.setView(this);
  }

  @Override public void showImageCampaign(String imageUrl) {
    Glide.with(getContext()).load(imageUrl).centerCrop().crossFade().into(mImageCampaign);
  }

  @Override public void showNameCampaign(String name) {
    mLabelNameCampaign.setText(name);
  }

  @Override public void showDescriptionCampaign(String description) {
    mLabelDescriptionCampaign.setText(description);
  }
}
