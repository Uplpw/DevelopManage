package com.manage.util;

import java.security.MessageDigest;

public class MD5Util {
	private static char hexDigest[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };

	/**
	 * 
	 * @param orign 需要加密的字符串
	 * @return 32位加密后的字符串
	 */
	public static String encode(String orign) {
		String result = null;
		if (orign != null) {
			try {
				MessageDigest MD5 = MessageDigest.getInstance("MD5");
				byte[] btIpput = orign.getBytes();
				MD5.update(btIpput);
				byte[] md = MD5.digest();
				char str[] = new char[md.length * 2];
				int i = 0;
				for (byte byte0 : md) {
					str[i++] = hexDigest[byte0 >>> 4 & 0xf];
					str[i++] = hexDigest[byte0 & 0xf];
				}
				result = new String(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
