package com.mypackage1.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Adding the @Component ANNOTATION to our Java class.(See comments in applicationContext.xml file).

/* @Component("thatSillyCoach") */

// Above, when Spring will scan this package(as mentioned in applicationContext.xml file), 
// it will find this class and after finding @Component("thatSillyCoach") it will automatically 
// register this bean with the Spring Container and it will use the bean ID of 'thatSillyCoach'.

// DEFAULT BEAN ID
// Above, if we didn't specify the EXPLICIT BEAN ID ("thatSikktCoach"), then Spring will use DEFAULT BEAN ID.
// The default Bean ID is the name of the class but it makes the first letter in small case.
// For e.g.- for our TennisCoach.java class, the Default Bean ID will be 'tennisCoach' (class name with small first letter).
// So we just have to specify just @Component (Not even brackets) like below.

@Component

// So, above as we have created the Component with specific Bean ID (i.e. tennisCoach), we have to use the same ID 
// while retrieving the bean in our AnnotationDemoApp.java file.

@Scope("singleton") // @Scope ANNOTATION. (See comments in AnnotationBeanScopeDemoApp class from line 31).

public class TennisCoach implements Coach {

	@Autowired 		// (We did this later) FIELD INJECTION with ANNOTATION. (See comments from line 78).
	@Qualifier("randomFortuneService") // (We did this later). @Qualifier ANNOTATION. (See comments from line 89)
	private FortuneService fortuneService;
	
	// CONSTRUCTOR INJECTION with ANNOTATION.
	// Creating a constructor for Constructor Injection.
	// Also we will CONFIGURE the Dependency Injection with @Autowired ANNOTATION instead
	// of doing it in configuration file.
	// So, Spring will scan for a component that implements FortuneService Interface (in our
	// case it is HappyFortuneService). So Spring will create instance of it and Inject it into 
	// our TennisCoach.
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/ //Commenting this constructor injection because below we are doing setter injection.
	   //Instead, we will define default constructor.
	
	// Defining a default constructor.
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// SETTER INJECTION with ANNOTATION.
	// Defining a Setter Method for Injection.
	// Also, configuring this Setter Method with @Autowired ANNOTATION.
	// So Spring will resolve dependency and will look for any class that implements FortuneService
	// (that is HappyFortuneService in our case).
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		fortuneService = theFortuneService;
	}
	*/ //Commenting this because we are using different method below for injection.
	
	// METHOD INJECTION with ANNOTATION.
	// There is no compulsion that we have to use only Setter Methods for dependency injection.
	// We can use ANY MEHTOD for Dependency Injection. We just have to give @Autowired ANNOTATION.
	/*
	@Autowired
	public void doSomeCrazytuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomeCrazytuff() method");
		fortuneService = theFortuneService;
	}
	*/ //Commenting this also because we can do FIELD INJECTION with ANNOTATION which does NOT 
	   // needs any setter method like above to set the field. Java does it automatically internally by 
	   // technology called Reflection.
	
	// FIELD INJECTION with ANNOTATION.
	// So now, we will give @Autowired ANNOTATION to the FoutuneService field where we declared it at 
	// the starting of this class (on line 32) and then there is no need to define any Autowired/Setter
	// Methods as before.
	// Note: FIELD INJECTION also works on private fields.
	
	
	// QUALIFIERS for DEPENDENCY INJECTION
	// So above, that was all for injecting dependency ONLY IF we have ONLY ONE implementation
	// of FortuneService Interface(i.e. HappyFortuneService). But what if we have multiple 
	// implementations of FortuneService Interface. In this case, it will throw NoUniqueBeanDefinitionException.
	// So, to tell Spring which implementation to use, we use @Qualifier ANNOTATION.
	// For e.g.- @Qualifier("happyFortuneService")
	// Here "happyFortuneService" is the Bean ID of the bean that we want to use. So "happyFortuneService"
	// is the Default name of the Component for 'HappyFortuneService' (as we are using @Component Annotation)
	// implementation of Interface.
	// We CAN APPLY @Qualifier Annotation TO ALL types of Injections i.e. Constructor Injection, 
	// Setter Injection Methods and Field Injection.
	
	// So to demonstrate it, we create other implementations of FortuneService Interface like RandomFortuneService,
	// DatabaseFortuneService, RESTFortuneService. 
	// (And we will not forget to add @Component to these newly created implementations so that it will 
	// create beans for us with default names).
	// And as we know default names will be same names as our implementation class with FIRST LETTER in SMALLCASE.
	// i.e. randomFortuneService, databaseFortuneService, RESTFortuneService.
	// Note: As written in above line, default bean name for RESTFortuneService will be the same
	//       RESTFortuneService. This is because when the FIRST TWO LETTERS OF CLASS NAME ARE SAME (i.e. RE..),
	//       then there will be NO CHANGE IN DEFAULT BEAN NAME.
	//       And of course if want to give it different name, we can give it like: @Component("anyName").
	// So, after doing this, we will still get the NoUniqueBeanDefinitionException because we have not yet 
	// specified @Qualifier Annotation to tell Spring which implementation to use from these 4 implementations.
	
	// So now, we write @Qualifier Annotation for our field definition at the starting
	// of the class. (on line 33).
	// We will write this @Qualifier Annotation just below @Autowired Annotation.
	
	// @Qualifier ANNOTATION With CONSTRUCTORS
	// When we use @Qualifier with Constructor, the SYNTAX IS DIFFERENT and TRICKY.
	// We have to place @Qualifier Annotation inside of the constructor arguments like:
	/*
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
	    System.out.println(">> TennisCoach: inside constructor using @Autowired and @Qualifier");
	    fortuneService = theFortuneService;
	}
	 */
	// As we are using @Qualifier Annotation with FIELD in this example, so need to worry about it with Constructor.
	
	
	// INJECT PROPERTIES USING JAVA ANNOTAIONS (@Value ANNOTATION).
	// We can inject values from a properties file using Annotations so that there is no need to 
	// hard code values in Java code.
	// So we have created one properties file (sport.properties) in src folder.
	// Now, we have to load the properties file in the xml configuration file(i.e. applicationContext.xml).
	// After loading properties file in configuration file (see applicationContext.xml file from line 30), 
	// we need to Inject the properties Values.
	
	
	// BEAN LIFECYCLE METHOD ANNOTATIONS
	// We use @PostConstruct and @PreDestroy Annotations for defining initialization method and destroy method.
	// We can apply these Annotations on any method. Method can be of any return type but mostly void because
	// if it returns anything the returned value will not be caught.
	// Method should be no-argument method.
	// @PostConstruct method will be called after constructor this class is called after creating a bean.
	// @PreDestroy method will be called before destroying the bean.
	// NOTE: For Java versions 9 or higher, we will encounter an error when using @PostConstruct and @PreDestroy 
	//       in our code. This is because javax.annotation has been removed from its default classpath for Java 9 
	//       or higher. To fix this, we download the javax.annotation-api-1.3.2.jar file from maven website and
	//       copy it to the lib folder of our project and also add it to our Java Build Path from Project Properties.
	// NOTE: @PreDestroy method DOES NOT get called for PROTOTYPE Scoped Beans.
	// define my init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartUpStuff()");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanUpStuff()");
	}
	
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	// getters for printing those values.
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
