package com.framework.web.ssh.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.framework.util.PagingBean;

public class BaseAction implements ServletRequestAware, ServletResponseAware, ServletContextAware {

	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public static final String SUCCESS = "success";

	protected String successResultValue;
	protected String jsonString;

	public BaseAction() {
		setSuccessResultValue("/frame/json/jsonString.jsp");
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.setResponse(response);
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.setRequest(request);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getSuccessResultValue() {
		return successResultValue;
	}

	public void setSuccessResultValue(String successResultValue) {
		this.successResultValue = successResultValue;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	protected PagingBean getInitPagingBean() {
		PagingBean pb = new PagingBean(0, 0);
		int page = Integer.valueOf(request.getParameter("page") == null ? Integer.valueOf(0)
				: Integer.parseInt(request.getParameter("page")));
		int rows = request.getParameter("rows") == null ? PagingBean.INIT_ROWS
				: Integer.parseInt(request.getParameter("rows"));
		pb.setPage(page);
		pb.setRows(rows);
		
		pb.setStartRows((page - 1) * rows);
		pb.setEndRows((page - 1) * rows + rows);
		return pb;
	}
	
	public String setMessage(String msg)
	  {
	    String a = "{success:true,'msg':'" + msg + "'}";
	    setJsonString(a);
	    return "success";
	  }

}
