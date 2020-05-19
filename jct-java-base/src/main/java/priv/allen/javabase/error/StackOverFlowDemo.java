package priv.allen.javabase.error;

/**
 * 堆栈溢出错误一般是递归调用嘛
 * @author Ma anjin 
 *
 */
public class StackOverFlowDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		method();
	}
	
	 /**
	 * 
	 */
	public static void method(){
	    for(;;)
	       method();
	 }

}
