package cn.zjdyms.spring.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * 通用的文件处理,各种资源统一整合,不仅仅处理文件系统的文件，还能整合处理各类
 * @author alen
 *
 */
public interface Resource extends InputStreamSource{
	//是否存在
	
	/**
	 * 资源是否存在
	 * @return
	 */
	boolean isExit();
	//是否可读
	
	/**
	 * 资源是否可读
	 * @return
	 */
	boolean isReadable();
	//是否打开
	
	/**
	 * 资源是否已经处于打开状态
	 * @return
	 */
	boolean isOpen();
	//uri
	
	/**
	 * 获取资源的URI
	 * @return
	 */
	URI getURI() throws IOException;
	//url
	
	/**
	 * 获取资源的URL
	 * @return
	 */
	URL getURL() throws IOException;
	//获取文件
	
	/**
	 * 获取资源文件,如果不存在文件系统中返回null
	 * @return 
	 */
	File getFile() throws IOException;
	//可读资源的长度
	
	/**
	 * 获取资源可读长度
	 * @return
	 */
	long getContentLength() throws IOException;
	//上次修改的时间
	
	/**
	 * 获取资源上一次修改的时间
	 * @return
	 */
	long getLastModfied() throws IOException;
	//创建一个相关文件
	
	/**
	 * 创建一个
	 * @param relateName
	 * @return
	 * @throws 
	 */
	Resource createRelationResource(String relateName) throws IOException;
	//获取文件名
	/**
	 * 获取文件名,
	 * 如果不存在文件名的资源可以返回null
	 * @return 返回资源的文件名
	 */
	String getFileName();
	//获取描述
	/**
	 * 返回该资源的描述,可用于当资源发生异常时间的输出标识
	 * @return 返回资源的描述
	 */
	String getDescription();
}
