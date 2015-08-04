package io.sample.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

@Configuration
public class CustomConfiguration {

	@Bean
    public Md5PasswordEncoder createSOAPConfiguration(){
        return new Md5PasswordEncoder();
    }

}
