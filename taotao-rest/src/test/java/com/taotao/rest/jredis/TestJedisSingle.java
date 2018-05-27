package com.taotao.rest.jredis;

import java.io.IOException;
import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class TestJedisSingle {
	
	private static final String JedisCluster = null;

	@Test
	public void JeidsSingle() {
		//创建jedis对象 
		Jedis jedis = new Jedis("192.168.137.100", 6379);
		//调用jredis对象的方法
		jedis.set("key01", "jedistest");
		String jedisTest = jedis.get("key01");
		System.out.println(jedisTest);
		//关闭jedis
		jedis.close();
	}
	
	/**
	 * 使用连接池
	 */
	@Test
	public void jedisPool() {
		//创建连接池
		JedisPool jedisPool = new JedisPool("192.168.137.100", 6379);
		//从连接池中取出对象
		Jedis jedis = jedisPool.getResource();
		String testJedisPool = jedis.get("a");
		System.out.println(testJedisPool);
		//关闭jedis对象
		jedis.close();
		//关闭jedisPool连接池
		jedisPool.close();
	}
	
	/**
	 * 集群版redis测试
	 */
	@Test
	public void jedisClusterTest(){
		try {
			HashSet<HostAndPort> nodes = new HashSet<>();
			nodes.add(new HostAndPort("192.168.137.100", 7001));
			nodes.add(new HostAndPort("192.168.137.100", 7002));
			nodes.add(new HostAndPort("192.168.137.100", 7003));
			nodes.add(new HostAndPort("192.168.137.100", 7004));
			nodes.add(new HostAndPort("192.168.137.100", 7005));
			nodes.add(new HostAndPort("192.168.137.100", 7006));
			JedisCluster cluster = new JedisCluster(nodes);
			cluster.set("testCluster", "hello");
			String result = cluster.get("testCluster");
			System.out.println(result);
			cluster.close();
		} catch (Exception e) {
			System.out.println("excepiton");
		}
	}
	
	/**
	 * 整合spring和jedis测试
	 */
	@Test
	public void jedisSingleSpringTest(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisPool jedisPool = (JedisPool)applicationContext.getBean("jedisClient");
		Jedis jedis = jedisPool.getResource();
		jedis.set("test01", "hello wang");
		String result = jedis.get("test01");
		System.out.println(result);
		jedis.close();
		jedisPool.close();
	}
	
	/**
	 * 整合spring和jedisCluster测试
	 * @throws IOException 
	 */
	@Test
	public void jedisClusterSpringTest() throws IOException{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisCluster jedis = (JedisCluster) applicationContext.getBean("jedisClient");
		String result = jedis.get("a");
		System.out.println(result);
		jedis.close();
	}
}
