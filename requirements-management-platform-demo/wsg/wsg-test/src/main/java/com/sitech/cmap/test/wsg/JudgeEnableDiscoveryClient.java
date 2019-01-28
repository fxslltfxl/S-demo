package com.sitech.cmap.test.wsg;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

/**
 * @program: iaas-adapter-service
 * @description: 控制Eureka注册类
 * @author: Mooker
 * @create: 2018-01-31 20:45
 **/
@Component
@ConditionalOnProperty(value = "eureka.status.open", matchIfMissing = false)
@EnableDiscoveryClient
public class JudgeEnableDiscoveryClient {

}
