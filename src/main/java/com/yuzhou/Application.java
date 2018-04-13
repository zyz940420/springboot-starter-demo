package com.yuzhou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// mapper映射扫描包路径
@MapperScan(basePackages = "com.yuzhou.mapper")
// 自定义扫描范围
@ComponentScan(basePackages = { "com.yuzhou", "org.n3r.idworker" })
// 开启定时任务
@EnableScheduling
// 开启异步
@EnableAsync
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
