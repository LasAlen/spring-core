package cn.zjdyms.spring.core;

import java.util.Date;

import org.junit.Test;

import cn.zjdyms.spring.util.StringUtils;

/**
 * Unit test for simple App.
 */
public class StringUtilTest 
    
{
    
    
    public static void main(String[] args) {
    	String str = "http://%20%20xxdyz";
    	Date date = new Date();
    	for (int i = 0; i < 10000; i++) {
    		StringUtils.replace(str, "%20", " ");
    	}
    	Date date1 = new Date(); 
    	System.out.println(date1.getTime() - date.getTime());
	}
    
    @Test
    public void test() {
    	String str =StringUtils.cleanPath("file:aa/../../dd/");
    	System.out.println(str);
    }
}
