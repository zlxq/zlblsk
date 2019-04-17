package com.framework.util;

import java.io.UnsupportedEncodingException;

import com.oreilly.servlet.Base64Decoder;
import com.oreilly.servlet.Base64Encoder;

public class Base64Util {

	public static String encodeBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = Base64Encoder.encode(b);
		}
		return s;
	}

	public static String decodeBase64(String str) {
		String result = null;
		if (str != null) {
			try {
				result = Base64Decoder.decode(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(encodeBase64("123"));

		System.out.println(decodeBase64("MTIz"));
	}
}
