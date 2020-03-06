package com.springframework.tr2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Tr2DemoApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Tr2DemoApplication.class, args);

//		for(String name : applicationContext.getBeanDefinitionNames()){
//			System.out.println(name + " - from class - " + applicationContext.getBean(name).getClass().toString());
//		}

		Restaurant restaurant = applicationContext.getBean(Restaurant.class);
//		System.out.println("from class - " + applicationContext.getBean(Restaurant.class).getClass().toString());
		restaurant.getHotDrink().prepareDrink();

	}

}
