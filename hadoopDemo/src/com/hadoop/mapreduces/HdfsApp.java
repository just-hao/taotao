package com.hadoop.mapreduces;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/**
 * @author wang
 *
 */
public class HdfsApp {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "/user/beifeng/mapreduce/wordcount/input/wc.input";
		read(fileName);
	}

	/**
	 * read data
	 * @param fileName
	 * @throws IOException
	 */
	private static void read(String fileName) throws IOException {
		
		//get fileSystem
		FileSystem fileSystem = getFileSystem();
		
		//read path
		Path readPath = new Path(fileName);
		
		//open file
		FSDataInputStream inStream = fileSystem.open(readPath);
		
		try {
			//read
			IOUtils.copyBytes(inStream, System.out, 4096, false);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//close Stream
			IOUtils.closeStream(inStream);
		}
	}

	private static FileSystem getFileSystem() throws IOException {
		//core-site.xml,core-default.xml,hdfs-site.xml,hdfs-default.xml
		Configuration conf = new Configuration();
		
		//get filesystem
		FileSystem fileSystem = FileSystem.get(conf);
		
		//system.out.println(fileSystem);
		return fileSystem;
	}
	
}
