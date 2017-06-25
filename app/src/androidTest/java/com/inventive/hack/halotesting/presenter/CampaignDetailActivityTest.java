package com.inventive.hack.halotesting.presenter;

import android.content.Intent;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.inventive.hack.halotesting.R;
import com.inventive.hack.halotesting.halo.view.activity.CampaignDetailActivity;
import com.inventive.hack.halotesting.halo.view.viewmodel.CampaignViewModel;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * 28/02/2017.
 */

@RunWith(AndroidJUnit4.class) @LargeTest public class CampaignDetailActivityTest {

  @Rule public ActivityTestRule<CampaignDetailActivity> mActivityRule =
      new ActivityTestRule<>(CampaignDetailActivity.class, true, false);

  @Test public void shouldContainDetailCampaign() {

    CampaignViewModel campaignViewModel = givenSomeCampaignViewModel();

    startActivity(campaignViewModel);

    assertThatViewsAreDisplay();

    assetThatViewsContainsExpectedValues(campaignViewModel);
  }

  private void assertThatViewsAreDisplay() {
    onView(withId(R.id.image_campaign)).check(matches(isDisplayed()));
    onView(withId(R.id.label_name_campaign)).check(matches(isDisplayed()));
    onView(withId(R.id.label_description_campaign)).check(matches(isDisplayed()));
  }

  private void assetThatViewsContainsExpectedValues(CampaignViewModel campaignViewModel) {
    onView(withId(R.id.label_name_campaign)).check(matches(withText(campaignViewModel.getName())));
    onView(withId(R.id.label_description_campaign)).check(
        matches(withText(campaignViewModel.getDescription())));
  }

  private CampaignViewModel givenSomeCampaignViewModel() {
    return new CampaignViewModel("1", "Osiris",
        "Fireteam Osiris are dispatched to recover the UNSC’s most wanted criminal: Doctor Catherine Elizabeth Halsey",
        "https://content.halocdn.com/media/Default/games/halo-5-guardians/map-images/campaign/campaign_missions_array01-9c1ff3f00e364bfaa0e059a90fa37d92.jpg",
        "OsirisTeam");
  }

  private CampaignDetailActivity startActivity(CampaignViewModel campaignViewModel) {

    Intent intent = new Intent();
    intent.putExtra(CampaignDetailActivity.CAMPAIGN_ARGS, campaignViewModel);

    return mActivityRule.launchActivity(intent);
  }
}
