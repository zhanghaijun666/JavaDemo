package com.zookeeper;

import java.io.IOException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author zhanghaijun
 */
public class Demo {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        // 创建一个与服务器的连接  
        ZooKeeper zk = new ZooKeeper("192.168.20.187:2181", 6000, new Watcher() {
            // 监控所有被触发的事件  
            /**
             * EventType: None NodeCreated NodeChildrenChanged NodeDataChanged
             * NodeDeleted
             */
            public void process(WatchedEvent event) {
                System.out.println("EVENT:" + event.getType());
            }
        });

        // 查看根节点  
        System.out.println("ls / => " + zk.getChildren("/", true));

        // 创建一个目录节点  
        if (zk.exists("/node", true) == null) {
            zk.create("/node", "this is a znode".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("create /node this is a znode");
            // 查看/node节点数据  
            System.out.println("get /node => " + new String(zk.getData("/node", false, null)));
            // 查看根节点  
            System.out.println("ls / => " + zk.getChildren("/", true));
        }

        // 创建一个子目录节点  
        if (zk.exists("/node/app1", true) == null) {
            zk.create("/node/app1", "this is app1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("create /node/app1 app1");
            // 查看node节点  
            System.out.println("ls /node => " + zk.getChildren("/node", true));
        }

        // 修改节点数据  
        if (zk.exists("/node", true) != null) {
            zk.setData("/node", "the data is changed".getBytes(), -1);
            // 查看/node节点数据  
            System.out.println("get /node => " + new String(zk.getData("/node", false, null)));
        }

        // 删除节点  
        if (zk.exists("/node/app1", true) != null) {
            zk.delete("/node/app1", -1);
            zk.delete("/node", -1);
            // 查看根节点  
            System.out.println("ls / => " + zk.getChildren("/", true));
        }
        // 关闭连接  
        zk.close();
    }
}
