package priv.allen.bestcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 基本类型的默认值获取 
 * @author Allen
 */
public class PrimitiveDefault {
	
	private static boolean defaultBoolean;
    private static char defaultChar;
    private static byte defaultByte;
    private static short defaultShort;
    private static int defaultInt;
    private static long defaultLong;
    private static float defaultFloat;
    private static double defaultDouble;

    private static Map<Class<?>, Object> primitiveValues = new HashMap<Class<?>, Object>();
    private static Map<String, Object> primitiveNameValues = new HashMap<String, Object>();

    static {
        primitiveValues.put(boolean.class, defaultBoolean);
        primitiveValues.put(char.class, defaultChar);
        primitiveValues.put(byte.class, defaultByte);
        primitiveValues.put(short.class, defaultShort);
        primitiveValues.put(int.class, defaultInt);
        primitiveValues.put(long.class, defaultLong);
        primitiveValues.put(float.class, defaultFloat);
        primitiveValues.put(double.class, defaultDouble);
        
        primitiveNameValues.put(boolean.class.getName(), defaultBoolean);
        primitiveNameValues.put(char.class.getName(), defaultChar);
        primitiveNameValues.put(byte.class.getName(), defaultByte);
        primitiveNameValues.put(short.class.getName(), defaultShort);
        primitiveNameValues.put(int.class.getName(), defaultInt);
        primitiveNameValues.put(long.class.getName(), defaultLong);
        primitiveNameValues.put(float.class.getName(), defaultFloat);
        primitiveNameValues.put(double.class.getName(), defaultDouble);
    }
    
    /**
     * 根据class类型获取类型默认值，以Object返回（可以强转）
     * @param returnType
     * @return Object
     */
    public static Object getDefaultValue(Class<?> type) {
        return primitiveValues.get(type);
    }
    
    /**
     * 根据class名称获取类型默认值，以Object返回（可以强转）
     * @param returnType
     * @return Object
     */
    public static Object getDefaultValue(String typeName) {
        return primitiveNameValues.get(typeName);
    }
    
    /**
     * 根据class类型获取默认值，以Object返回（可以强转）
     * @param returnType
     * @return Object
     */
    @SuppressWarnings("unchecked")
	public static <T> T getDefaultCastValue(Class<T> type) {
        return (T) primitiveValues.get(type);
    }
    
    public static void main(String[] args) {
		boolean res = getDefaultCastValue(boolean.class);
		System.out.println(res);
		
		int intRes = (int) getDefaultValue("int");
		System.out.println(intRes);
	}

}
