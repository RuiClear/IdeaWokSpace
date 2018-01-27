package com.ruiclear.springmvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RuiClear on 2018/1/27.
 */
public class RequestMappingAnalysisUtil {
    public static void annotationAnalysis(Map<String,RequestMappingModel> map,List<String> list){
        try {
            for (String className : list) {
                Class clazz = Class.forName(className);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void urlAnalysis(Map<String,RequestMappingModel> map, Class clazz){
        String classUrl = "";
        if(clazz.isAnnotationPresent(JzRequestMapping.class)){
            JzRequestMapping jrm = (JzRequestMapping)clazz.getAnnotation(JzRequestMapping.class);
            classUrl = jrm.value();
        }
        Method[] methods = clazz.getMethods();
        for(Method method :methods){
            if(method.isAnnotationPresent(JzRequestMapping.class)){
                RequestMappingModel model = new RequestMappingModel();
                String url =classUrl+((JzRequestMapping)method.getAnnotation(JzRequestMapping.class)).value();
                model.setUrl(url);
                map.put(url,model);
            }
        }

    }
}
