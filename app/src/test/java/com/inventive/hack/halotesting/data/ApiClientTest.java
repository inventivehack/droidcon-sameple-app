/*
 *   Copyright (C) 2015 Karumi.
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.inventive.hack.halotesting.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;

public class ApiClientTest {

  protected static int RESPONSE_SUCCESS = 200;
  protected static int ERROR_RESPONSE = 400;
  protected static int ERROR_AUTHENTICATION = 401;
  protected static int ACCESS_DENIED = 403;
  protected static int NOT_FOUND = 404;

  private static final String FILE_ENCODING = "UTF-8";

  private MockWebServer server;

  @Before public void setUp() throws Exception {
    //MockitoAnnotations.initMocks(this);
    this.server = new MockWebServer();
    this.server.start();
  }

  @After public void tearDown() throws Exception {
    server.shutdown();
  }

  protected void enqueueMockResponse() throws IOException {
    enqueueMockResponse(RESPONSE_SUCCESS);
  }

  protected void enqueueMockResponse(int code) throws IOException {
    enqueueMockResponse(code, "{}");
  }

  protected void enqueueMockResponse(int code, String response) throws IOException {
    MockResponse mockResponse = new MockResponse();
    mockResponse.setResponseCode(code);
    mockResponse.setBody(response);
    server.enqueue(mockResponse);
  }

  protected void enqueueMockResponse(String fileName, int code) throws IOException {
    MockResponse mockResponse = new MockResponse();
    String fileContent = getContentFromFile(fileName);
    mockResponse.setResponseCode(code);
    mockResponse.setBody(fileContent);
    server.enqueue(mockResponse);
  }

  protected void assertRequestSentTo(String url) throws InterruptedException {
    RecordedRequest request = server.takeRequest();
    assertEquals(url, request.getPath());
  }

  protected void assertRequestSentToContains(String... paths) throws InterruptedException {
    RecordedRequest request = server.takeRequest();

    for (String path : paths) {
      Assert.assertThat(request.getPath(), containsString(path));
    }
  }

  protected String getBaseEndpoint() {
    return server.url("/inventive/").toString();
  }

  private String getContentFromFile(String fileName) throws IOException {

    fileName = getClass().getResource("/" + fileName).getFile();
    File file = new File(fileName);

    BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(new FileInputStream(file)));

    StringBuilder stringBuilder = new StringBuilder();

    String line = bufferedReader.readLine();

    while (line != null) {
      stringBuilder.append(line);
      line = bufferedReader.readLine();
    }

    bufferedReader.close();

    return stringBuilder.toString();
  }
}
