package priv.allen.component.json;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * gson google出品
 * 个人比较喜欢用,方便简单
 * 至于速度，跟人没有仔细研究过，但是google出品的东西我相信
 * @author Anjin.Ma
 *
 */
public class GsonTest {
	
	@Test
	public void test1() {
		String json1 = "{'id':001,'name':'June','students':[{'id':001,'name':'郭靖','age':12},{'id':002,'name':'黄蓉','age':12}]}";
		// 数组
		String json2 = "['北京','天津','杭州']";
		
		String json3 = "[{'id':001,'name':'郭靖','age':12},{'id':002,'name':'黄蓉','age':12}]";
				
		Gson gson = new Gson();
		Teacher teacher = gson.fromJson(json1, Teacher.class);
		System.out.println(teacher);
		
		// 解析数组 使用Type
		ArrayList<String> locations = gson.fromJson(json2, new TypeToken<ArrayList<String>>(){}.getType());
		System.out.println(locations);
		
		// 解析数组 使用Type
		ArrayList<Student> students = gson.fromJson(json3, new TypeToken<ArrayList<Student>>(){}.getType());
		System.out.println(students);
	}
	
	@Test
	public void test2() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(001, "郭靖", 12));
		students.add(new Student(002, "黄蓉", 13));
		
		Gson gson = new Gson();
		String json1 = gson.toJson(students);
		System.out.println(json1);
		
		Teacher teacher = new Teacher(001, "june", 29);
		teacher.setStudents(students);
		String json2 = gson.toJson(teacher);
		System.out.println(json2);
	}

}
