package com.yuzhou.async;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class DoAsyncTask {

	@Autowired
	private TestAsync testAsync;

	@RequestMapping("/test")
	public String testAsync() throws InterruptedException {
		long start = System.currentTimeMillis();
		Future<Boolean> task1 = testAsync.doTask11();
		Future<Boolean> task2 = testAsync.doTask22();
		Future<Boolean> task3 = testAsync.doTask33();

		while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
			if (task1.isDone() && task2.isDone() && task3.isDone()) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		return "执行完成：耗时-》" + (end - start) + "毫秒";
	}
}
