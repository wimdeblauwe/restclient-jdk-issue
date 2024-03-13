package com.example.restclientjdkissue;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PutExchange;

public interface MyApi {

  @PutExchange("/something")
  SomeResponse doSomething(@RequestBody SomeRequest request);
}
