/**
 * 
 */
package priv.allen.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 优点：代理对象无需实现接口，与静态代理相比，免去了编写很多代理类的烦恼，同时增加方法也无需维护目标对象和代理对象，只需在事件处理器中对方法判断即可。
 * 缺点：代理对象不需要实现接口，但是目标对象一定要实现接口，否则无法实现JDK代理机制。
 * 
 * 使用场景：
 * 1. RPC(remote process call)框架
 * 2. Spring的AOP机制
 * 
 * @author Allen 
 *
 */
public class HouseRentingDynamicProxy {
	
	private Object target;

	/**
	 * @param target
	 */
	public HouseRentingDynamicProxy(Object target) {
		this.target = target;
	}
	
	/**
	 * @return Object
	 */
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				before();
				method.invoke(proxy, args);
				after();
				return null;
			}
		});
	}
	
	protected void before() {
		System.out.println("Finding house..."); //$NON-NLS-1$
	}
	
	protected void after() {
		System.out.println("Paying money..."); //$NON-NLS-1$
	}
	
}
