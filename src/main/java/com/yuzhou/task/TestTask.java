package com.yuzhou.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Scheduled(cron = "0 0 0/1 * * ? ")
	public void reportCurrentTime() {
		System.out.println("现在时间：" + sdf.format(new Date()));
	}

}
