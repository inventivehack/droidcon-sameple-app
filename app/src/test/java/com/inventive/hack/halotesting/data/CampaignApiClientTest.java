package com.inventive.hack.halotesting.data;

import com.inventive.hack.halotesting.common.data.cloud.ClientConstants;
import com.inventive.hack.halotesting.halo.data.cloud.HaloRestApi;
import com.inventive.hack.halotesting.halo.data.cloud.HaloRestApiImpl;
import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import io.reactivex.observers.TestObserver;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * 27/02/2017.
 */

public class CampaignApiClientTest extends ApiClientTest {



  @Test public void shouldRequestContainsCampaignPathTest() throws IOException,
      InterruptedException {

    HaloRestApi haloRestApi = new HaloRestApiImpl(getBaseEndpoint());

    enqueueMockResponse("haloCampaignResponse.json", 200);

    TestObserver<List<CampaignEntityResponse>> test = haloRestApi.getCampaign().test();
    test.awaitTerminalEvent();

    assertRequestSentToContains(ClientConstants.EndPointApi.CAMPAIGN);


  }






  @Test public void shouldListModelContainsResponseTest() throws IOException {

    HaloRestApi haloRestApi = new HaloRestApiImpl(getBaseEndpoint());
    enqueueMockResponse("haloCampaignResponse.json", 200);

    TestObserver<List<CampaignEntityResponse>> test = haloRestApi.getCampaign().test();
    test.awaitTerminalEvent();

    List<CampaignEntityResponse> entityResponseList = test.values().get(0);

    assertThatCampaignResponseIsPropertyParsed(entityResponseList);
  }




  private void assertThatCampaignResponseIsPropertyParsed(
      List<CampaignEntityResponse> entityResponseList) {
    assertThat(entityResponseList.size(), is(greaterThan(0)));

    CampaignEntityResponse entityResponse = entityResponseList.get(0);

    assertThat(entityResponse.getContentId(), is(notNullValue()));
    assertThat(entityResponse.getId(), is(notNullValue()));
    assertThat(entityResponse.getName(), is(notNullValue()));
    assertThat(entityResponse.getMissionNumber(), is(notNullValue()));
    assertThat(entityResponse.getDescription(), is(notNullValue()));
    assertThat(entityResponse.getImageUrl(), is(notNullValue()));
    assertThat(entityResponse.getType(), is(notNullValue()));
  }

  @Test public void shouldThatModelContainsExpectedValuesTest() throws IOException {
    HaloRestApi haloRestApi = new HaloRestApiImpl(getBaseEndpoint());
    enqueueMockResponse("haloCampaignResponse.json", 200);

    TestObserver<List<CampaignEntityResponse>> test = haloRestApi.getCampaign().test();
    test.awaitTerminalEvent();

    List<CampaignEntityResponse> entityResponseList = test.values().get(0);

    assertThatModelContainsExpectedValuesTes(entityResponseList);
  }

  private void assertThatModelContainsExpectedValuesTes(
      List<CampaignEntityResponse> entityResponseList) {

    CampaignEntityResponse entityResponse = entityResponseList.get(0);

    assertThat(entityResponse.getContentId(), is("94ad113a-31ce-4fce-ac4a-87e6cfbb88d9"));
    assertThat(entityResponse.getId(), is("73ed1fd0-45e5-4bb9-ab6a-d2852c04ea7d"));
    assertThat(entityResponse.getName(), is("Osiriss"));
    assertThat(entityResponse.getMissionNumber(), is("1"));
    assertThat(entityResponse.getDescription(),
        is("Fireteam Osiris are dispatched to recover the UNSC’s most wanted criminal: Doctor Catherine Elizabeth Halsey"));
    assertThat(entityResponse.getImageUrl(),
        is("https://content.halocdn.com/media/Default/games/halo-5-guardians/map-images/campaign/campaign_missions_array01-9c1ff3f00e364bfaa0e059a90fa37d92.jpg"));
    assertThat(entityResponse.getType(), is("OsirisTeam"));
  }
}
