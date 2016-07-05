/**
 * 
 */
package org.DAL.ZK.leaderelection;

import org.DAL.ZK.Constants;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author adampeng
 *
 */
public class ClientFactory {
	
	public static CuratorFramework newClient(){
		
		/**
		 * 重试次数越多 等待重试时间越长（随机）， 1000,3 表示 基础等待重试时间1秒，最多重试3次
		 */
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		
		CuratorFramework client = CuratorFrameworkFactory.newClient(Constants.serverstring, retryPolicy);  
		return client;
	}

}
