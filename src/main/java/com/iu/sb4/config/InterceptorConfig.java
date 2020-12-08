package com.iu.sb4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.sb4.interceptor.CustomInterceptor;
import com.iu.sb4.interceptor.NoticeAdminInterceptor;
import com.iu.sb4.interceptor.NoticeMemberInterceptor;
import com.iu.sb4.interceptor.QnaAdminInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Autowired
	private NoticeMemberInterceptor noticeInterceptor;
	
	@Autowired
	private NoticeAdminInterceptor noticeAdminInterceptor; 
	
	@Autowired
	private QnaAdminInterceptor qnaAdminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 적용할 Interceptor 등록
		registry.addInterceptor(customInterceptor)
		// Interceptor에서 사용할 URL 작성
		.addPathPatterns("/notice/**")
		//.addPathPatterns(patterns)
		
		//Interceptor에서 제외할 URL 작성
		.excludePathPatterns("/notice/noticeWrite");
		
		registry.addInterceptor(noticeInterceptor)
		.addPathPatterns("/notice/noticeSelect")
		.addPathPatterns("/qna/qnaSelect")
		.addPathPatterns("/qna/qnaReply");
		
		registry.addInterceptor(noticeAdminInterceptor)
		.addPathPatterns("/notice/noticeWrite")
		.addPathPatterns("/notice/noticeDelete")
		.addPathPatterns("/notice/noticeUpdate");
		
		registry.addInterceptor(qnaAdminInterceptor)
		.addPathPatterns("/qna/qnaWrite")
		.addPathPatterns("/qna/qnaDelete")
		.addPathPatterns("/qna/qnaUpdate");
		
		

		
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
