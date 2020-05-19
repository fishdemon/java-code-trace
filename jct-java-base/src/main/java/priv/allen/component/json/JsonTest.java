package priv.allen.component.json;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

/**
 * 官方Json 通用性很大
 * 没有与实体类直接映射的方法, 相对来说比较麻烦。
 * 
 * @author Anjin.Ma
 *
 */
public class JsonTest {
	
	// string to json object
	@Test
	public void test1() {
		// 对象嵌套数组嵌套对象
		String json1 = "{'id':001,'name':'June','students':[{'id':001,'name':'郭靖','age':12},{'id':002,'name':'黄蓉','age':12}]}";
		// 数组
		String json2 = "['北京','天津','杭州']";

		// 解析第一层---对象
		JSONObject jObject1 = new JSONObject(json1);

		Teacher teacher = new Teacher();
		teacher.setId(jObject1.getInt("id"));
		teacher.setName(jObject1.getString("name"));

		ArrayList<Student> stus = new ArrayList<>();
		// 解析第二层----数组
		JSONArray jsonArray2 = jObject1.getJSONArray("students");
		// 遍历数组获取元素----对象
		for (int i = 0, len = jsonArray2.length(); i < len; i++) {
			// 解析第三层----对象
			JSONObject jObject3 = jsonArray2.getJSONObject(i);
			Student student = new Student(jObject3.getInt("id"), jObject3.getString("name"), jObject3.getInt("age"));
			teacher.addStudent(student);
		}

		System.out.println("java字符串：" + teacher);
		System.out.println("json字符串：\n" + jObject1.toString(2));

		// 获取当前对象的所有属性的迭代器对象
		Iterator<String> iterator = jObject1.keys();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println("属性：" + key);
		}

		// 获取数组对象
		JSONArray jArray = new JSONArray(json2);
		ArrayList<String> list = new ArrayList<>();
		// 遍历获取元素
		for (int i = 0; i < jArray.length(); i++) {
			// jArray.optString(i);//等价于getXXX
			list.add(jArray.getString(i));
		}
		System.out.println("解析结果：" + list);
	}
	
	// json object to string
	@Test
	public void testjson2() {
		JSONObject jo1=new JSONObject();
        jo1.put("id", 1001);
        jo1.put("name", "范老");
        jo1.put("age", 20);
        JSONObject jo2=new JSONObject();
        jo2.put("id", 1002);
        jo2.put("name", "平平");
        jo2.put("age", 19);
        JSONArray ja2=new JSONArray();
        ja2.put(jo1);
        ja2.put(jo2);
        JSONObject jo3=new JSONObject();
        jo3.put("id", 11);
        jo3.put("name", "JAVAEE-1704");
        jo3.put("stus",ja2);        
        String json=jo3.toString();
        System.out.println(json);
	}

}
