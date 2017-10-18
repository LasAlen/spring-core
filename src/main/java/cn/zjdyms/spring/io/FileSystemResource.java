package cn.zjdyms.spring.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;

import cn.zjdyms.spring.util.ResourceUtil;
import cn.zjdyms.spring.util.StringUtils;

public class FileSystemResource extends AbstractResource{
	private final File file; 
	
	private final String path;
	
	public FileSystemResource(String path) {
		this.file = new File(path);
		this.path = StringUtils.cleanPath(path);
	}
	
	public FileSystemResource(File file) {
		this.file = file;
		this.path = StringUtils.cleanPath(file.getPath());
	}
	
	public final String getPath() {
		return this.path;
	}
	
	/*
	 * 目录也可以是存在的吗
	 *  (non-Javadoc)
	 * @see cn.zjdyms.spring.io.AbstractResource#isExit()
	 */
	@Override
	public boolean isExit() {
		/*if (this.file.isDirectory()) {
			return false;
		} else {
			return this.file.exists();
		}*/
		return file.exists();
	}

	@Override
	public boolean isReadable() {
		return file.canRead() && !file.isDirectory();
	}

	@Override
	public URI getURI() throws IOException {
		return file.toURI();
	}

	@Override
	public URL getURL() throws IOException {
		return getURI().toURL();
	}

	@Override
	public File getFile() throws IOException {
		return this.file;
	}

	@Override
	public long getContentLength() throws IOException {
		return file.length();
	}

	@Override
	public long getLastModfied() throws IOException {
		return file.lastModified();
	}

	@Override
	public Resource createRelationResource(String relateName) throws IOException {
		File file = new File(path, relateName);
		if (!file.exists()) {
			file.createNewFile();
		}
		return new FileSystemResource(file);
	}

	@Override
	public String getFileName() {
		return file.getName();
	}

	public String getDescription() {
		return "file [" + this.file.getAbsolutePath() + "]";
	}

	public InputStream getInputStream() throws IOException {
		return new FileInputStream(file);
	}

}
