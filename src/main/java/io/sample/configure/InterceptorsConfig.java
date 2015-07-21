package io.sample.configure;

import io.sample.interceptors.OauthaInterceptor;
import io.sample.interceptors.SampleInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class InterceptorsConfig extends WebMvcConfigurerAdapter {

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