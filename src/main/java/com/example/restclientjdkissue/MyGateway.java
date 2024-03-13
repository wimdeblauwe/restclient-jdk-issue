package com.example.restclientjdkissue;

import org.springframework.stereotype.Component;

@Component
public class MyGateway {

  private final MyApi api;

  public MyGateway(MyApi api) {
    this.api = api;
  }

  public void doSomething() {
    SomeResponse response = this.api.doSomething(new SomeRequest(16));
    System.out.println("response = " + response);
  }
}
