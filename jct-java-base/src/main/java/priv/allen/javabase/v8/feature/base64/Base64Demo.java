/**
 * 
 */
package priv.allen.javabase.v8.feature.base64;

import java.util.Base64;

import org.junit.Test;

/**
 * 三种BASE64编解码器
 * 1. 基本：输出被映射到一组字符A-Za-z0-9+/，编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/。
 * 2. URL：输出映射到一组字符A-Za-z0-9+_，输出是URL和文件。
 * 3. MIME：输出隐射到MIME友好格式。输出每行不超过76字符，并且使用'\r'并跟随'\n'作为分割。编码输出最后没有行分割。
 * @author Allen
 */
public class Base64Demo {
	
	/**
	 * 
	 */
	@Test
	public void encode() {
		String encodeStr = Base64.getEncoder().encodeToString("This is a test".getBytes()); //$NON-NLS-1$
		System.out.println(encodeStr);
		
		String decodeStr = new String(Base64.getDecoder().decode(encodeStr));
		System.out.println(decodeStr);
	}

}
