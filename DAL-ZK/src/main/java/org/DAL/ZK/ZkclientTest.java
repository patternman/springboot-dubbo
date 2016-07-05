/**
 * 
 */
package org.DAL.ZK;


import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author adampeng
 *
 */
public class ZkclientTest {
	
	public static void main(String[] args) throws Exception{
		/**
		 * 重试次数越多 等待重试时间越长（随机）， 1000,3 表示 基础等待重试时间1秒，最多重试3次
		 */
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		
		CuratorFramework client = CuratorFrameworkFactory.
					newClient("192.168.43.88:22181", retryPolicy);
		client.start();
		//create /zk5 "zhongguoyidong"
//		client.create().forPath("/zk5","zhongguoyidong".getBytes());

		//get /zk5
		System.out.println(new String(client.getData().forPath("/zk5")));
		
		client.close();
	}

}
