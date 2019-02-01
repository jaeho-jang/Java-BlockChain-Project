package util;

import java.security.MessageDigest;

public class Util {

	public static String getHash(String input) {
		StringBuffer result = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA-256 알고리즘이 구현된 객체를 반환
			md.update(input.getBytes()); // MessageDigest는 문자열에 대해 동작하는 것이 아니라 바이너리에 대해 동작하므로 바이트 배열로 변경해야 함 
			byte bytes[] = md.digest(); // byte로 읽어 해시로 변경
			for(int i = 0; i < bytes.length; i++) { // 문자열 형태로 변환
				result.append(
					Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}
