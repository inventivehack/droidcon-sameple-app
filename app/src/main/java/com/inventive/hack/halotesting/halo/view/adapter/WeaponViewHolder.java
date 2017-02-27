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
import com.inventive.hack.halotesting.halo.view.presenter.EnemiesPresenter;
import com.inventive.hack.halotesting.halo.view.presenter.WeaponsPresenter;
import com.inventive.hack.halotesting.halo.view.viewmodel.EnemyViewModel;
import com.inventive.hack.halotesting.halo.view.viewmodel.WeaponViewModel;

/**
 * 27/02/2017.
 */

public class WeaponViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.image_weapon) ImageView mImageWeapon;
  @BindView(R.id.label_title) TextView mLabelTitle;
  @BindView(R.id.label_description) TextView mLabelDescription;

  private WeaponsPresenter mPresenter;
  private WeaponViewModel mViewModel;
  private Context mContext;

  public WeaponViewHolder(View itemView, WeaponsPresenter presenter, Context context) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    mPresenter = presenter;
    mContext = context;
  }

  public void render(WeaponViewModel viewModel) {
    mViewModel = viewModel;
    renderImage(mViewModel.getLargeIconImageUrl());
    renderTitle(mViewModel.getName());
    renderDescription(mViewModel.getDescription());
  }

  private void renderImage(String imageUrl) {
    Glide.with(mContext).load(imageUrl).crossFade().centerCrop().into(mImageWeapon);
  }

  private void renderTitle(String name) {
    mLabelTitle.setText(name);
  }

  private void renderDescription(String description) {
    mLabelDescription.setText(description);
  }

  @OnClick(R.id.item_weapon) public void clickItemPayment() {
    mPresenter.selectWeapon(mViewModel);
  }
}
