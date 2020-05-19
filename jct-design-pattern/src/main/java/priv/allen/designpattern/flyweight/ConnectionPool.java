/**
 * 
 */
package priv.allen.designpattern.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 享元模式
 * 运用数据库连接池来获取数据库连接
 * 优势：
 * 1. 可以提高获取连接的效率, 不用每次都重新创建连接, 节省了数据创建连接的开销.
 * 2. 控制连接数, 以免连接过多造成崩溃
 * 3. 减少系统内存开销，不管有多少次访问数据库，都只是复用这20个连接
 * @author Ma anjin 
 *
 */
public class ConnectionPool {
	
	private Vector<Connection> pool;
	
	 /*公有属性*/  
	private String driverClassName = "com.mysql.jdbc.Driver";   //$NON-NLS-1$
    private String url = "jdbc:mysql://localhost:3306/test";   //$NON-NLS-1$
    private String username = "root";   //$NON-NLS-1$
    private String password = "123456";   //$NON-NLS-1$
    private int poolSize = 20;
    
	/**
	 * 
	 */
	public ConnectionPool() {
		pool = new Vector<>(poolSize);
		
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		for (int i = 0; i < poolSize; i++) {
			try {
				Connection con = DriverManager.getConnection(url, username, password);
				pool.add(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}  
	
	/**
	 * @param con
	 */
	public synchronized void release(Connection con) {
		pool.add(con);
	}
    
    /**
     * @return Connection
     */
    public synchronized Connection getConnection() {
    	if (pool.size() > 0) {
    		Connection con = pool.remove(0);
    		return con;
    	}
    	
    	return null;
    }
    
}
