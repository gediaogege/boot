package com.example.persist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.persist.mapper")
public class PersistApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistApplication.class, args);
	}

}
