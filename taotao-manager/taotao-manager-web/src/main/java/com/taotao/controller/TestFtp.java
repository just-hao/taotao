package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * <p>Title: TestFtp </p>
 * <p>Description: ftp测试</p>
 * @author	wang
 * @date	2018年5月19日上午11:29:51
 * @version 1.0
 */
public class TestFtp {
	public void testFtpClient() throws SocketException, IOException{
		//add a FtpClient Object
		FTPClient ftpClient = new FTPClient();
		// 新建一个ftp连接,默认端口是21
		ftpClient.connect("127.0.0.1",21);
		//设置ftp登录的用户名和密码
		ftpClient.login("ftpuser", "ftpuser");
		//上传文件
		//读取本地文件
		FileInputStream fileInputStream = new FileInputStream(new File("filepath"));
		//设置上传文件的路径
		ftpClient.changeWorkingDirectory("reloadpath");
		//修改上传文件上传的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//第一个参数：服务器文档名
		//第二个参数：上传文档的inputStream
		ftpClient.storeFile("hello.jpg", fileInputStream);
		//关闭连接
		ftpClient.logout();
		
		
	}
}
