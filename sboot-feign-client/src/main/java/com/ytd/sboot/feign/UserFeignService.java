package com.ytd.sboot.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client-8802",fallbackFactory = FeignClientFallback.class)
public interface UserFeignService {

    @RequestMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
