/**
 * 
 */
package priv.allen.rabbitmq.client;

import java.io.IOException;

import org.junit.Test;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import priv.allen.rabbitmq.ExchangeType;
import priv.allen.rabbitmq.conn.RabbitMQClient;

/**
 * @author Ma anjin 
 *
 */
public class ClientWithDirectExchange {
	
	/**
	 * 
	 */
	@Test
	public void testProducer() {
		try {
			Channel channel = RabbitMQClient.getNewChannel();
			channel.exchangeDeclare("directExchange", ExchangeType.TOPIC.getName()); //$NON-NLS-1$
			channel.queueDeclare("directQueue", true, false, false, null); //$NON-NLS-1$
			channel.queueBind("directQueue", "directExchange", "directMessage"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			String messageT = "Direct Message"; //$NON-NLS-1$
			
			int i = 0;
			while(true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String message = messageT + "-" + i; //$NON-NLS-1$
				channel.basicPublish("directExchange", "directQueue", null, message.getBytes("UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				System.out.println("Send Direct Message is:" + message); //$NON-NLS-1$
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testConsumer() {
		try {
			Channel channel = RabbitMQClient.getNewChannel();
//			channel.exchangeDeclare("directExchange", ExchangeType.DIRECT.getName()); //$NON-NLS-1$
//			channel.queueDeclare("directQueue", true, false, false, null); //$NON-NLS-1$
//			channel.queueBind("directQueue", "directExchange", "directMessage"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			
			channel.basicConsume("directMessage", true, new DefaultConsumer(channel){ //$NON-NLS-1$
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
					String message = new String(body);
					System.out.println("Get Message: " + message); //$NON-NLS-1$
				} 
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			
		}
	}

}
