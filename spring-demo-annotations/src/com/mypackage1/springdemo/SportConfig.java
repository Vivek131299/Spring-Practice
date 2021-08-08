package com.mypackage1.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//// SPRING CONFIGURATION WITH JAVA CODE (NO XML) ////
// As we know, we can create beans in configuration xml file or second way is to annotate the 
// beans from Java file using @Component Annotations.
// But there is a Third way in which there is NO NEED OF XML FILE.
// We can directly Configure with Java code.
// We do this by using Annotations like @Configuration and @ComponentScan("package-name") to a class.
// @ComponentScan("package-name") scans the given package for scanning components(creating beans) like
// xml component scanning.
// So now, we do not need any configuration xml file for this.
// So we do not need to access the xml file in our main runnable class(JavaConfigDemoApp.java class) like 
// before like by using ClassPathXmlApplicationContext. Instead, we use AnnotationConfigApplicationContext.
// (See JavaConfigDemoApp from line 9).

@Configuration

/*@ComponentScan("com.mypackage1.springdemo")*/

// INJECTING VALUES FROM PROPERTIES FILE (sport.properties).
// We use @PropertySource("classpath:filename") Annotation for Loading properties file in Spring Config.
@PropertySource("classpath:sport.properties")
// Injecting Values from Properties file and
// REFERENCE VALUES FROM PROPERTIES FILE (See SwimCoach class from line 9).

public class SportConfig {
	
	/// DEFINING SPRING BEANS WITH JAVA CODE (@Bean ANNOTATION) ///
	// We can define a bean with @Bean Annotation to a method.
	// So, MANUALLY Defining Beans means we do not need to add @ComponentScan() Annotation at the beginning 
	// because we are defining the beans manually by using @Bean Annotation below.
	
	// define method to expose bean
	// manually define bean for our SadFortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	// NOTE: the method name (sadFortuneService) is the Bean ID that is while assigning it to the container.
	
	
	// define bean for our SwimCoach and Inject Dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	// Here, we are INJECTING DEPENDENCY (sadFortuneService) by passing the method 'sadFortuneService()' as
	// a parameter. So now we have injected sadFortuneService into our swimCoach Bean.
}
