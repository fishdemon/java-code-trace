/**
 * 
 */
package priv.allen.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author Allen
 *
 */
public class ProxyDemo {
	
	private Object target;

	/**
	 * @param target 目标类
	 */
	public ProxyDemo(Object target) {
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
				around();
				try {
					// 调用目标类的方法，这才是真正的业务逻辑
					method.invoke(proxy, args);
					afterReturn();
				} catch (Exception e) {
					afterException();
				} finally{
					after();
					around();
				}
				
				return null;
			}
		});
	}
	
	// 在目标方法调用之前调用
	protected void before() {
		System.out.println("Execute before operation..."); //$NON-NLS-1$
	}
	
	// 在目标方法正常返回后调用
	protected void afterReturn() {
		System.out.println("Execute after return operation..."); //$NON-NLS-1$
	}
	
	// 在目标方法抛出错误时调用
	protected void afterException() {
		System.out.println("Execute after exception operation..."); //$NON-NLS-1$
	}
	
	// 在目标方法执行完后调用，无论是否正常返回
	protected void after() {
		System.out.println("Execute after operation..."); //$NON-NLS-1$
	}
	
	// 在目标方法调用之前，之后都调用，无论是否正常返回
	protected void around() {
		System.out.println("Execute around operation..."); //$NON-NLS-1$
	}

}
