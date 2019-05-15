package com.ytd.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/loadInstance")
    public String loadInstance() {
        ServiceInstance choose = this.loadBalancerClient.choose("eureka-client-8802");
        System.out.println(choose.getServiceId()+":"+choose.getHost()+":"+choose.getPort());
        return choose.getServiceId() + ":" + choose.getHost() + ":" + choose.getPort();
    }

}