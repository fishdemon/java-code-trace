/**
 * 
 */
package priv.allen.designpattern.factory.multiplefactory;

import priv.allen.designpattern.factory.MailSender;
import priv.allen.designpattern.factory.Sender;
import priv.allen.designpattern.factory.SmsSender;

/**
 * 多个工厂模式
 * 对普通工厂模式的改进，去掉普通工厂模式中的参数传递，因为字符串有出错的危险。
 * 对多个实现分别提供多个方法。
 * @author Allen 
 *
 */
public class SenderMultipleFactory {
	
	/**
	 * @return Sender
	 */
	public Sender buildMailSender() {
		return new MailSender();
	}
	
	/**
	 * @return Sender
	 */
	public Sender buildSmsSender() {
		return new SmsSender();
	}

}
