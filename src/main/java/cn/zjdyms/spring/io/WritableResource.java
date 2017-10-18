package cn.zjdyms.spring.io;

import java.io.OutputStream;

public interface WritableResource extends Resource{
	boolean isWritable();
	
	OutputStream getOutputStream();
}
