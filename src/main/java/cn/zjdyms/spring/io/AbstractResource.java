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
		// TODO Auto-generated method stub
		return null;
	}

	public long getContentLength() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getLastModfied() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Resource createRelationResource(String relateName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
