/**
 * 
 */
package priv.allen.designpattern.abstractfactory;

/**
 * @author Allen 
 *
 */
public class MailSenderFactory implements Factory {

	@Override
	public Sender build() {
		return new MailSender();
	}

}
