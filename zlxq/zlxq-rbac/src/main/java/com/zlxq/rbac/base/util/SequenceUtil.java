/**
 * 
 */
package com.zlxq.rbac.base.util;

import java.util.Random;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class SequenceUtil {
	private static final int N_LENGTH = 6;
	
	public static String getIoNo() {
		return getVaule(ConstantRBAC.IONO_PRE);
	}
	
	public static String getQrcode() {
		return getVaule(ConstantRBAC.QRCODE_PRE);
	}
	
	
	private static String getVaule(String s) {
		return s + getValue().toUpperCase();
	}

	private static String getValue() {
		String val = "";
		Random random = new Random();
		int en = 0;
		for (int i = 0; i < N_LENGTH; i++) {
			String str = ((int) ((Math.random() * 9 + 1))) % 2 == 0 ? "num" : "char";

			if ("char".equalsIgnoreCase(str) && en < 2) {
				// 产生字母
				int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (nextInt + random.nextInt(26));
				en++;
			} else if ("num".equalsIgnoreCase(str) || en == 2) {
				// 产生数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
}
