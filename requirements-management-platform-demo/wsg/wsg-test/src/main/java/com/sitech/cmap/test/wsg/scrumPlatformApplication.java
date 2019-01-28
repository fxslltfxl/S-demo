package com.sitech.cmap.test.wsg;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.sitech.cmap.fw.util.mq.annotation.EnableMessageQueue;
import com.sitech.fw.core.spring.boot.autoconfigure.FwSpringBootApplication;

//@EnableMessageQueue
@EnableDiscoveryClient
@EnableFeignClients
@FwSpringBootApplication
public class scrumPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(scrumPlatformApplication.class, args);
	}
}
