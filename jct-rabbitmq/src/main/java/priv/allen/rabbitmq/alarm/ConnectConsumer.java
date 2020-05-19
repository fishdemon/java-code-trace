/**
 * 
 */
package priv.allen.rabbitmq.alarm;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import priv.allen.rabbitmq.conn.RabbitMQClient;

/**
 * @author Ma anjin 
 *
 */
public class ConnectConsumer {
	
	/**
	 * 
	 */
	@Test
	public void testNotAutoAck() {
		try {
			Channel channel = RabbitMQClient.getNewChannel();
			
			channel.basicConsume(MachinProducure.QUEUE_NAME_CONNECT_ALARM, false, "Connect Consumer", new DefaultConsumer(channel){ //$NON-NLS-1$
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
					try {
						Thread.sleep(new Random().nextInt(10) * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(new String(body) + "] have been consumed by "+ consumerTag + " at " + System.currentTimeMillis()); //$NON-NLS-1$ //$NON-NLS-2$
					
					// 手动确认
					// this.getChannel().basicAck(envelope.getDeliveryTag(), true);
				}
				
			});
			
			while(true) {
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			
		}
		
	}
	
	static class QueueConsumer implements Consumer {
		/** Channel that this consumer is associated with. */
	    private final Channel _channel;
	    /** Consumer tag for this consumer. */
	    private volatile String _consumerTag;
	    private Set<Consumer> consumers = new HashSet<Consumer>();
	    
		public QueueConsumer(Channel _channel) {
			this._channel = _channel;
		}

		public void handleConsumeOk(String consumerTag) {
			this._consumerTag = consumerTag;
		}

		public void handleCancelOk(String consumerTag) {
			
			
		}

		public void handleCancel(String consumerTag) throws IOException {
			
			
		}

		public void handleDelivery(String arg0, Envelope arg1, BasicProperties arg2, byte[] arg3) throws IOException {
		}
		
		public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
			
			
		}

		public void handleRecoverOk(String consumerTag) {
			
			
		}
		
		public boolean addConsumer(Consumer consumer) {
			return consumers.add(consumer);
		}
		
		public boolean delConsumer(Consumer consumer) {
			if (consumers.contains(consumer)) {
				return consumers.remove(consumer);
			}
			return false;
		}
		
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Channel channel = RabbitMQClient.getNewChannel();
			
			channel.basicConsume(MachinProducure.QUEUE_NAME_CONNECT_ALARM, true, "Connect Consumer", new DefaultConsumer(channel){ //$NON-NLS-1$
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
