package com.example.springbootdemo.web;


import java.util.Random;

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
	public String index() throws Exception{
		ServiceInstance instance=client.getLocalServiceInstance();
		//让处理线程等待几秒钟
//		int sleepTime=new Random().nextInt(3000);
//		logger.info("sleepTime:"+sleepTime);
//		Thread.sleep(sleepTime);
//		/hello,hostzhangdeheng,service_id:springcloudDemo
		logger.info("/hello,host"+instance.getHost()+",service_id:"+instance.getServiceId());
		
		return "test hello world";
	}
}
