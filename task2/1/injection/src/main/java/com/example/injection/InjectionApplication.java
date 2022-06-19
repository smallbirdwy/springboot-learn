package com.example.injection;

import com.example.injection.pojo.Person;
import com.example.injection.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class InjectionApplication implements ApplicationRunner
{

	public static void main(String[] args) {
		SpringApplication.run(InjectionApplication.class, args);
	}

	@Autowired
	Person person;

	@Autowired
	Student student;

	@Autowired
	RestTemplate restTemplate;
	@Override
	public void run(ApplicationArguments args) throws Exception {

		/*
		* 注解注入
		* */
		log.info("Person:{}:" + person);


		/*
		* java方式注入
		* */
		log.info("Student{}:" + student);

		/*
		* Xml方式注入
		* */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		log.info("Teacher{}:" + context.getBean("teacher"));


		/*
		* restTemplate
		* */
		ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:9090/coffee/1", String.class);
		log.info("forEntityBody = " + forEntity.getBody());


		/*
		* okhttp
		* */
		OkHttpClient httpClient = new OkHttpClient.Builder().build();
		Request request = new Request.Builder().url("http://localhost:9090/coffee/xml/1").get().build();
		Response response = httpClient.newCall(request).execute();
		System.out.println("response.body() = " + response.body().string());


	}
}
