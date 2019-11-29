package com.hwh.kfr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@MapperScan("com.hwh.kfr.dao")
@EnableCaching
@SpringBootApplication
public class KfrApplication {

	//测试新电脑git

	public static void main(String[] args) {
		SpringApplication.run(KfrApplication.class, args);
	}

	/**
	 * 使用@Async 需要注意业务逻辑 因为是异步 所以执行到有@Async的时候会另开一条线程
	 * 并且当前线程会继续执行下去不会等待 所以有可能会出现Null point异常
	 * @return
	 */
	@Bean("taskExecutor")
	public TaskExecutor executor(){
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setThreadNamePrefix("task");
		threadPoolTaskExecutor.setCorePoolSize(10);
		threadPoolTaskExecutor.setMaxPoolSize(20);
		threadPoolTaskExecutor.setQueueCapacity(100);
		threadPoolTaskExecutor.setKeepAliveSeconds(60);
		threadPoolTaskExecutor.afterPropertiesSet();
		return threadPoolTaskExecutor;
	}
}
