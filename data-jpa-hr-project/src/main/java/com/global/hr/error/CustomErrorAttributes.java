package com.global.hr.error;

import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.webmvc.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes{

	@Override
	public Map<String, @Nullable Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		Map <String,Object> errorAttributes = super.getErrorAttributes(webRequest, options);
		
		errorAttributes.put("locale", webRequest.getLocale().toString());
		errorAttributes.put("exception", errorAttributes.get("message"));
		errorAttributes.put("status", errorAttributes.get("error"));
		errorAttributes.remove("error");
		
		
		return errorAttributes;
	}

}
