package com.hwh.kfr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;


@MapperScan("com.hwh.kfr.dao")
@EnableCaching
@SpringBootApplication
//@EnableConfigurationProperties
public class KfrApplication {


	public static void main(String[] args) {
		SpringApplication.run(KfrApplication.class, args);
	}

}
