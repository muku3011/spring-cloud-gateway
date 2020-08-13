package com.learn.spring.cloud.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class SimpleController {

	@GetMapping(value = "/get-data")
	public String getData(ServerHttpRequest request, ServerHttpResponse response) {
		System.out.println("Inside SC-MS1 getData method");
		HttpHeaders headers = request.getHeaders();
		
		headers.forEach((k,v)-> System.out.println(k + " : " + v));
		
		ResponseCookie.ResponseCookieBuilder builder = ResponseCookie.from("nt-ms1-cookie", "ntMs1CookieValue");
		ResponseCookie cookie = builder.build();
		response.addCookie(cookie);
		return "Hello from Reactive service one getData method!!";
	}
}