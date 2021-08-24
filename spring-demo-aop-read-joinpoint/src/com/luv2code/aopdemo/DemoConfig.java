package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Since we are using pure Java file (NO XML) for configuration.
@EnableAspectJAutoProxy // This will add Spring AOP Proxy Support.
@ComponentScan("com.luv2code.aopdemo") // This is for Component Scan for components and aspects.
public class DemoConfig {

}
