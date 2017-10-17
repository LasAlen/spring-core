package cn.zjdyms.spring.io;

import java.io.IOException;
import java.io.InputStream;

public interface InputStreamSource {
	
	/**
	 * 获取输入流
	 * @return 输入流
	 * @throws IOException
	 */
	InputStream getInputStream() throws IOException;
}
