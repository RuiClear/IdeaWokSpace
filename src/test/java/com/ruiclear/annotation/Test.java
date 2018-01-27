package com.ruiclear.annotation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RuiClear on 2018/1/27.
 */
public class Test {
    public static void main(String[] args) {
        Map<String, MappingModel> map = new HashMap<String, MappingModel>();
        ControllerScanner.analysisControllerUriMapping(map);

       // PackageScanUtil.analysisAnotation("com.ruiclear.controller");
    }
}
