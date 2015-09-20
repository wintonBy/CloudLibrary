/**
 * Project Name:CloudLibrary
 * File Name:TestDriver.java
 * Package Name:test
 * Date:2015年9月16日上午10:04:54
 * Copyright (c) 2015, winton_by@126.com All Rights Reserved.
 *
 */
package test;

/**
 * ClassName: TestDriver date: 2015年9月16日 上午10:04:54
 * 
 * @author winton_by@126.com
 * @version v1.0
 */
public class TestDriver {

	public static void main(String args[]) {

		// BaiduProvider bp = new BaiduProvider();
		// List<BosObjectSummary> list =bp.getChild("");
		//
		// for(BosObjectSummary os:list){
		// System.out.println(os.getKey());
		// bp.deleteObject("", os.getKey());
		// }
		//
		// File file = new File("E://test.txt");
		// System.out.println(bp.uploadFile("zww/", "test", file));
		// bp.createFolder("hello/ho/", "");
		for (int i = 1; i < args.length; i += 2) {
			double n = Double.parseDouble(args[i - 1]);
			double m = Double.parseDouble((args[i]));
			getResult(n, m);
		}

	}

	public static void getResult(double n, double m) {
		double result = 0;
		while (m-- != 0) {
			result += n;
			n = Math.sqrt(n);
		}
		System.out.printf("%.2f\n", result);
	}
}
