package com.rainierSoft.ribbonconsumer.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.rainierSoft.ribbonconsumer.entity.User;

@Service
public class UserService {
	@Resource
	RestTemplate restTemplate;
	@CacheResult
	@HystrixCommand
	public User getUserById(@CacheKey("id") User user){//指定缓存的key
		return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class,user.getId());
	}
	//合并请求
	@HystrixCollapser(batchMethod="findAll",collapserProperties={
			@HystrixProperty(name="timerDelayInMilliseconds",value="100")
	})
	@HystrixCommand
	public List<User> findAll(List<Long> ids){
		return restTemplate.getForObject("http://USER-SERVICE/users?ids={1}", List.class,StringUtils.join(ids,","));
	}
}
