package com.inventive.hack.halotesting.presenter;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.inventive.hack.halotesting.MyApplication;
import com.inventive.hack.halotesting.halo.data.repository.HaloRepository;
import com.inventive.hack.halotesting.halo.domain.model.CampaignResponse;
import com.inventive.hack.halotesting.halo.view.activity.HomeActivity;
import com.inventive.hack.halotesting.injector.component.MainComponent;
import com.inventive.hack.halotesting.injector.module.MainModule;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import it.cosenonjaviste.daggermock.DaggerMockRule;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * 28/02/2017.
 */

@RunWith(AndroidJUnit4.class) @LargeTest public class CampaignFragmentTest {

  @Rule public DaggerMockRule<MainComponent> daggerRule =
      new DaggerMockRule<>(MainComponent.class, new MainModule()).set(component -> {
        MyApplication mMyApplication = (MyApplication) InstrumentationRegistry.getInstrumentation()
            .getTargetContext()
            .getApplicationContext();
        mMyApplication.setComponent(component);
      });

  @Rule public ActivityTestRule<HomeActivity> mActivityRule =
      new ActivityTestRule<>(HomeActivity.class);

  @Mock public HaloRepository mRepository;

  @Test public void shouldShowList() {

    CampaignResponse campaignResponse = givenSomeCampaignResponse();

    Observable<List<CampaignResponse>> fakeObservableCampaignList =
        getFakeObservableCampaignList(campaignResponse);

    TestObserver<List<CampaignResponse>> test = fakeObservableCampaignList.test();

    Mockito.when(mRepository.getCampaign()).thenReturn(fakeObservableCampaignList);

    test.awaitTerminalEvent();

    onView(withText(campaignResponse.getName())).check(matches(isDisplayed()));
    onView(withText(campaignResponse.getDescription())).check(matches(isDisplayed()));
  }

  private Observable<List<CampaignResponse>> getFakeObservableCampaignList(
      CampaignResponse campaignResponse) {
    List<CampaignResponse> testList = new ArrayList<>();
    testList.add(campaignResponse);
    return Observable.just(testList);
  }

  private CampaignResponse givenSomeCampaignResponse() {
    return new CampaignResponse("1", "Osiris",
        "Fireteam Osiris are dispatched to recover the UNSC’s most wanted criminal: Doctor Catherine Elizabeth Halsey",
        "https://content.halocdn.com/media/Default/games/halo-5-guardians/map-images/campaign/campaign_missions_array01-9c1ff3f00e364bfaa0e059a90fa37d92.jpg",
        "OsirisTeam");
  }
}
