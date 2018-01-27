package com.ruiclear.annotation;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * controller扫描器，对controller包进行扫描。
 *
 * @author liuhaiming
 *
 */
public class ControllerScanner {
	private static final String[] SCAN_BASE_PACKAGE = {
			"com.ruiclear.controller"};

	public static void analysisControllerUriMapping(
			Map<String, MappingModel> map) {
		map.clear();

		for (String scanPackage : SCAN_BASE_PACKAGE) {
			List<String> clazzNameList = findControllerNameList(scanPackage);
			for (String clazz : clazzNameList) {
				try {
					analysis(clazz, map);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void analysis(String clazz, Map<String, MappingModel> map)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, Exception {
		System.out.println(clazz);
		//Logger.error("controller analysis class name is:" + clazz);
		Class<?> clz = Class.forName(clazz);
		MappingModel bean = null;

		JzRequestMapping mapping = null;
		String clzUri = "";
		if (!clz.isAnnotationPresent(JzController.class)) {
			return;
		} else if (clz.isAnnotationPresent(JzRequestMapping.class)) {
			mapping = clz.getAnnotation(JzRequestMapping.class);
			clzUri = mapping.value();
		}

		JzParam param = null;
		List<ParamModel> paramList = null;
		ParamModel paramModel = null;
		for (Method method : clz.getMethods()) {
			if (method.isAnnotationPresent(JzRequestMapping.class)) {
				mapping = method.getAnnotation(JzRequestMapping.class);
				bean = new MappingModel();
				bean.setUri(mapping.method() + clzUri + mapping.value());
				initViewUri(bean);

				bean.setCtrlClazz(clz);
				bean.setCtrlMethod(method);

				paramList = new ArrayList<ParamModel>();
				Annotation[][] annotations = method.getParameterAnnotations();
				Class<?>[] paramTypes = method.getParameterTypes();
				if (paramTypes.length != annotations.length) {
					throw new Exception("parameter size error!");
				}

				for (int idx = 0; idx < annotations.length; idx++) {
					paramModel = new ParamModel();
					paramModel.setParamClazz(paramTypes[idx]);

					if (annotations[idx].length > 0
							&& annotations[idx][0] instanceof JzParam) {
						param = (JzParam) annotations[idx][0];
						paramModel.setKey(param.value());

						if (param.clazz().length() > 0) {
							paramModel.setParamClazz(Class.forName(param
									.clazz()));
							if (param.paramType() == ParamModel.PARAM_TYPE_OBJ) {
								paramModel
										.setParamType(ParamModel.PARAM_TYPE_OBJ);
							} else {
								paramModel
										.setParamType(ParamModel.PARAM_TYPE_COLLECTION);
							}
						}
					}

					paramList.add(paramModel);

				}

				bean.setParamBeanList(paramList);

				if (!map.containsKey(bean.getUri())) {
					map.put(bean.getViewUri(), bean);
				} else {
					throw new RuntimeException(
							" has the same uri by controller, uri: "
									+ bean.getUri());
				}
			}
		}
	}

	private static void initViewUri(MappingModel bean) {
		String uri = bean.getUri();
		List<String> params = new ArrayList<String>();
		while (uri.indexOf("{") > 0) {
			params.add(uri.substring(uri.lastIndexOf("{") + 1,
					uri.lastIndexOf("}")));
			uri = uri.substring(0, uri.lastIndexOf("{") - 1);
		}

		for (int idx = 0; idx < params.size(); idx++) {
			uri += "/{*}";
		}

		bean.setViewUri(uri);
		bean.setUriParam(params);
	}

	private static List<String> findControllerNameList(String ScanPackage) {
		List<String> clsNameList = new ArrayList<String>();
		try {
			Enumeration<URL> urls = Thread.currentThread()
					.getContextClassLoader()
					.getResources(ScanPackage.replace(".", "/"));
			String packPrefix = Thread.currentThread().getContextClassLoader()
					.getResource("").getPath();
			if (System.getProperty("file.separator").equals("\\")) {
				packPrefix = packPrefix.substring(1).replace("\\", ".")
						.replace("/", ".");
			}

			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				File file = new File(url.getFile());
				for (File f : file.listFiles()) {
					clsNameList.addAll(findClazzList(ScanPackage, f));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return clsNameList;
	}

	private static List<String> findClazzList(String pkg, File file) {
		List<String> clzList = new ArrayList<String>();
		if (!file.isFile()) {
			for (File f : file.listFiles()) {
				clzList.addAll(findClazzList(pkg + "." + file.getName(), f));
			}
		} else if (file.getName().endsWith(".class")) {
			clzList.add(pkg
					+ "."
					+ file.getName().substring(0,
							file.getName().lastIndexOf(".")));
		}

		return clzList;
	}
}
