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
    private Map<String,Object> map = new HashMap<String, Object>();

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

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public RequestMappingModel() {
    }
}
