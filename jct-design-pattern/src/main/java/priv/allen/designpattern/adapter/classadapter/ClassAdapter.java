/**
 * 
 */
package priv.allen.designpattern.adapter.classadapter;

import priv.allen.designpattern.adapter.Source;

/**
 * 类的适配器</br>
 * 核心思想：</br>
 *    创建一个包含源类和目标类所有方法的接口，然后适配器类实现该接口，并集成源类</br>
 *   
 * 作用：</br>
 *    将某个类的接口转化为客户端期望的另一个接口表示</br>
 *    为了消除由于接口不匹配造成的类兼容性问题</br>
 * 
 * 场景：</br>
 * 1. 需要将一个类 转换成 满足 <b>另一个新接口</b> 的类</br>
 * 
 * @author Ma anjin 
 *
 */
public class ClassAdapter extends Source implements ITarget{

	@Override
	public void operateTarget() {
		System.out.println("operate target"); //$NON-NLS-1$
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassAdapter target = new ClassAdapter();
		target.operateSource1();
		target.operateSource2();
		target.operateTarget();
	}

}
