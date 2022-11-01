package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.home.interceptor.StudyInterceptor;
import com.iu.home.interceptor.TestInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private TestInterceptor testInterceptor;
	@Autowired
	private StudyInterceptor studyInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(testInterceptor)
				.addPathPatterns("/qna/**")
				.addPathPatterns("/notice/**")
		
				.excludePathPatterns("/qna/datail")
				.excludePathPatterns("/qna/write");
		
		registry.addInterceptor(studyInterceptor)
				.addPathPatterns("/qna/**");
	}
	

}
