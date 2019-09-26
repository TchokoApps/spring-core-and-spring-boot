package com.tchokoapps.springboot.springcorespringmvc;

import com.tchokoapps.springboot.springcorespringmvc.services.ProductService;
import com.tchokoapps.springboot.springcorespringmvc.services.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class SpringCoreSpringMvcApplicationTests {

	@Test
	public void contextLoads() {
	}
}
