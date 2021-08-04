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
		String user = null;
		if(context != null) {
			HttpServletRequest req = getHttpServletRequest();

			user = StringUtils.killWhitespace(req.getRemoteUser());
			if(user == null) {
				// assumes SiteMinder placed attribute name "sm_userid" in HTTP header
				user = StringUtils.killWhitespace(req.getHeader("sm_user"));
			}
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

		//get the servlet context
		ServletContext servletContext = (ServletContext) context.getMessageContext().get(javax.xml.ws.handler.MessageContext.SERVLET_CONTEXT);

		//get the WebApplicationContext
		WebApplicationContext webapplicationContext= WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

		//get the bean
		T bean = webapplicationContext.getBean(beanName, clazz);

		//return the bean
		return bean;
	}




}
