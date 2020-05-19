package priv.allen.javabase.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import priv.allen.javabase.proxy.AirTicketStation;

/**
 *  若类没有实现接口，就用不了jdk代理，这个时候我们可以选择 Cglib 代理
 * CGLIB（Code Generation Library），是一个强大的，高性能，高质量的Code生成类库，它可以在运行期扩展Java类与实现Java接口。
 * 
 * @author Allen
 *
 */
public class AirTicketCglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		try {
			// 前置方法
			System.out.println("AirTicketCglibProxy --> This is AirTicketProxy Cglib");
			proxy.invokeSuper(obj, args);
			// 后置方法
			System.out.println("AirTicketCglibProxy --> Is there anything else I can do for you?");
		} catch (Exception e) {
			// 错误方法
			System.out.println("AirTicketCglibProxy --> transaction is error");
		} finally {
			// 无论如何都执行的方法
			System.out.println("AirTicketCglibProxy --> completed!");
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(AirTicketStation.class);
		enhancer.setCallback(new AirTicketCglibProxy());
		// 直接代理类
		AirTicketStation ticket = (AirTicketStation) enhancer.create();
		ticket.consultPlaneTicket();
	}

}
