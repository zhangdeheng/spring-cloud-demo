package com.example.springbootdemo.web;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	private final Logger logger=Logger.getLogger(getClass());
	@Resource 
	private DiscoveryClient client;
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String index(){
		ServiceInstance instance=client.getLocalServiceInstance();
//		/hello,hostzhangdeheng,service_id:springcloudDemo
		logger.info("/hello,host"+instance.getHost()+",service_id:"+instance.getServiceId());
		
		return "test hello world";
	}
}
