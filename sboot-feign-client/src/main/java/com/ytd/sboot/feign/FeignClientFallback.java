package com.ytd.sboot.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements FallbackFactory<UserFeignService> {
    @Override
    public UserFeignService create(Throwable throwable) {
        return new UserFeignService() {
            @Override
            public String sayHiFromClientOne(String name) {
                return "admin";
            }
        };
    }
}
