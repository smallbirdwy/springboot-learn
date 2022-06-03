package com.spring.task.springbucks;

import com.spring.task.springbucks.model.Coffee;
import com.spring.task.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.spring.task.springbucks.mapper")
public class SpringbucksApplication implements ApplicationRunner {

	@Autowired
	CoffeeService coffeeService;
	public static void main(String[] args) {
		SpringApplication.run(SpringbucksApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		coffeeService.findAllCoffeeWithParam(1,2)
						.forEach(a ->log.info("coffee page info : {}",a));

		Coffee c = Coffee.builder().name("espresso")
				.price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
		int count = coffeeService.save(c);
		log.info("Save {} Coffee: {}", count, c);

		c = Coffee.builder().name("latte")
				.price(Money.of(CurrencyUnit.of("CNY"), 25.0)).build();
		count = coffeeService.save(c);
		log.info("Save {} Coffee: {}", count, c);

		c = coffeeService.findById(1L);
		log.info("Find Coffeeffee: {}", c);

		coffeeService.updateById(2L,Money.of(CurrencyUnit.of("CNY"), 50.0));
		c = coffeeService.findById(2L);
		log.info("after Update Find Coffeeffee: {}", c);

		coffeeService.deleteById(3L);
		c = coffeeService.findById(3L);
		log.info("after Delete Find Coffeeffee: {}", c);
	}

}
