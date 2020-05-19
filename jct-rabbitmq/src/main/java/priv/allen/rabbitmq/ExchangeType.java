/**
 * 
 */
package priv.allen.rabbitmq;

/**
 * @author Ma anjin 
 *
 */
public enum ExchangeType {
	
	/**
	 * 
	 */
	DIRECT,
	/**
	 * 
	 */
	FANOUT,
	/**
	 * 
	 */
	HEADERS,
	/**
	 * 
	 */
	TOPIC;
	
	/**
	 * @return String
	 */
	public String getName() {
		return this.toString().toLowerCase();
	}
}
