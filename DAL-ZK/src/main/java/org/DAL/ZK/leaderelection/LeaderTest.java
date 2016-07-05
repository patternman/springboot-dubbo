package org.DAL.ZK.leaderelection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.utils.CloseableUtils;


import com.google.common.collect.Lists;

public class LeaderTest {
	
	public static void main(String[] args) {  
        List<CuratorFramework> clients = Lists.newArrayList();  
        List<LeaderSelectorClient> examples = Lists.newArrayList();  
        try {  
            for (int i = 0; i < 10; i++) {  
                CuratorFramework client = ClientFactory.newClient();  
                LeaderSelectorClient example = new LeaderSelectorClient(client, "Client #" + i);  
                clients.add(client);  
                examples.add(example);  
  
                client.start();  
                example.start();  
            }  
  
            System.out.println("----------先观察一会选举的结果-----------");  
            Thread.sleep(10000);  
  
            System.out.println("----------关闭前5个客户端，再观察选举的结果-----------");  
            for (int i = 0; i < 5; i++) {  
                clients.get(i).close();  
            }  
  
            new BufferedReader(new InputStreamReader(System.in)).readLine();  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            for (LeaderSelectorClient exampleClient : examples) {  
                CloseableUtils.closeQuietly(exampleClient);  
            }  
            for (CuratorFramework client : clients) {  
                CloseableUtils.closeQuietly(client);  
            }  
        }  
    }  

}
