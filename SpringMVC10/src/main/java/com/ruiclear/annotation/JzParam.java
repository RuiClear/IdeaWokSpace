package com.ruiclear.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类似SpringMCVC的RequestParam注解
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JzParam {
	String value() default "";
	
	String clazz() default "";
	
	int paramType() default 1;
}
