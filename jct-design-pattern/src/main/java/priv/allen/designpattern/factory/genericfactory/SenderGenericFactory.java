/**
 * 
 */
package priv.allen.designpattern.factory.genericfactory;

import priv.allen.designpattern.factory.MailSender;
import priv.allen.designpattern.factory.Sender;
import priv.allen.designpattern.factory.SmsSender;

/**
 * 普通工厂方式
 * 建立一个工厂类，对实现了同一接口的多个实现类，根据所给的参数进行相应实例的创建。
 * 普通工厂类也需要实例化。
 * @author Allen
 *
 */
public class SenderGenericFactory {
	
	/**
	 * @param type
	 * @return Sender
	 */
	public Sender build(String type) {
		switch(type) {
			case "mail" :  //$NON-NLS-1$
				return new MailSender();
			case "sms" :  //$NON-NLS-1$
				return new SmsSender();
			default : 
				return null;
		}
	}

}
