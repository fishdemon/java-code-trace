package priv.allen.javabase.test;

import java.util.regex.Pattern;

public class RegDemo {
	
	public static boolean isInteger(String str) {    
	    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
	    return pattern.matcher(str).matches();    
	}
	
	public static boolean isNumeric(String str){  
	    Pattern pattern = Pattern.compile("[0-9]+");  
	    return pattern.matcher(str).matches();     
	} 
	
	public static void main(String[] args) {
		System.out.println(isInteger("0123"));
		System.out.println(isInteger("-0123"));
		System.out.println(isInteger("+0123"));
		System.out.println(isInteger("1.23"));
		
		System.out.println(isNumeric("0123"));
		System.out.println(isNumeric("-0123"));
		System.out.println(isNumeric("+0123"));
		System.out.println(isNumeric("1.23"));
		System.out.println(isNumeric(""));
		System.out.println(isNumeric("1q"));
	}

}
