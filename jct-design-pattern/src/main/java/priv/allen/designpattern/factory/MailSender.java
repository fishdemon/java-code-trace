/**
 * 
 */
package priv.allen.designpattern.factory;

/**
 * @author Ma anjin 
 *
 */
public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("mail sender!"); //$NON-NLS-1$
	}

}
