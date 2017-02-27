package com.inventive.hack.halotesting.data;

import com.inventive.hack.halotesting.common.data.cloud.ClientConstants;
import com.inventive.hack.halotesting.halo.data.cloud.HaloRestApi;
import com.inventive.hack.halotesting.halo.data.cloud.HaloRestApiImpl;
import com.inventive.hack.halotesting.halo.data.entity.CampaignEntityResponse;
import com.inventive.hack.halotesting.halo.data.entity.EnemyEntityResponse;
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

public class EnemiesApiClientTest extends ApiClientTest {

  @Test public void shouldRequestContainsCampaignPathTest()
      throws IOException, InterruptedException {
    HaloRestApi haloRestApi = new HaloRestApiImpl(getBaseEndpoint());
    enqueueMockResponse("haloEnemiesResponse.json", 200);

    TestObserver<List<EnemyEntityResponse>> test = haloRestApi.getEnemies().test();
    test.awaitTerminalEvent();

    assertRequestSentToContains(ClientConstants.EndPointApi.ENEMIES);
  }

  @Test public void shouldListModelContainsResponseTest() throws IOException {

    HaloRestApi haloRestApi = new HaloRestApiImpl(getBaseEndpoint());
    enqueueMockResponse("haloEnemiesResponse.json", 200);

    TestObserver<List<EnemyEntityResponse>> test = haloRestApi.getEnemies().test();
    test.awaitTerminalEvent();

    List<EnemyEntityResponse> entityResponseList = test.values().get(0);

    assertThatCampaignResponseIsPropertyParsed(entityResponseList);
  }

  private void assertThatCampaignResponseIsPropertyParsed(
      List<EnemyEntityResponse> entityResponseList) {
    assertThat(entityResponseList.size(), is(greaterThan(0)));

    EnemyEntityResponse entityResponse = entityResponseList.get(0);

    assertThat(entityResponse.getContentId(), is(notNullValue()));
    assertThat(entityResponse.getId(), is(notNullValue()));
    assertThat(entityResponse.getName(), is(notNullValue()));
    assertThat(entityResponse.getDescription(), is(notNullValue()));
    assertThat(entityResponse.getSmallIconImageUrl(), is(notNullValue()));
    assertThat(entityResponse.getLargeIconImageUrl(), is(notNullValue()));
    assertThat(entityResponse.getFaction(), is(notNullValue()));
  }

  @Test public void shouldThatModelContainsExpectedValuesTest() throws IOException {
    HaloRestApi haloRestApi = new HaloRestApiImpl(getBaseEndpoint());
    enqueueMockResponse("haloEnemiesResponse.json", 200);

    TestObserver<List<EnemyEntityResponse>> test = haloRestApi.getEnemies().test();
    test.awaitTerminalEvent();

    List<EnemyEntityResponse> entityResponseList = test.values().get(0);

    assertThatModelContainsExpectedValuesTes(entityResponseList);
  }

  private void assertThatModelContainsExpectedValuesTes(
      List<EnemyEntityResponse> entityResponseList) {

    EnemyEntityResponse entityResponse = entityResponseList.get(0);

    assertThat(entityResponse.getContentId(), is("12404a70-3c88-43c2-9500-ed8a5ab64dbe"));
    assertThat(entityResponse.getId(), is("2625192795"));
    assertThat(entityResponse.getName(), is("Grunt"));
    assertThat(entityResponse.getDescription(),
        is("Los Unggoy, designados por los Forerunner como Monachus Frigus (Latín: Monje Frío), son una especie bípeda de vertebrados que forman parte del Covenant."));
    assertThat(entityResponse.getSmallIconImageUrl(),
        is("https://content.halocdn.com/media/Default/games/halo-5-guardians/api/enemies/grunt-332x132-f2dfd3a39ba346918e61e0127a5d7190.png"));
    assertThat(entityResponse.getLargeIconImageUrl(),
        is("https://content.halocdn.com/media/Default/games/halo-5-guardians/api/enemies/grunt-542x305-e637c16cb8aa464c86f305c011803de3.png"));
    assertThat(entityResponse.getFaction(), is("Covenant"));
  }
}
