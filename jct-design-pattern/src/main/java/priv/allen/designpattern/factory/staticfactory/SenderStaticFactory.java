/**
 * 
 */
package priv.allen.designpattern.factory.staticfactory;

import priv.allen.designpattern.factory.MailSender;
import priv.allen.designpattern.factory.Sender;
import priv.allen.designpattern.factory.SmsSender;

/**
 * 静态工厂模式
 * 将多个工厂模式的方法更改为static, 这样不需要实例化工厂类。
 * 一般都是用这种工厂模式！
 * @author Allen 
 *
 */
public class SenderStaticFactory {
	
	/**
	 * @return Sender
	 */
	public static Sender buildMailSender() {
		return new MailSender();
	}
	
	/**
	 * @return Sender
	 */
	public static Sender buildSmsSender() {
		return new SmsSender();
	}

}
