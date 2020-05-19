package priv.allen.javabase.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import priv.allen.javabase.proxy.IPlaneTicket;

/**
 * JDK 代理是其实对接口的代理，也就是说只要有接口就可以生成新的代理类哦
 *  1. 若需要对实现类进行代理，代理类中必须引入目标实现类
 *  2. 若仅仅只是对接口代理，则不需要实现类
 * @author Allen
 *
 */
public class AirTicketProxy implements InvocationHandler {
	
	private Class<?> target;
	
	public AirTicketProxy(Class<?> target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			// 前置方法
			System.out.println("This is AirTicketProxy 1");
			method.invoke(target, args);
			// 后置方法
			System.out.println("Is there anything else I can do for you?");
		} catch (Exception e) {
			// 错误方法
			System.out.println("transaction is error");
		} finally {
			// 无论如何都执行的方法
			System.out.println("completed!");
		}
		
		return null;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> airTicketStation = Class.forName("priv.allen.javabase.proxy.AirTicketStation" , true, ClassLoader.getSystemClassLoader());
		IPlaneTicket ticket = (IPlaneTicket) Proxy.newProxyInstance(airTicketStation.getClassLoader(), airTicketStation.getInterfaces(), new AirTicketProxy(airTicketStation));
		ticket.sellPlaneTicket();
		
	}

}
