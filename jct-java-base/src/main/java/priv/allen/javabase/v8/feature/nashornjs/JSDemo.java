/**
 * 
 */
package priv.allen.javabase.v8.feature.nashornjs;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Nashorn 一个 javascript 引擎。 从JDK 1.8开始，Nashorn取代Rhino(JDK 1.6, JDK1.7)成为Java的嵌入式JavaScript引擎 Nashorn完全支持ECMAScript 5.1规范以及一些扩展
 * 
 * @author Allen
 */
public class JSDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn"); //$NON-NLS-1$

		String name = "Runoob"; //$NON-NLS-1$
		Integer result = null;

		try {
			nashorn.eval("print('" + name + "')"); //$NON-NLS-1$ //$NON-NLS-2$
			result = (Integer) nashorn.eval("10 + 2"); //$NON-NLS-1$
		} catch (ScriptException e) {
			System.out.println("执行脚本错误: " + e.getMessage()); //$NON-NLS-1$
		}

		System.out.println(result.toString());
	}

}
