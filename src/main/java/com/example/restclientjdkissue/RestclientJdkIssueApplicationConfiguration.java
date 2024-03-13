package com.example.restclientjdkissue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestclientJdkIssueApplicationConfiguration {

  private final MyProperties properties;

  public RestclientJdkIssueApplicationConfiguration(MyProperties properties) {
    this.properties = properties;
  }

  @Bean
  public RestClient restClient() {
    return RestClient.builder()
//        .requestFactory(new JdkClientHttpRequestFactory())
//        .requestFactory(new SimpleClientHttpRequestFactory())
        .baseUrl(properties.baseUrl())
        .build();
  }

  @Bean
  public HttpServiceProxyFactory httpServiceProxyFactory(RestClient restClient) {
    return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
        .build();
  }

  @Bean
  public MyApi myApi(HttpServiceProxyFactory httpServiceProxyFactory) {
    return httpServiceProxyFactory.createClient(MyApi.class);
  }
}
