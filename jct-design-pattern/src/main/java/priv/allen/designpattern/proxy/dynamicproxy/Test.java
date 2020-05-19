/**
 * 
 */
package priv.allen.designpattern.proxy.dynamicproxy;

import priv.allen.designpattern.proxy.HouseRenting;
import priv.allen.designpattern.proxy.IHouseRenting;

/**
 * @author Allen
 *
 */
public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 实例化被代理的类
		HouseRenting target = new HouseRenting();
		// 这一句是生成代理类的class文件，前提是你需要在工程根目录下创建com/sun/proxy目录，不然会报找不到路径的io异常  
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");  //$NON-NLS-1$ //$NON-NLS-2$
		IHouseRenting proxy = (IHouseRenting) (new HouseRentingDynamicProxy(target).getProxyInstance());
		proxy.rent();
		System.exit(0);
	}

}
