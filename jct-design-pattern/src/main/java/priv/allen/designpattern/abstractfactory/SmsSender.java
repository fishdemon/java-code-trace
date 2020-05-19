/**
 * 
 */
package priv.allen.designpattern.abstractfactory;

/**
 * @author Allen 
 *
 */
class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("Sms Sender!"); //$NON-NLS-1$
	}

}
