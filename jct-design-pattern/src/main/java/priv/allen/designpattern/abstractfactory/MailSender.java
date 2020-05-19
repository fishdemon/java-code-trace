/**
 * 
 */
package priv.allen.designpattern.abstractfactory;

/**
 * @author Ma anjin 
 *
 */
class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("mail sender!"); //$NON-NLS-1$
	}

}
