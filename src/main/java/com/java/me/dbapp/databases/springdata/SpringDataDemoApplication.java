package com.java.me.dbapp.databases.springdata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
@ComponentScan
public class SpringDataDemoApplication implements CommandLineRunner
 {
    private Logger LOGGER= LoggerFactory.getLogger(SpringDataDemoApplication.class);

	@Autowired
	PersonSpringDataRepository personJpaRepository;

	public static void main(String[] args) {

		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		LOGGER.info("In JPA findById()->, Id: 10002-> {}",personJpaRepository.findById(10002));
		LOGGER.info("insert ()->{}",personJpaRepository.save(new Persons("Prakash","Jamshedpur",new Date())));
		LOGGER.info("update ()->10003->{}",personJpaRepository.save(new Persons(10003,"hopohopo","Jamshedpur",new Date())));
		personJpaRepository.deleteById(10002);
		LOGGER.info("findAll Persons()->{}",personJpaRepository.findAll());

	}


}
