package com.ruiclear.dispatcher;

import com.ruiclear.analysis.AnnotationAnalysis;
import com.ruiclear.analysis.PackageScanUtil;
import com.ruiclear.model.RequestMappingModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by RuiClear on 2018/1/29.
 */
public class MyDispatcherServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String packageName = "com.ruiclear.controller";
        List<String> list = PackageScanUtil.analysisAnotation(packageName);
        Map<String,RequestMappingModel> map = new HashMap<String, RequestMappingModel>();
        AnnotationAnalysis.annotationAnalysis(map,list);

        String url = req.getServletPath();
        RequestMappingModel model = map.get(url);

        invokeMethod(model,getRequstParamMap(req));


    }
    private void invokeMethod(RequestMappingModel model,Map<String,Object> map)  {
        try {
            Object object = model.getClazz().newInstance();
            Method method = model.getMethod();
            Object[] args = new Object[model.getParmMap().size()+model.getRestMap().size()];
            //装参数的map
            Map<String,Object> paramMap = model.getParmMap();
            //装REST参数的map
            Map<String,Object> restMap = model.getRestMap();
            if(paramMap.size()>0){
                for(Map.Entry<String,Object> entry:map.entrySet()){
                    if(paramMap.containsKey(entry.getKey())){
                        args[(Integer) paramMap.get(entry.getKey())] =entry.getValue();
                    }
                }
            }
            if(restMap.size()>0){
                for(Map.Entry<String,Object> entry:map.entrySet()){
                    if(restMap.containsKey(entry.getKey())){
                        args[(Integer) restMap.get(entry.getValue())] =entry.getValue();
                    }
                }
            }
            //参数类型转换
            for(int i=0;i<model.getTypes().length;i++){
                if(model.getTypes()[i].getSimpleName().equals("String"))
                    continue;
                if(model.getTypes()[i].getSimpleName().equals("Integer"))
                    args[i] = new Integer((String)args[i]);
                if(model.getTypes()[i].getSimpleName().equals("Double"))
                    args[i] = new Double((String)args[i]);
                if(model.getTypes()[i].getSimpleName().equals("Float"))
                    args[i] = new Float((String)args[i]);
            }

            if(args.length==0||args[0]==null)
                method.invoke(object,null);
            else {
                method.invoke(object, args);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private Map<String,Object> getRequstParamMap(HttpServletRequest req){
          Map<String,Object> map = new HashMap<String, Object>();
          Enumeration enumeration = req.getParameterNames();
          while(enumeration.hasMoreElements()){
              String next = (String) enumeration.nextElement();
              map.put(next,req.getParameter(next));
          }
          return map;
    }
}
