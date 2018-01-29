package com.ruiclear.analysis;

import com.ruiclear.annotation.JzController;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by RuiClear on 2018/1/27.
 */
public class PackageScanUtil {
    public static  List<String> analysisAnotation(String packages){
        if(packages==null||packages.length()<=0) return null;
        String[] packName = packages.split(",");
        List<String> list = new ArrayList<String>();
        for(String pack:packName){
             List<String> packList= findAllClassUnderPackage(pack);
            findJzControllerClass(packList);
            list.addAll(packList);
        }
        return list;
    }
    private static List<String> findAllClassUnderPackage(String packName){
        URL path = Thread.currentThread().getContextClassLoader().getResource(packName.replace(".","/"));
         File file = new File(path.getPath().substring(1));
        List<String> list =new  ArrayList<String>();
         File[] files =file.listFiles();
         for(File f:files){
             String className = f.getPath().substring(f.getPath().lastIndexOf("\\")+1,f.getPath().lastIndexOf("."));
             list.add(packName+"."+className);
         }
         return list;
    }
    private static void findJzControllerClass(List<String> list) {
        try {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                Class clazz = Class.forName(iterator.next());
                if(!clazz.isAnnotationPresent(JzController.class))
                    iterator.remove();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
