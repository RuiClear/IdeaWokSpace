package com.ruiclear.springmvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RuiClear on 2018/1/27.
 */
public class RequestMappingModel {
    private String url;
    private Method method;
    private Map<String,Object> restMap = new HashMap<String, Object>();
    private Map<String,Object> parmMap = new HashMap<String, Object>();

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

    public void setParmMap(Map<String, Object> parmMap) {
        this.parmMap = parmMap;
    }

    public RequestMappingModel() {
    }

    public Map<String, Object> getRestMap() {
        return restMap;
    }

    public void setRestMap(Map<String, Object> restMap) {
        this.restMap = restMap;
    }
}
