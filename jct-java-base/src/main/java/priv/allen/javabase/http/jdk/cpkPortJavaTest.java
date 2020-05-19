package priv.allen.javabase.http.jdk;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class cpkPortJavaTest {
	
	
	public static void main(String[] args) {
		String name = "";// ����
		String uid = "";// �û�ID
		String token = "";// token

		String url = "http://api.caipiaokong.com/lottery/";
		url += "?name=" + name;
		url += "&format=json";// ���ݸ�ʽ�����ļ���֧��json
		url += "&uid=" + uid;
		url += "&token=" + token;

		String urlAll = new StringBuffer(url).toString();
		String charset = "UTF-8";
		String jsonResult = get(urlAll, charset);// �õ�JSON�ַ���
		
		
		JsonParser jsonParser = new JsonParser();
		try {
			JsonElement e = jsonParser.parse(jsonResult);
			JsonObject obejct = e.getAsJsonObject();
			Iterator it = obejct.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				String value = obejct.get(key).getAsString();
				JsonObject object1 = jsonParser.parse(value).getAsJsonObject(); // 
				String outputStr = "id:" + key;
				outputStr += " number:" + object1.get("number");
				outputStr += " dateline:" + object1.get("dateline");
				System.out.println(outputStr);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param urlAll
	 * @param charset
	 * @return String
	 */
	public static String get(String urlAll, String charset) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";//模拟浏览器
		try {
			URL url = new URL(urlAll);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(30000);
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("User-agent", userAgent);
			connection.connect();
			
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, charset));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
