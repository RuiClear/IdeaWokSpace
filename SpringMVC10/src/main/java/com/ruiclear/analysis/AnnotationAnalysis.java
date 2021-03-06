package com.ruiclear.analysis;

import com.ruiclear.annotation.JzParam;
import com.ruiclear.annotation.JzRequestMapping;
import com.ruiclear.model.RequestMappingModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RuiClear on 2018/1/27.
 * 基本思路是在系统启动时就解析注解并将所有信息装入一个Map<String,RequestMappingModel>中
 */
public class AnnotationAnalysis {
    public static void annotationAnalysis(Map<String,RequestMappingModel> map, List<String> list){
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
    //url解析
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
                model.setClazz(clazz);
                map.put(url,model);
            }
        }

    }
    //参数解析
    private static void paramAnalysis(Map<String,RequestMappingModel> map, Class clazz){
        try {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if(!method.isAnnotationPresent(JzRequestMapping.class)) return;
                for(Map.Entry<String,RequestMappingModel> entry:map.entrySet()) {
                    //由于map中url和method已经赋值所以这里需要找到对应method方法map进行参数赋值
                    if (method.equals(entry.getValue().getMethod())) {
                        Annotation[][] paramAnnotations = method.getParameterAnnotations();
                        //装参数的map
                        Map<String, Object> paramMap = new HashMap<String, Object>();
                        //装方法参数列表类型的list
                        List<Class> paramTypeList = new ArrayList<Class>();
                        for (int i = 0; i < paramAnnotations.length; i++) {
                            for (int j = 0; j < paramAnnotations[i].length; j++) {
                                //解析URL参数
                                if (paramAnnotations[i][j] instanceof JzParam) {
                                    paramMap.put(((JzParam) paramAnnotations[i][j]).value(), i);
                                }
                            }
                        }
                        entry.getValue().setParmMap(paramMap);
                        entry.getValue().setTypes(method.getParameterTypes());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
