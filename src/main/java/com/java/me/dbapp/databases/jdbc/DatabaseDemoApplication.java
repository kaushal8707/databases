package com.java.me.dbapp.databases.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;


//@SpringBootApplication
//@ComponentScan
public class DatabaseDemoApplication implements CommandLineRunner
 {
    private Logger LOGGER= LoggerFactory.getLogger(DatabaseDemoApplication.class);
	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {

		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		LOGGER.info("findAll()-> {}",personJdbcDao.findAll());
		LOGGER.info("findById()->, Id: 10002-> {}",personJdbcDao.findById(10002));
		LOGGER.info("deleteById()->, Id: 10002->, Number of Row Affected {}",personJdbcDao.daleteById(10002));
		LOGGER.info("insert into db()->{}",personJdbcDao.insertData(
				new Person(10004,"bharath","Bangalore",new Date())));
		LOGGER.info("update db()->{}",personJdbcDao.updateData(
				new Person(10003,"kanishk","Patna",new Date())));


	}


}
