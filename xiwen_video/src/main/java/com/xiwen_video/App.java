package com.xiwen_video;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
* 启动类
* @author DONG
* @date 
* @version 
*/
@EnableSwagger2
//@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan("com.xiwen_video")
@MapperScan(basePackages = "com.*.mapper")
@EnableTransactionManagement
@ComponentScan(basePackages={"com.xiwen_video","com.xiwen_common.*"})  
@EnableCaching
public class App 
{
	private static Logger log = LoggerFactory.getLogger(App.class); 
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    	log.info("服务已启动！！！");
    }

	
    
//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
