
public class StringDemo {
/*	3.1将字符串转成字符数组
 * 	
	3.2将字符数组转成字符串
	
4.替换
	string replace(oldchar,newchar);
6.获取字符串的子串

StringBuffer是一个字符串缓冲区
是一个容器。
1：存储
2：删除
3：修改
4：获取
基本数据类型包装类

	*/
	
	public static void main(String[] args) {
		
/*		String s1 = "abc"; //s1是一个类型变量，“abc"是一个对象
	//字符串最大的特点就是初始化就不可以被改变。
		//s1 = "kk";
		String s2 = new String("abc");
		String s3 = "abc";
		System.out.println(s1 == s3);
		System.out.println(s1 == s2);
		System.out.println(s1);*/
//		get();
//		String s1 = "   absdfasdadfadfcdg fgh    ";
//		sop(myTrim(s1));
//		sop(getCount2(s1,"a"));
//		getMaxsubString("heallo word","hello");
		update();
		//整数类型的最大值
		sop("int max :" + Integer.MAX_VALUE);
	}
	
	public static void update() {
		StringBuffer sb = new StringBuffer("abcdefg");
		sop(sb.toString());
		sb.replace(1, 4, "a");
		sb.setCharAt(2, 'k');
		sop(sb);
	}
	public static void method_del() {
		StringBuffer sb = new StringBuffer("abcdrf");
		sb.delete(0, sb.length());
		sop(sb.toString());
	}
	
	public static void method_add() {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = sb.append(24);
		sop(sb.toString());
		sop(sb1.toString());
		
	}
	
	public static String getMaxsubString(String s1, String s2) {
		for(int x=0; x<s2.length();x++){
			for(int y=0,z=s2.length()-x;z!=s2.length()+1;y++,z++){
				String temp = s2.substring(y, z);
				sop(temp);
				if(s1.contains(temp)){
					return temp;
				}
			}
		}
		return "";
	}
	public static int getCount2(String s, String key) {
		int count = 0;
		int index = 0;
		while((index = s.indexOf(key,index))!=-1){
			sop("str="+index);
			index = index+key.length();
			count ++;
		}
		return count;
	}
	public static int getCount(String s, String key) {
		int count = 0;
		int index = 0;
		while((index = s.indexOf(key))!=-1){
			sop("str="+s);
			s = s.substring(index+key.length());
			count ++;
		}
		return count;
	}
	public static String method_reverse(String s) {
		char[] array = s.toCharArray();
		//反转数组
		
		reverse(array);
		//将数组变成字符串
		String s1 = new String(array);
		return s1;
	}
	public static void reverse(char[] arr) {
		for(int start=0,end=arr.length-1;start<end; start++,end--){
			swap(arr,start,end);
		}
	}
	public static void swap(char[] arr,int x,int y) {
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	public static String myTrim(String str) {
		int start =0,end = str.length()-1;
		while(start<end && str.charAt(start)==' ')
			start ++;
		while(start<end && str.charAt(end)==' ')
			end--;
		return str.substring(start, end+1);
			
	}
	public static void method_7() {
		String s1 = "abc";
		String s2 = "aaa";
		sop(s1.compareTo(s2));
	}
	
	public static void method_sub() {
		String s = "abcdefg ";
		sop(s.toUpperCase());
		sop(s.toLowerCase());
		sop(s.trim());
		sop(s.substring(2));
		sop(s.substring(2, 4));
	}
	public static void methos_split() {
		String s = "zhangshan,lishi,wangwu";
		String[] arr = s.split(",");
		for(int x = 0; x<arr.length; x++){
			sop(arr[x]);
		}
	}
	private static void chang_trans() {
		char [] arr = {'a','b','c','c','e','f'};
		String s = new String (arr,1,3);
		sop("s="+s);
		
		String s1 = "zxcvbnm";
		
		char [] chs = s1.toCharArray();
		for(int x=0; x<chs.length; x++){
			sop("chs="+chs[x]);
		}
	}
	private static void method_replace() {
		String s = "hello word!";
		
		String s1 = s.replace("word", "java");
		sop("s="+s);
		sop("s1="+s1);
	}
	public static void get() {
		String  str = "ArrayDemo.java";
		//长度
		sop(str.length());
		
		//根据索引获取字符
		sop(str.charAt(4));
		
		//根据字符回去索引
		sop(str.indexOf('a', 3));
		
		//反向索引一个字符出现的位置
		sop(str.lastIndexOf("a"));
		//判断文件是否是array开头
		sop(str.startsWith("Array"));
		//判断文件是否是.java文件
		sop(str.endsWith("java"));
		//判断文件时否包含demo
		sop(str.contains("Demo"));
		//
		
	}
	
	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
