package com.yuzhou.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.yuzhou.util.JsonResult;

@RestControllerAdvice
public class MyExceptionHandler {
	public static final String ERROR_VIEW = "error";

	// @ExceptionHandler(value = Exception.class)
	// public Object errorHandler(HttpServletRequest request, HttpServletResponse
	// response, Exception e) {
	// e.printStackTrace();
	// ModelAndView modelAndView = new ModelAndView();
	// modelAndView.addObject("exception", e);
	// modelAndView.addObject("url", request.getRequestURI());
	// modelAndView.setViewName(ERROR_VIEW);
	// return modelAndView;
	// }

	@ExceptionHandler(value = Exception.class)
	public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		e.printStackTrace();
		if (isAjax(request)) {
			return JsonResult.errorException(e.getMessage());
		} else {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("exception", e);
			modelAndView.addObject("url", request.getRequestURI());
			modelAndView.setViewName(ERROR_VIEW);
			return modelAndView;
		}
	}

	public static boolean isAjax(HttpServletRequest httpRequest) {
		return (httpRequest.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
	}
}
