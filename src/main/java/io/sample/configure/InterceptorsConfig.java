package io.sample.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.sample.interceptors.OauthaInterceptor;
import io.sample.interceptors.SampleInterceptor;

@Configuration
@EnableWebMvc
public class InterceptorsConfig implements WebMvcConfigurer {

	@Autowired
	private OauthaInterceptor oauthaInterceptor;
	@Autowired
	private SampleInterceptor sampleInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(oauthaInterceptor);
        registry.addInterceptor(sampleInterceptor);
    }

}