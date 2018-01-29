package com.ruiclear.annotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RuiClear on 2018/1/27.
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException {
//        Map<String, MappingModel> map = new HashMap<String, MappingModel>();
//        ControllerScanner.analysisControllerUriMapping(map);

       // PackageScanUtil.analysisAnotation("com.ruiclear.controller");
        Method method = ParamModel.class.getMethod("setKey",String.class);
        Class[] clazz = method.getParameterTypes();
for(Class z:clazz){
    System.out.println(z);
}
    }
}
