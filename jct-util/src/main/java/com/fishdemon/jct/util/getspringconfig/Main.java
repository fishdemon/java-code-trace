package com.fishdemon.jct.util.getspringconfig;

import java.lang.annotation.Annotation;

import org.reflections.Reflections;

/**
 * 打印指定 package 下的所有注解
 * @author Anjin.Ma
 * @date 2019-7-9 17:09:35
 * 
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		new Reflections("org.springframework") //$NON-NLS-1$
		.getSubTypesOf(Annotation.class)
		.stream()
		.map(clazz -> clazz.getSimpleName())
		.sorted()
		.forEach(e -> {
			System.out.println("**@" +  e + "**"); //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

}
