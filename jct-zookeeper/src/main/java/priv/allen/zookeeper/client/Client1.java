package priv.allen.zookeeper.client;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

public class Client1 {
	
	private static final String nodeName = "Client1";
	
	public static void main(String[] args) {
		try {
			ZooKeeper zk = new ZooKeeper("172.22.61.7:2181", 10000, new Watcher() {
				@Override
				public void process(WatchedEvent event) {
					System.out.println(nodeName + " --> 已经触发了" + event.getType() + "事件, 发生的path为 " + event.getPath() + " , error为 " + event.getState().toString());
					switch(event.getType().getIntValue()) {
						case -1:
							break;
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						default:
							break;
					}
					System.out.println(nodeName + " --> 已经触发了" + event.getType() + "事件！");
				}

			});
			
			List<String> apps = zk.getChildren("/", false);
			if (!apps.contains("app")) {
				zk.create("/app", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
			
			// 创建一个目录节点
			zk.create("/app/" + nodeName, null, Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			
			List<String> clients = zk.getChildren("/app", new Watcher() {
				@Override
				public void process(WatchedEvent event) {
					System.out.println(nodeName + " --> 已经触发了" + event.getType() + "事件, 发生的path为 " + event.getPath() + " , error为 " + event.getState().toString());
				}
			});
			
			while(true) {
				
			}
		} catch (IOException | KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private void handleNodeDeleted(WatchedEvent event) {
		
	}

}
