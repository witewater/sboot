package com.ytd.sboot.controller;

import com.ytd.sboot.feign.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author ytd
 */
@RestController
public class FeignController {

    @Autowired
    UserFeignService userFeignService;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return userFeignService.sayHiFromClientOne(name);
    }

    @GetMapping("/loadInstance")
    public String loadInstance() {
        ServiceInstance choose = this.loadBalancerClient.choose("eureka-client-8802");
        System.out.println(choose.getServiceId()+":"+choose.getHost()+":"+choose.getPort());
        return choose.getServiceId() + ":" + choose.getHost() + ":" + choose.getPort();
    }

}
