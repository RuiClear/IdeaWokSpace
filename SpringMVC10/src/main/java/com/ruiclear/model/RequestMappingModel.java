package com.ruiclear.model;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RuiClear on 2018/1/27.
 */
public class RequestMappingModel {
    private Class clazz;
    private String url;
    private Method method;
    private Map<String,Object> parmMap = new HashMap<String, Object>();
    private Class[] types;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Map<String, Object> getParmMap() {
        return parmMap;
    }

    public Class getClazz() {
        return clazz;
    }
    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
    public void setParmMap(Map<String, Object> parmMap) {
        this.parmMap = parmMap;
    }

    public RequestMappingModel() {
    }
    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
