/**
 * 
 */
package priv.allen.rabbitmq.alarm;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;

import priv.allen.rabbitmq.ExchangeType;
import priv.allen.rabbitmq.conn.RabbitMQClient;

/**
 * @author Ma anjin 
 *
 */
public class MachinProducure {
	
	private final static String CHANNEL_CONNECT = "connnectChannel"; //$NON-NLS-1$
	private final static String CHANNEL_EXCESS  = "excessChannel"; //$NON-NLS-1$
	private final static String CHANNEL_PATCH   = "patchChannel"; //$NON-NLS-1$
	
	private final static String EXCHANGE_NAME = "alarmExchange"; //$NON-NLS-1$
	
	public final static String QUEUE_NAME_CONNECT_ALARM = "connectAlarmQueue"; //$NON-NLS-1$
	public final static String QUEUE_NAME_CONNECT_ALARM1 = "connectAlarmQueue1"; //$NON-NLS-1$
	public final static String QUEUE_NAME_CONNECT_ALARM2 = "connectAlarmQueue2"; //$NON-NLS-1$
	public final static String QUEUE_NAME_EXCESS_ALARM  = "excessAlarmQueue"; //$NON-NLS-1$
	public final static String QUEUE_NAME_PATCH_ALARM   = "patchAlarmQueue"; //$NON-NLS-1$
	
	private final static String ROUTING_KEY_CONNECT_ALARM = "connectAlarmRoutingKey"; //$NON-NLS-1$
	private final static String ROUTING_KEY_CONNECT_ALARM1 = "connectAlarmRoutingKey1"; //$NON-NLS-1$
	private final static String ROUTING_KEY_CONNECT_ALARM2 = "connectAlarmRoutingKey2"; //$NON-NLS-1$
	private final static String ROUTING_KEY_EXCESS_ALARM  = "excessAlarmRoutingKey"; //$NON-NLS-1$
	private final static String ROUTING_KEY_PATCH_ALARM   = "patchAlarmRoutingKey"; //$NON-NLS-1$
	
	private final static String BINDING_KEY = "confirmRoutingKey"; //$NON-NLS-1$
	private final static Map<String, Channel> channels = new HashMap<String, Channel>();
	
	
	static {
		try {
			Channel channel = RabbitMQClient.getNewChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.TOPIC.getName(), true, false ,null);
			channel.queueDeclare(QUEUE_NAME_CONNECT_ALARM, true, false, false, null);
			channel.queueBind(QUEUE_NAME_CONNECT_ALARM, EXCHANGE_NAME, ROUTING_KEY_CONNECT_ALARM);
			channel.confirmSelect();
			channels.put(CHANNEL_CONNECT, channel);
			
			channel.queueDeclare(QUEUE_NAME_CONNECT_ALARM1, true, false, false, null);
			channel.queueBind(QUEUE_NAME_CONNECT_ALARM1, EXCHANGE_NAME, ROUTING_KEY_CONNECT_ALARM1);
			
			channel.queueDeclare(QUEUE_NAME_CONNECT_ALARM2, true, false, false, null);
			channel.queueBind(QUEUE_NAME_CONNECT_ALARM2, EXCHANGE_NAME, ROUTING_KEY_CONNECT_ALARM2);
			
			channel = RabbitMQClient.getNewChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.TOPIC.getName(), true, false ,null);
			channel.queueDeclare(QUEUE_NAME_EXCESS_ALARM, true, false, false, null);
			channel.queueBind(QUEUE_NAME_EXCESS_ALARM, EXCHANGE_NAME, ROUTING_KEY_EXCESS_ALARM);
			channel.confirmSelect();
			channels.put(CHANNEL_EXCESS, channel);
			
			channel = RabbitMQClient.getNewChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.TOPIC.getName(), true, false ,null);
			channel.queueDeclare(QUEUE_NAME_PATCH_ALARM, true, false, false, null);
			channel.queueBind(QUEUE_NAME_PATCH_ALARM, EXCHANGE_NAME, ROUTING_KEY_PATCH_ALARM);
			channel.confirmSelect();
			channels.put(CHANNEL_PATCH, channel);
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String connectErrorMsg = "connect error "; //$NON-NLS-1$
		int i = 0;
		while(true) {
			Instant sendTime = Instant.now();
			String msg = connectErrorMsg + i + " " + sendTime.toString(); //$NON-NLS-1$
			Channel channel = channels.get(CHANNEL_CONNECT);
			try {
				channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY_CONNECT_ALARM, null, msg.getBytes());
				long start = System.currentTimeMillis();
				channel.waitForConfirms();
				channel.addConfirmListener(new ConfirmListener() {
					public void handleNack(long deliveryTag, boolean multiple) throws IOException {
						System.out.println(deliveryTag + "  " + multiple + "  failed"); //$NON-NLS-1$ //$NON-NLS-2$
					}
					
					public void handleAck(long deliveryTag, boolean multiple) throws IOException {
						System.out.println(deliveryTag + "  " + multiple + "  success"); //$NON-NLS-1$ //$NON-NLS-2$
					}
				});
				System.out.println("wait for " + i + "  " +(System.currentTimeMillis() - start)  + "ms"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(new Random().nextInt(10) * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i++;
		}
	}
	
}
