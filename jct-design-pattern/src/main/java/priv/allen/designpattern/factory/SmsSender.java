/**
 * 
 */
package priv.allen.designpattern.factory;

/**
 * @author Allen 
 *
 */
public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("Sms Sender!"); //$NON-NLS-1$
	}

}
