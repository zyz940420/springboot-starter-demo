package com.yuzhou.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yuzhou.util.JsonResult;

//@RestControllerAdvice
public class AjaxExceptionHandler {
	
//	@ExceptionHandler(value=Exception.class)
	public JsonResult defaultErrorHandler(HttpServletRequest request,Exception exception) {
		exception.printStackTrace();
		return JsonResult.errorException(exception.getMessage());
	}

}
