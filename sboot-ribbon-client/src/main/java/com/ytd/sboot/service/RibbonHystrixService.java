package com.ytd.sboot.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ytd.sboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     * @param id id
     * @return 通过id查询到的用户
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(Long id) {
        return this.restTemplate.getForObject("http://service-demo/" + id, User.class);
    }

    /**
     * hystrix fallback方法
     * @param id id
     * @return 默认的用户
     */
    public User fallback(Long id) {
        User user = new User();
        user.setId(1);
        user.setName("admin");
        return user;
    }

}
