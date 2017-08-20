package com.rainierSoft.ribbonconsumer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Service
public class HelloService {
//	private final Logger logger=Logger.getLogger(getClass());
	@Resource
	RestTemplate restTemplate;
//	@CacheResult//该注解用来标记请求命令返回的结果应该被缓存，他必须与@HystrixCommand注解结合使用
	@HystrixCommand(fallbackMethod="helloFallback")
	public String helloService(){
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}
//	@HystrixCommand(fallbackMethod="helloFallback",commandKey="helloKey")
//	public String hello(){
//		long start=System.currentTimeMillis();
//		String result=restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
//		long end=System.currentTimeMillis();
//		logger.info("Spend time:"+(end-start));
//		return result;
//	}
	public String helloFallback(Throwable e){
		return e.getMessage();
	}
}
