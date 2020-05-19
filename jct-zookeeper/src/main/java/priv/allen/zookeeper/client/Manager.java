package priv.allen.zookeeper.client;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

public class Manager {
	
	public static void main(String[] args) {
		try {
			ZooKeeper zk = new ZooKeeper("172.22.61.7:2181", 10000, null);
			List<String> nodes = zk.getChildren("/app", false);
			nodes.forEach(e -> System.out.println(e));
		} catch (IOException | KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
