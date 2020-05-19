package priv.allen.javabase.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import priv.allen.javabase.proxy.WorkorderDao;
import priv.allen.javabase.proxy.WorkorderEntity;

/**
 * 直接代理接口(模拟mybatis mapper代理机制)
 * 这种形式下并没real subject
 * @author Anjin.Ma
 * @param <T>
 */
public class DaoProxy<T> implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 获取类全限定名和方法名，即为statementId
		String name = method.getName();
		String statementId = method.getDeclaringClass().getName() + "." + name;
		
		// 获取参数类型/参数值   
		// mybatis一般使用单参数，多参数的两种用法：1.利用参数args下标     2.参数注解
		Parameter[] params = method.getParameters();
		for (Parameter param:params) {
			System.out.print(param.getName());
			System.out.println("\t" + param.getType().getName());
		}
		
		for (Object arg:args) {
			System.out.println(arg);
		}
		
		System.out.println("execute: " + statementId);

		Type returnType = method.getGenericReturnType();
		String returnTypeName = returnType.getTypeName();
		Class<?> returnClass = getClass().getClassLoader().loadClass(returnTypeName);
		Object returnInstance = returnClass.newInstance();
		
		return returnInstance;
	}
	
	public static Object newInstance() {
		DaoProxy<?> mapperProxy = new DaoProxy<>();
		return Proxy.newProxyInstance(WorkorderDao.class.getClassLoader(), new Class[] {WorkorderDao.class}, mapperProxy);
	}

	public static void main(String[] args) {
		WorkorderDao workorderDao = (WorkorderDao) newInstance();
		try {
			WorkorderEntity res = workorderDao.listWorkorderById(1);
			System.out.println("res: " + res.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
