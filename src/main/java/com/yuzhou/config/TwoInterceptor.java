package com.yuzhou.config;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.yuzhou.util.JsonResult;
import com.yuzhou.util.JsonUtils;

public class TwoInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (true) {
			returnErrorResponse(response, JsonResult.errorMsg("被two拦截..."));
		}
		System.out.println("被two拦截。。。");
		return false;
	}

	private void returnErrorResponse(HttpServletResponse response, JsonResult result) throws IOException {
		OutputStream outputStream = null;
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/json");
			outputStream = response.getOutputStream();
			outputStream.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
			outputStream.flush();
		} catch (Exception e) {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
