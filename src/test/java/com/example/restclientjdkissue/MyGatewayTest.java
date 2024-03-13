package com.example.restclientjdkissue;

import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;

@WireMockTest
class MyGatewayTest {

  @Test
  void testDoSomething(WireMockRuntimeInfo runtimeInfo) {
    RestclientJdkIssueApplicationConfiguration configuration = new RestclientJdkIssueApplicationConfiguration(
        new MyProperties(runtimeInfo.getHttpBaseUrl()));
    MyGateway gateway = new MyGateway(configuration.myApi(configuration.httpServiceProxyFactory(configuration.restClient())));

    stubFor(put("/something")
        .willReturn(okJson("""
{
  "value": "foo"
}
""")));

    gateway.doSomething();
  }
}
