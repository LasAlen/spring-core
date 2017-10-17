package cn.zjdyms.spring.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ResourceUtil {
	
	public static URI toURI(URL url) throws URISyntaxException{
		return toURI(url.toString());
	} 
	
	public static URI toURI(String url) throws URISyntaxException {
		return new URI(StringUtils.replace(url, " ", "%20"));
	}
}
