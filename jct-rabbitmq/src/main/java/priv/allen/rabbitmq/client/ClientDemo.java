/**
 * 
 */
package priv.allen.rabbitmq.client;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * @author Ma anjin
 *
 */
public class ClientDemo {

	/**
	 * 
	 */
	@Test
	public void testProducer() {
		try {
			// 创建一个连接工厂 connection factory
			ConnectionFactory factory = new ConnectionFactory();

			// 设置rabbitmq-server服务IP地址
			factory.setHost("localhost"); //$NON-NLS-1$
			factory.setPort(5672);
			factory.setUsername("guest"); //$NON-NLS-1$
			factory.setPassword("guest"); //$NON-NLS-1$
			factory.setVirtualHost("/"); //$NON-NLS-1$

			// 得到 连接

			Connection connection = factory.newConnection();

			ExecutorService pool = Executors.newFixedThreadPool(20);
			for (int i = 0; i < 20; i++) {
				pool.execute(new MessageExecute(connection));
			}

			//connection.close();
			while(true) {
				
			}
		} catch (Exception e) {

		}
	}

	class MessageExecute implements Runnable {
		private Connection connection;

		public MessageExecute(Connection connection) {
			this.connection = connection;
		}

		public void run() {
			String name = Thread.currentThread().getName();
			try {
				// 创建 channel实例
				for (int i = 0; i < 400; i++) {
					long start = System.currentTimeMillis();
					Channel channel = connection.createChannel();
					System.out.println(name + " creating channel spent " + (System.currentTimeMillis() - start) + "ms");

					channel.queueDeclare("firstQueue", true, false, false, null); //$NON-NLS-1$
					String message = i + " :First Message"; //$NON-NLS-1$

					channel.basicPublish("", "firstQueue", null, message.getBytes()); //$NON-NLS-1$ //$NON-NLS-2$
//								System.out.println(i + " :Send Message is:'" + message + "'"); //$NON-NLS-1$ //$NON-NLS-2$
					channel.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	/**
	 * 
	 */
	@Test
	public void testConsumer() {
		try {
			// 创建一个连接工厂 connection factory
			ConnectionFactory factory = new ConnectionFactory();

			// 设置rabbitmq-server服务IP地址
			factory.setHost("localhost"); //$NON-NLS-1$
			factory.setPort(5672);
			factory.setUsername("guest"); //$NON-NLS-1$
			factory.setPassword("guest"); //$NON-NLS-1$
			factory.setVirtualHost("/"); //$NON-NLS-1$

			// 得到 连接
			Connection connection = factory.newConnection();
			// 创建 channel实例
			Channel channel = connection.createChannel();

			Consumer consumer = new DefaultConsumer(channel) {

				@Override
				public String getConsumerTag() {
					return "consumer1"; //$NON-NLS-1$
				}

				@Override
				public void handleConsumeOk(String consumerTag) {
					System.out.println(consumerTag + "have been consumed!"); //$NON-NLS-1$
				}

				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					String msg = new String(body);
					System.out.println(" Consumer have received '" + msg + "'"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			};

			channel.basicConsume("firstQueue", true, consumer); //$NON-NLS-1$

			channel.basicConsume("directQueue", consumer);
			System.out.println("更換 queue");

			channel.close();
			// connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
