package com.inventive.hack.halotesting.data;

import com.inventive.hack.halotesting.common.data.cloud.ClientConstants;
import com.inventive.hack.halotesting.halo.data.cloud.HaloRestApi;
import com.inventive.hack.halotesting.halo.data.cloud.HaloRestApiImpl;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.WeaponEntityResponse;
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

public class WeaponsApiClientTest extends ApiClientTest {

  @Test public void shouldRequestContainsCampaignPathTest()
      throws IOException, InterruptedException {
    HaloRestApi haloRestApi = new HaloRestApiImpl(getBaseEndpoint());
    enqueueMockResponse("haloWeaponsResponse.json", 200);

    TestObserver<List<WeaponEntityResponse>> test = haloRestApi.getWeapons().test();
    test.awaitTerminalEvent();

    assertRequestSentToContains(ClientConstants.EndPointApi.WEAPONS);
  }


  @Test public void shouldListModelContainsResponseTest() throws IOException {

    HaloRestApi haloRestApi = new HaloRestApiImpl(getBaseEndpoint());
    enqueueMockResponse("haloWeaponsResponse.json", 200);

    TestObserver<List<WeaponEntityResponse>> test = haloRestApi.getWeapons().test();
    test.awaitTerminalEvent();

    List<WeaponEntityResponse> entityResponseList = test.values().get(0);

    assertThatCampaignResponseIsPropertyParsed(entityResponseList);
  }

  private void assertThatCampaignResponseIsPropertyParsed(
      List<WeaponEntityResponse> entityResponseList) {
    assertThat(entityResponseList.size(), is(greaterThan(0)));

    WeaponEntityResponse entityResponse = entityResponseList.get(0);

    assertThat(entityResponse.getContentId(), is(notNullValue()));
    assertThat(entityResponse.getId(), is(notNullValue()));
    assertThat(entityResponse.getName(), is(notNullValue()));
    assertThat(entityResponse.getDescription(), is(notNullValue()));
    assertThat(entityResponse.getSmallIconImageUrl(), is(notNullValue()));
    assertThat(entityResponse.getLargeIconImageUrl(), is(notNullValue()));
    assertThat(entityResponse.isUsableByPlayer(), is(notNullValue()));
  }

  @Test public void shouldThatModelContainsExpectedValuesTest() throws IOException {
    HaloRestApi haloRestApi = new HaloRestApiImpl(getBaseEndpoint());
    enqueueMockResponse("haloWeaponsResponse.json", 200);

    TestObserver<List<WeaponEntityResponse>> test = haloRestApi.getWeapons().test();
    test.awaitTerminalEvent();

    List<WeaponEntityResponse> entityResponseList = test.values().get(0);

    assertThatModelContainsExpectedValuesTes(entityResponseList);
  }

  private void assertThatModelContainsExpectedValuesTes(
      List<WeaponEntityResponse> entityResponseList) {

    WeaponEntityResponse entityResponse = entityResponseList.get(0);

    assertThat(entityResponse.getContentId(), is("22cad0dc-8af0-44d2-8654-f80a0c231955"));
    assertThat(entityResponse.getId(), is("669296699"));
    assertThat(entityResponse.getName(), is("Sniper Rifle"));
    assertThat(entityResponse.getDescription(), is("Semi-automatic multi-role heavy rifle with variable-zoom 4x/9x optics. Best used at long range in conjunction with Smart-Link."));
    assertThat(entityResponse.getSmallIconImageUrl(), is("https://image.halocdn.com:443/?path=https%3a%2f%2fcontent.halocdn.com%2fmedia%2fDefault%2fgames%2fhalo-5-guardians%2ftools-of-destruction%2fweapons%2fsniper-rifle-b6d462a6c57d4297953d12e93e468053.png&width=332&hash=BiMAWO4c0GfjEiyp%2fYMyGApujlhorPHFr8tEr49q02Y%3d"));
    assertThat(entityResponse.getLargeIconImageUrl(), is("https://content.halocdn.com/media/Default/games/halo-5-guardians/tools-of-destruction/weapons/sniper-rifle-b6d462a6c57d4297953d12e93e468053.png"));
    assertThat(entityResponse.isUsableByPlayer(), is(true));
  }
}
