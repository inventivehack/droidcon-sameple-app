package com.inventive.hack.halotesting.halo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.halo.view.presenter.EnemiesPresenter;
import com.inventive.hack.halotesting.halo.view.viewmodel.EnemyViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 * 27/02/2017.
 */

public class EnemiesAdapter extends RecyclerView.Adapter<EnemiesViewHolder> {

  private Context mContext;
  private LayoutInflater inflater;
  private EnemiesPresenter mPresenter;

  private List<EnemyViewModel> mViewModelList;

  public EnemiesAdapter(Context context, EnemiesPresenter presenter) {
    mContext = context;
    inflater = LayoutInflater.from(mContext);
    mPresenter = presenter;
    mViewModelList = new ArrayList<>();
  }

  public void setAll(List<EnemyViewModel> viewModelList) {
    mViewModelList = viewModelList;
    notifyDataSetChanged();
  }

  @Override public EnemiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View viewItem = inflater.inflate(R.layout.item_campaign, parent, false);
    return new EnemiesViewHolder(viewItem, mPresenter, mContext);
  }

  @Override public void onBindViewHolder(EnemiesViewHolder holder, int position) {
    holder.render(mViewModelList.get(position));
  }

  @Override public int getItemCount() {
    return mViewModelList.size();
  }
}
