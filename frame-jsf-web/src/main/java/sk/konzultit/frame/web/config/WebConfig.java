package sk.konzultit.frame.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import sk.konzultit.frame.service.config.ServiceConfig;
import sk.loveit.frame.persist.config.JpaConfig;

@Configuration
@Import(value = { JpaConfig.class, ServiceConfig.class, SecurityConfig.class})
@ComponentScan("sk.konzultit.frame.web")
public class WebConfig {
	
}
