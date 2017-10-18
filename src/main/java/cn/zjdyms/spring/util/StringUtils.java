package cn.zjdyms.spring.util;

public class StringUtils {
	public static boolean hasLength(String str) {
		return str != null && str.length() > 0;
	}
	
	public static boolean hasText(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		int strLength = str.length();
		for (int i = 0 ; i < strLength ; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
 			}
		}
		
		return false;
	}
	
	public static String replaceAll(String str, String pattern, String newPattern) {
		
		return null;
	}
	
	public static String replace(String str, String oldPattern, String newPattern) {
		//如果不含值,直接返回原字符串
		if (!hasLength(str) && !hasLength(oldPattern) && !hasLength(newPattern)) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		int pos = 0;
		int index = str.indexOf(oldPattern);
		int pLength = oldPattern.length();
		while(index > 0) {
			sb.append(str.substring(pos, index));
			sb.append(newPattern);
			pos = index + pLength;
			index = str.indexOf(oldPattern, pos);
		}
		sb.append(str.substring(pos));
		
		return sb.toString();
	}
	
	public static String cleanPath(String str) {
		return null;
	}
}
