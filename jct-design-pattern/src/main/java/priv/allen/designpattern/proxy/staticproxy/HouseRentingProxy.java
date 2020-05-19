package priv.allen.designpattern.proxy.staticproxy;

import priv.allen.designpattern.proxy.HouseRenting;
import priv.allen.designpattern.proxy.IHouseRenting;

/**
 * 相当于租房时的中介，使用了静态代理</br>
 * 代理模式提供了一种间接访问目标对象的方式，可以通过代理对象来间接访问目标对象。</br>
 * 
 * 规则：
 * 1. 代理类和目标类都必须实现相同的接口
 * 2. 代理类持有目标类的一个实例, 在实例化时通过构造参数传递
 * 
 * 作用：</br>
 * 1. 可以隐藏目标对象</br>
 * 2. 可以扩展目标对象的功能，在目标对象原有的基础上增加新的功能(前拦截，后拦截), 提高代码重用</br>
 * 
 * 使用场景：</br>
 * 1. 希望在目标类的已有功能上增加一些前置或后置功能。
 * 
 * @author Anjin.Ma
 *
 */
public class HouseRentingProxy implements IHouseRenting {
	
	private IHouseRenting proxy;
	
	/**
	 * @param proxy 被代理的对象
	 */
	public HouseRentingProxy(IHouseRenting proxy) {
		this.proxy = proxy;
	}

	@Override
	public void rent() {
		// 增加前置方法
		before();
		proxy.rent();
		// 增加后置方法
		after();
	}
	
	protected void before() {
		System.out.println("Finding house..."); //$NON-NLS-1$
	}
	
	protected void after() {
		System.out.println("Paying money..."); //$NON-NLS-1$
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建被代理的对象
		HouseRenting target = new HouseRenting();
		// 创建代理类，代理target
		HouseRentingProxy proxy = new HouseRentingProxy(target);
		// 调用代理对象的方法
		proxy.rent();
	}

}
