package sk.konzultit.frame.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("sk.konzultit.frame.service")
@EnableTransactionManagement
public class ServiceConfig {}
