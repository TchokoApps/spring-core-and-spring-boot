package com.tchokoapps.springboot.springcorespringmvc.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.tchokoapps.springboot")
public class JpaIntegrationConfig {
}
