package com.wh.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class Master implements Watcher {

	ZooKeeper zk;
	String hostPort;
	
	Master(String hostPort){
		this.hostPort = hostPort;
	}
	
	void startZk() throws IOException{
		ZooKeeper zk = new ZooKeeper(hostPort, 15000, this);
	}
	
	@Override
	public void process(WatchedEvent event) {
		System.out.println(event);
	}
	
	void stopZK() throws InterruptedException{
		zk.close();
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Master m = new Master("192.168.137.100:2181");
		m.startZk();
		//wait for a bit
		Thread.sleep(60000);
		m.stopZK();
	}
}
