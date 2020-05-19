package priv.allen.javabase.map;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

public class EnumMapTest {
	
	public static void main(String[] args) {
		EnumMap<Color, String> map = new EnumMap<>(Color.class);
		map.put(Color.RED, "red");
		map.keySet().forEach(e -> System.out.println(map.get(e)));
		
		Set<Color> set = EnumSet.noneOf(Color.class);
		set.add(Color.RED);
		
		set = EnumSet.allOf(Color.class);
	}
	
	public static enum Color {
		RED,
		YELLOW,
		BLUE,
		WHITE
	}

}
