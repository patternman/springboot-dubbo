package io.springcat.dal.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.exceptions.JedisConnectionException;


public class RedisUtil {
	
	private static JedisPool jedisPool;

	static{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMinIdle(100);
		config.setMaxIdle(200);
		config.setMaxTotal(200);
		config.setTestWhileIdle(true);
		config.setTimeBetweenEvictionRunsMillis(5000);
		jedisPool = new JedisPool(config,Constants.REDIS_IP,Constants.REDIS_PORT);
	}
	
	private static Jedis getInstance(){
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.auth("11222333");
			return jedis;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return getInstance(1);
		}
	}
	
	private static Jedis getInstance(int retries){
		if(retries >= 5){
			return new Jedis(Constants.REDIS_IP,Constants.REDIS_PORT);
		}
		try {
			return jedisPool.getResource();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return getInstance(++retries);
		}
	}
	
	public static void set(String key, String value){
		Jedis jedis = null;
		try {
			jedis = getInstance();
			jedis.set(key, value);
		} catch (JedisConnectionException e) {
			//  告警 + 临时队列缓存数据
		}finally{
			close(jedis);
		}
	}
	
	public static void batchSet(Map<String,String> batchMap){
		Jedis jedis = null;
		try {
			jedis = getInstance();
			Pipeline pipeline = jedis.pipelined();
			Map<String,Response<String>> resultMap = new HashMap<String,Response<String>>();
			for(Entry<String, String> entry : batchMap.entrySet()){
				 resultMap.put(entry.getKey(),pipeline.set(entry.getKey(), entry.getValue()));
			}
			pipeline.sync();
			
			for(Entry<String, Response<String>> entry : resultMap.entrySet()){
				Response<String> result = entry.getValue();
				System.out.println(result.get());
			}
			System.out.println();
			
		} catch (JedisConnectionException e) {
			//  告警 + 临时队列缓存数据
		}finally{
			close(jedis);
		}
	}
	
	public static String get(String key){
		/**
		 * 获取数据的接口不处理异常，由外层捕获并做异常处理
		 */
		Jedis jedis = null;
		try {
			jedis = getInstance();
			return jedis.get(key);
		} finally{
			close(jedis);
		}
	}
	
	/**
	 * 存对象（序列化）
	 * @param key
	 * @param obj
	 */
	public static void setObject(String key, Object obj){
		Jedis jedis = null;
		try {
			jedis = getInstance();
			jedis.set(key.getBytes(), SerializeUtil.serialize(obj));
		} catch (JedisConnectionException e) {
			//  告警 + 临时队列缓存数据
		}finally{
			close(jedis);
		}
	}
	
	/**
	 * 取对象（反序列化）
	 * @param key
	 * @return
	 */
	public static Object getObject(String key){
		/**
		 * 获取数据的接口不处理异常，由外层捕获并做异常处理
		 */
		Jedis jedis = null;
		try {
			jedis = getInstance();
			return SerializeUtil.deserialize(getInstance().get(key.getBytes()));
		} finally{
			close(jedis);
		}
	}
	
	/**
	 * 左边入队
	 * @param key
	 * @param values
	 */
	public static void lPush(String key, String... values){
		Jedis jedis = null;
		try {
			jedis = getInstance();
			jedis.lpush(key, values);
		} catch (JedisConnectionException e) {
			//  告警 + 临时队列缓存数据
		}finally{
			close(jedis);
		}
	}
	
	/**
	 * 右边阻塞出队（5秒循环阻塞，直到有数据为止）
	 * @param key
	 * @return
	 */
	public static String brpop(String key){
		/**
		 * 获取数据的接口不处理异常，由外层捕获并做异常处理
		 */
		Jedis jedis = null;
		try {
			jedis = getInstance();
			List<String> value = null;
			while(true){
				value = jedis.brpop(5, key);
				if(value == null){
					continue;
				}else{
					break;
				}
			}
			return value.get(1);
		} finally{
			close(jedis);
		}
	}
	
	/**
	 * 计数器，可做全局ID生成器
	 * @param key
	 * @return
	 */
	public static Long incr(String key){
		Jedis jedis = null;
		try {
			jedis = getInstance();
			return jedis.incr(key);
		} finally{
			close(jedis);
		}
	}
	
	/**
	 * 将jedis对象还给pool
	 * @param jedis
	 */
	private static void close(Jedis jedis){
		try {
			jedis.close();
		} catch (Exception e) {
			jedis = null;
		}
	}
	
}
