package util;

import java.security.MessageDigest;

public class Util {

	public static String getHash(String input) {
		StringBuffer result = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA-256 �˰����� ������ ��ü�� ��ȯ
			md.update(input.getBytes()); // MessageDigest�� ���ڿ��� ���� �����ϴ� ���� �ƴ϶� ���̳ʸ��� ���� �����ϹǷ� ����Ʈ �迭�� �����ؾ� �� 
			byte bytes[] = md.digest(); // byte�� �о� �ؽ÷� ����
			for(int i = 0; i < bytes.length; i++) { // ���ڿ� ���·� ��ȯ
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
