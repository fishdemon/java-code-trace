package priv.allen.rabbitmq.conn;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.ExceptionHandler;
import com.rabbitmq.client.TopologyRecoveryException;

/**
 * @author Ma anjin 
 *
 */
public class RabbitMQClient {
	
	private static ConnectionFactory factory = new ConnectionFactory();
	private static Connection connection;
	
	static {
		factory.setHost("localhost"); //$NON-NLS-1$
        factory.setPort(5672);
        factory.setUsername("guest"); //$NON-NLS-1$
        factory.setPassword("guest"); //$NON-NLS-1$
        factory.setVirtualHost("/"); //$NON-NLS-1$
        
        try {
			connection = factory.newConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	private RabbitMQClient() {
		
	}
	
	/**
	 * @return Channel
	 * @throws IOException 
	 */
	public static Channel getNewChannel() throws IOException {
		return connection.createChannel();
	}

}
