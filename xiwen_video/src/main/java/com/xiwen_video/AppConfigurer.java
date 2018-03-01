package com.xiwen_video;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xiwen_common.util.Interceptor;

@Configuration
public class AppConfigurer extends WebMvcConfigurerAdapter {

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new Interceptor()).addPathPatterns("/**").excludePathPatterns("/user/sendVerificationCode");
        super.addInterceptors(registry);
    }
}
