package com.rainierSoft.ribbonconsumer.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {
	@Resource
	RestTemplate restTemplate;
	@RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
	public String helloConsumer(){
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}
}
