package com.ruiclear.springmvc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by RuiClear on 2018/1/27.
 */
public class AnnotationAnalysis {
    public static void annotationAnalysis(Map<String,RequestMappingModel> map,List<String> list){
        try {
            for (String className : list) {
                Class clazz = Class.forName(className);
                urlAnalysis(map,clazz);
                paramAnalysis(map,clazz);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void urlAnalysis(Map<String,RequestMappingModel> map, Class clazz){
        String classUrl = "";
        if(clazz.isAnnotationPresent(JzRequestMapping.class)){
            JzRequestMapping jrm = (JzRequestMapping)clazz.getAnnotation(JzRequestMapping.class);
            classUrl = jrm.value();
        }
        Method[] methods = clazz.getMethods();
        for(Method method :methods){
            if(method.isAnnotationPresent(JzRequestMapping.class)){
                RequestMappingModel model = new RequestMappingModel();
                model.setMethod(method);
                String methodUrl = ((JzRequestMapping)method.getAnnotation(JzRequestMapping.class)).value();
                //过滤REST风格的URL
                if(methodUrl.contains("{")&&methodUrl.contains("}")){
                    methodUrl = methodUrl.substring(0,methodUrl.indexOf("{")-1);
                }
                String url =classUrl+methodUrl;
                model.setUrl(url);
                map.put(url,model);
            }
        }

    }
    private static void paramAnalysis(Map<String,RequestMappingModel> map, Class clazz){
        try {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if(!method.isAnnotationPresent(JzRequestMapping.class)) return;
                for(Map.Entry<String,RequestMappingModel> entry:map.entrySet()) {
                    if (method == entry.getValue().getMethod()) {
                        Annotation[][] paramAnnotations = method.getParameterAnnotations();
                        Map<String, Object> paramMap = new HashMap<String, Object>();
                        Map<String, Object> restMap = new HashMap<String, Object>();
                        for (int i = 0; i < paramAnnotations.length; i++) {
                            for (int j = 0; j < paramAnnotations[i].length; j++) {
                                if (paramAnnotations[i][j] instanceof JzParam) {
                                    paramMap.put(((JzParam) paramAnnotations[i][j]).value(), i);
                                }
                                //解析REST风格的URL
                                if (paramAnnotations[i][j] instanceof JzPathVariable) {
                                    restMap.put(((JzPathVariable) paramAnnotations[i][j]).value(), i);
                                }
                            }
                        }
                        entry.getValue().setParmMap(paramMap);
                        entry.getValue().setRestMap(restMap);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
