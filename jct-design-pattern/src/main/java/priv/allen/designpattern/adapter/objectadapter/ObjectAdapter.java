/**
 * 
 */
package priv.allen.designpattern.adapter.objectadapter;

import priv.allen.designpattern.adapter.Source;
import priv.allen.designpattern.adapter.classadapter.ITarget;

/**
 * 对象的适配器
 * 与类的适配器实现原理差不多，只是不继承源类，而是直接持有源类的实例
 * 
 * 场景：
 * 1. 当希望将一个对象转换为满足另一个接口的对象时
 * 
 * @author Ma anjin 
 *
 */
public class ObjectAdapter implements ITarget{
	
	private Source source;

	/**
	 * @param source
	 */
	public ObjectAdapter(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void operateSource1() {
		source.operateSource1();
	}

	@Override
	public void operateSource2() {
		source.operateSource2();
	}

	@Override
	public void operateTarget() {
		System.out.println("operate target"); //$NON-NLS-1$
	}

}
