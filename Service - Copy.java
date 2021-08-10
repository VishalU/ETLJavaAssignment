package com.deere.vt.nextgen.webservice;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.deere.dsfj.utility.StringUtils;


public class Service {
	@Resource
	WebServiceContext context;

	private static String MC_HTTP_SERVLETREQUEST = "transport.http.servletRequest";


	/**
	 * @return
	 */
	public String getAuthorizationID() {
		
		if(context != null) {
			HttpServletRequest req = getHttpServletRequest();

			user = StringUtils.killWhitespace(req.getRemoteUser());
		
		}
		return user;
	}

	/**
	 * @return
	 */
	protected HttpServletRequest getHttpServletRequest() {
		if(context == null) return null;
		HttpServletRequest req = (HttpServletRequest) context.getMessageContext().get(MC_HTTP_SERVLETREQUEST);
		return req;
	}

	protected <T> T getBean(String beanName, Class<T> clazz) {
		//check if context is null
		if(context == null){
			return null;
		}

		
		//return the bean
		return bean;
	}




}
