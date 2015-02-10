package com.liker.sunday.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:applicationContext-shiro.xml", "file:src/main/webapp/WEB-INF/spring-mvc.xml"})
//@ActiveProfiles("development")
@ActiveProfiles("production")
public class AbstractContextControllerTests {

	@Autowired
	protected WebApplicationContext wac;

}
