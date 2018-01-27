package com.ruiclear.annotation;

import java.lang.reflect.Method;
import java.util.List;

public class MappingModel {
	private String uri = null;
	
	private String viewUri = null;
	
	private List<String> uriParam = null;
	
	private Class<?> ctrlClazz = null;
	
	private Method ctrlMethod = null;
	
	private List<ParamModel> paramBeanList = null;
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getViewUri() {
		return viewUri;
	}

	public void setViewUri(String viewUri) {
		this.viewUri = viewUri;
	}
	
	public List<String> getUriParam() {
		return uriParam;
	}

	public void setUriParam(List<String> uriParam) {
		this.uriParam = uriParam;
	}

	public Class<?> getCtrlClazz() {
		return ctrlClazz;
	}

	public void setCtrlClazz(Class<?> ctrlClazz) {
		this.ctrlClazz = ctrlClazz;
	}

	public Method getCtrlMethod() {
		return ctrlMethod;
	}

	public void setCtrlMethod(Method ctrlMethod) {
		this.ctrlMethod = ctrlMethod;
	}

	public List<ParamModel> getParamBeanList() {
		return paramBeanList;
	}

	public void setParamBeanList(List<ParamModel> paramBeanList) {
		this.paramBeanList = paramBeanList;
	}
}
