package cn.zjdyms.spring.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import cn.zjdyms.spring.util.ResourceUtil;

public abstract class AbstractResource implements Resource{

	public boolean isExit() {
		try{
			return getFile().exists();
		} catch (IOException e) {
			try {
				InputStream is = getInputStream();
				is.close();
				return true;
			} catch (IOException ex) {
				return false;
			}
		}
	}

	public boolean isReadable() {
		return true;
	}

	public boolean isOpen() {
		return false;
	}

	public URI getURI() throws IOException{
		try {
			URL url = getURL();
			return ResourceUtil.toURI(url);
		} catch (URISyntaxException e) {
			
		}
		return null;
	}

	public URL getURL() throws IOException{
		throw new FileNotFoundException(getDescription() + " cannot be resolved to URL");
	}

	public File getFile() throws IOException {
		throw new FileNotFoundException(getDescription() + " resolved to absolute file path");
	}

	public long getContentLength() throws IOException {
		InputStream is = getInputStream();
		if (is == null ) {
			throw new IOException(getDescription() + " cannot find resource");
		}
		try {
			long count = 0;
			int length = 0;
			byte[] content = new byte[1024];
			while((length = is.read(content)) != -1) {
				count += length;
			}
			return count;
		} finally {
			try {
				is.close();
			} catch (Exception e) {
			}
		}
		
	}

	public long getLastModfied() throws IOException{
		//spring实现交给了一个新方法处理,原因?
		return getFile().lastModified();
	}

	public Resource createRelationResource(String relateName) throws IOException {
		
		throw new FileNotFoundException("Cannot create a relative resource for " + getDescription());
	}

	public String getFileName() {
		
		return null;
	}

	@Override
	public String toString() {
		return getDescription();
	}
	
	

	
}
