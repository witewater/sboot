package com.ytd.sboothystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 访问地址 http://localhost:8030/hystrix
 * @author
 */
@SpringBootApplication
@EnableHystrixDashboard
public class SbootHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootHystrixDashboardApplication.class, args);
    }

}
