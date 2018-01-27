package com.ruiclear.annotation;


public class ParamModel {
	public static final int PARAM_TYPE_OBJ = 0;
	
	public static final int PARAM_TYPE_COLLECTION = 1;
	
	private String key = null;
	
	private Class<?> paramClazz = null;
	
	private int paramType = PARAM_TYPE_OBJ;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Class<?> getParamClazz() {
		return paramClazz;
	}

	public void setParamClazz(Class<?> paramClazz) {
		this.paramClazz = paramClazz;
	}

	public int getParamType() {
		return paramType;
	}

	public void setParamType(int paramType) {
		this.paramType = paramType;
	}
	
}
