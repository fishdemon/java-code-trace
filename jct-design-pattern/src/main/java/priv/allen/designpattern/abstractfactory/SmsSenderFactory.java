/**
 * 
 */
package priv.allen.designpattern.abstractfactory;

/**
 * @author Ma anjin 
 *
 */
public class SmsSenderFactory implements Factory {

	@Override
	public Sender build() {
		return new SmsSender();
	}

}
