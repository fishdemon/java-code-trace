/**
 * 
 */
package priv.allen.rabbitmq.alarm;

import java.io.IOException;
import java.util.Random;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

import priv.allen.rabbitmq.conn.RabbitMQClient;

/**
 * @author Ma anjin 
 *
 */
public class AllConsumer {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Channel channel = RabbitMQClient.getNewChannel();
			
			channel.basicConsume(MachinProducure.QUEUE_NAME_CONNECT_ALARM, true, "All Consumer", new DefaultConsumer(channel){ //$NON-NLS-1$
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
					try {
						Thread.sleep(new Random().nextInt(10) * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(new String(body) + "] have been consumed by "+ consumerTag + " at " + System.currentTimeMillis()); //$NON-NLS-1$ //$NON-NLS-2$
				}
				
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			
		}
	}

}
