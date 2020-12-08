package com.iu.sb4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.sb4.interceptor.CustomInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 적용할 Interceptor 등록
		registry.addInterceptor(customInterceptor)
		
		// Interceptor에서 사용할 URL 작성
		.addPathPatterns("/notice/**")
		//.addPathPatterns(patterns)
		
		//Interceptor에서 제외할 URL 작성
		.excludePathPatterns("/notice/noticeWrite");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
