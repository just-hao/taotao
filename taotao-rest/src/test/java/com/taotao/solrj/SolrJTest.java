package com.taotao.solrj;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient.Builder;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJTest {
	
	@Test
	public void addDocument() throws SolrServerException, IOException{
		//创建一个连接
		Builder builder = new HttpSolrClient.Builder("http://192.168.137.100:8080/solr7/mycore");
		HttpSolrClient solrClient = builder.build();
		//创建一个文档对象
		SolrInputDocument solrDocument = new SolrInputDocument();
		solrDocument.addField("id", "test001");
		solrDocument.addField("item_title", "测试商品1");
		solrDocument.addField("item_price", "12345");
		//将对象写入索引库
		solrClient.add(solrDocument);
		//提交
		solrClient.commit();
		solrClient.close();
	}
}
