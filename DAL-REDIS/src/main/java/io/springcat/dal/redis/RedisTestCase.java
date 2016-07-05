/**
 * 
 */
package io.springcat.dal.redis;

/**
 * @author adampeng
 *
 */
public class RedisTestCase {
	
	private static void testSetGet(){
		RedisUtil.set("test_key_1", "123123");
		System.out.println(RedisUtil.get("test_key_1"));
	}
	
	private static void testBigSet(){
		StringBuilder kb = new StringBuilder();
		for(int i = 0 ; i < 1024 ; i++){
			kb.append("a");
		}
		StringBuilder mb = new StringBuilder();
		for(int i = 0 ; i < 1024 ; i++){
			mb.append(kb);
		}
		
		String value = new String(mb);
		
		System.out.println(mb.length() + "b");
		
		long start = System.currentTimeMillis();
		RedisUtil.set("test_key_2", value);
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + " ms");
	}
	
	public static void main(String[] args) throws Exception{
//		testSetGet();
		for(int i = 0 ; i < 40 ; i++){
			testBigSet();
		}
	}

}
