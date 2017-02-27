package com.inventive.hack.halotesting.halo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.halo.view.presenter.CampaignPresenter;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 * 27/02/2017.
 */

public class CampaignAdapter extends RecyclerView.Adapter<CampaignViewHolder> {

  private Context mContext;
  private LayoutInflater inflater;
  private CampaignPresenter mPresenter;

  private List<CampaignViewModel> mViewModelList;

  public CampaignAdapter(Context context, CampaignPresenter presenter) {
    mContext = context;
    inflater = LayoutInflater.from(mContext);
    mPresenter = presenter;
    mViewModelList = new ArrayList<>();
  }

  public void setAll(List<CampaignViewModel> viewModelList) {
    mViewModelList = viewModelList;
    notifyDataSetChanged();
  }

  public boolean isEmptyList() {
    return mViewModelList.isEmpty();
  }

  @Override public CampaignViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View viewItem = inflater.inflate(R.layout.item_campaign, parent, false);
    return new CampaignViewHolder(viewItem, mPresenter, mContext);
  }

  @Override public void onBindViewHolder(CampaignViewHolder holder, int position) {
    holder.render(mViewModelList.get(position));
  }

  @Override public int getItemCount() {
    return mViewModelList.size();
  }


}
