package priv.allen.javabase.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author Allen 
 *
 */
public class CustomeTest {
	
	@Test
	public void testGetFileName() {
		String path = "F:/ams-server/dg3-smt/meus/";
		File file = new File(path);
		String[] subFiles  = file.list();
		
		StringBuilder sb = new StringBuilder();
		for (String subFile:subFiles) {
			sb.append(path).append(subFile).append(";");
		}
		System.out.println(sb.toString());
	}
	
	/**
	 * map 获取不存在的值，不会抛出异常，而是返回null
	 * map 允许有一个null key, 多个 null value.
	 */
	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<>();
		String s = map.get("allen"); //$NON-NLS-1$
		System.out.println(s);
		
		map.put(null, "this key is null"); //$NON-NLS-1$
		System.out.println(map.get(null));
		
		map.put(null, "this is anothor null"); //$NON-NLS-1$
		System.out.println(map.get(null));
		
		map.put("allen", null); //$NON-NLS-1$
		System.out.println(map.get("allen")); //$NON-NLS-1$
	}
	
	/**
	 * \ 与   $ 的替换
	 */
	@Test
	public void testStringReplace() {
		
		// 有时间json是这个样子的，\"name\":\"allen\"  
		// 需要去掉 \
		String s = "\\\"name\\\":\\\"allen\\\""; //$NON-NLS-1$
		System.out.println(s);
		
		// 如果用replaceAll, 不可以直接用 "\\" ,会报错
//		String sWithReplaceBackslash = s.replaceAll("\\", ""); //$NON-NLS-1$ //$NON-NLS-2$
		// 如果用replaceAll, 要用"\\\\"
		String sWithReplaceBackslash = s.replaceAll("\\\\", ""); //$NON-NLS-1$ //$NON-NLS-2$
		System.out.println(sWithReplaceBackslash);
		// 可以用 replace，这样就可以直接用"\\"
		sWithReplaceBackslash = s.replace("\\", ""); //$NON-NLS-1$ //$NON-NLS-2$
		System.out.println(sWithReplaceBackslash);
		
	}

}
