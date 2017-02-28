package com.inventive.hack.halotesting.presenter;

import com.inventive.hack.halotesting.halo.view.presenter.CampaignDetailPresenter;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import com.inventive.hack.halotesting.halo.view.viewmvp.CampaignDetailView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * 27/02/2017.
 */

public class CampaignDetailPresenterTest {

  private CampaignDetailPresenter mPresenter;
  @Mock CampaignDetailView mView;

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
    mPresenter = new CampaignDetailPresenter();
    mPresenter.setView(mView);
  }

  @Test public void shouldShowViewModelTest() {
    mPresenter.setViewModel(getFakeViewModel());

    Mockito.verify(mView).showImageCampaign(Mockito.anyString());
    Mockito.verify(mView).showNameCampaign(Mockito.anyString());
    Mockito.verify(mView).showDescriptionCampaign(Mockito.anyString());
  }

  private CampaignViewModel getFakeViewModel() {
    return new CampaignViewModel("", "", "", "", "");
  }
}
