package cn.zjdyms.spring.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StringUtils {
	private static final String WINDOW_FS = "\\";
	
	private static final String FS = "/";
	
	private static final String CUR = ".";
	
	private static final String PARENT = "..";
	
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
		if (!hasText(str)) {
			return null;
		}
		String path = replace(str, WINDOW_FS, FS);
		
		int index = path.indexOf(":");
		String prefix = null;
		
		if (index != -1) {
			prefix = path.substring(0,index + 1);
			path = path.substring(index + 1);
			
		}
		if (path.startsWith(FS)) {
			prefix += FS;
			path = path.substring(1);
		}
		
		String pathArray[] = delimitedListToStringArray(path, FS);
		List<String> pathElement = new LinkedList<String>();
		int tops = 0;
		for (int i = pathArray.length - 1; i >= 0 ; i --) {
			String element = pathArray[i];
			if(CUR.equals(element)) {
				continue;
			}
			else if (PARENT.equals(element)) {
				tops ++;
			} else if (tops > 0) {
				tops --;
			} else {
				pathElement.add(0,element);
			}
		}
		
		for (int i = 0; i < tops; i++) {
			pathElement.add(0,PARENT);
		}
		
		return prefix + collectionToDelimitedString(pathElement, FS);
	}

	public static String collectionToDelimitedString(List<String> pathElement, String delimit) {
		return collectionToDelimitedString(pathElement,delimit, "", "");
	}

	public static String collectionToDelimitedString(List<String> pathElement, String delimit, String prefix,
			String suffix) {
		if (pathElement == null || pathElement.size() == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (String element : pathElement) {
			sb.append(prefix).append(element).append(suffix).append(delimit);
		}
		String str = sb.toString();
		return str.substring(0,str.length());
	}

	public static String[] delimitedListToStringArray(String path, String delimit) {
		return delimitedListToStringArray(path, delimit, null);
	}

	public static String[] delimitedListToStringArray(String path, String delimit, String charsToDelete) {
		if (path == null) {
			return new String[0];
		}
		if (delimit == null) {
			return new String[]{path};
		}
		List<String> pathArray = new ArrayList<String>();
		if ("".equals(delimit)) {
			for (int i = 0; i < path.length() ; i++) {
				pathArray.add(deleteAny(path.substring(i, i + 1), charsToDelete));
			}
		} else {
			int index;
			int pos = 0;
			int delimitLength = delimit.length();
			while((index = path.indexOf(delimit, pos)) != -1) {
				pathArray.add(deleteAny(path.substring(pos, index), charsToDelete));
				pos = index + delimitLength;
			}
			if (pos <= path.length()) {
				pathArray.add(deleteAny(path.substring(pos), charsToDelete));
			}
		}
		
		return pathArray.toArray(new String[pathArray.size()]);
	}

	public static String deleteAny(String path, String charsToDelete) {
		if (!hasLength(path) || !hasLength(charsToDelete)) {
			return path;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if (charsToDelete.indexOf(c) != -1) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
