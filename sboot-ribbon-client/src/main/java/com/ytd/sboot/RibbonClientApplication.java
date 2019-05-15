package com.ytd.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @EnableCircuitBreaker #开启断路器功能
 * @author ytd
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class RibbonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientApplication.class, args);
    }

    /**
     * @Description: 加入@LoadBalanced注解，就可以为RestTemplate加入负载均衡的能力
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
