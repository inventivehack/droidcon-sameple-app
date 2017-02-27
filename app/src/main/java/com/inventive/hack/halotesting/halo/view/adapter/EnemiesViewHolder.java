package com.inventive.hack.halotesting.halo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.halo.view.presenter.CampaignPresenter;
import com.inventive.hack.halotesting.halo.view.presenter.EnemiesPresenter;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import com.inventive.hack.halotesting.halo.view.viewmodel.EnemyViewModel;

/**
 * 27/02/2017.
 */

public class EnemiesViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.image_enemy) ImageView mImageEnemy;
  @BindView(R.id.label_title) TextView mLabelTitle;
  @BindView(R.id.label_description) TextView mLabelDescription;

  private EnemiesPresenter mPresenter;
  private EnemyViewModel mViewModel;
  private Context mContext;

  public EnemiesViewHolder(View itemView, EnemiesPresenter presenter, Context context) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    mPresenter = presenter;
    mContext = context;
  }

  public void render(EnemyViewModel viewModel) {
    mViewModel = viewModel;
    renderImage(mViewModel.getLargeIconImageUrl());
    renderTitle(mViewModel.getName());
    renderDescription(mViewModel.getDescription());
  }

  private void renderImage(String imageUrl) {
    Glide.with(mContext).load(imageUrl).crossFade().into(mImageEnemy);
  }

  private void renderTitle(String name) {
    mLabelTitle.setText(name);
  }

  private void renderDescription(String description) {
    mLabelDescription.setText(description);
  }

  @OnClick(R.id.item_enemy) public void clickItemPayment() {
    mPresenter.selectEnemy(mViewModel);
  }
}
