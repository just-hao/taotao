package com.taotao.rest.dao;

public interface JedisClient {
	
	String set(String key, String value);
	
	String get(String key);
	
	String  hget(String hkey, String key);
	
	Long hset(String hkey, String key, String value);
	
	long incr(String key);
	
	long expire(String key, int second);
	
	long ttl(String key);
}
