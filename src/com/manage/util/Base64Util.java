package com.manage.util;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {
	/**
	 * 
	 * @param orign 需要编码的字符串
	 * @return 编码后的字符串
	 */
	public static String encode(String orign) {
		return new String(new BASE64Encoder().encode(orign.getBytes()));
	}

	/**
	 * 
	 * @param orign 需要解码的字符串
	 * @return 解码后的字符串
	 */
	public static String decode(String orign) {
		String result = null;
		try {
			result = new String(new BASE64Decoder().decodeBuffer(orign));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
