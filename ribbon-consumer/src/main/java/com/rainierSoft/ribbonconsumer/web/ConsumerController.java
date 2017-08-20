package com.rainierSoft.ribbonconsumer.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rainierSoft.ribbonconsumer.service.HelloService;


@RestController
public class ConsumerController {
	@Resource
	HelloService helloService;
	@RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
	public String helloConsumer(){
		return helloService.helloService();
//		return helloService.hello();
	}
}
