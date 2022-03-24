package com.training.pms;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductappJwaAlstromApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductappJwaAlstromApplication.class, args);
		String allBeans[] = context.getBeanDefinitionNames();

		Arrays.sort(allBeans);

		for (String temp : allBeans) {
			System.out.println(temp);
		}
	}

}
