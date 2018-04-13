package com.yuzhou.async;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * 异步任务测试
 * 
 * @author zhangyuzhou
 *
 */
@Component
public class TestAsync {
//	@Async
	public Future<Boolean> doTask11() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(1000L);
		long end = System.currentTimeMillis();
		System.out.println("doTask1:" + (end - start) + "毫秒");
		return new AsyncResult<>(true);
	}

//	@Async
	public Future<Boolean> doTask22() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(700L);
		long end = System.currentTimeMillis();
		System.out.println("doTask2:" + (end - start) + "毫秒");
		return new AsyncResult<>(true);
	}

//	@Async
	public Future<Boolean> doTask33() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(600L);
		long end = System.currentTimeMillis();
		System.out.println("doTask3:" + (end - start) + "毫秒");
		return new AsyncResult<>(true);
	}

}
