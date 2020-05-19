//package priv.allen.javabase.xml.xpath;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.xpath.XPath;
//import javax.xml.xpath.XPathConstants;
//import javax.xml.xpath.XPathExpression;
//import javax.xml.xpath.XPathExpressionException;
//import javax.xml.xpath.XPathFactory;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//
///**
// * 参考 https://www.cnblogs.com/eternalisland/p/6287044.html
// * @author Anjin.Ma
// *
// */
//public class XpathTest {
//
//	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
//		// 标准的JAXP和DOM
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setNamespaceAware(false);
//		factory.setIgnoringComments(true);
//		factory.setIgnoringElementContentWhitespace(false);
//		factory.setCoalescing(false);
//		factory.setExpandEntityReferences(true);
//		DocumentBuilder builder = factory.newDocumentBuilder();
//		InputStream is = Resources.getResourceAsStream("WorkorderMapper.xml");
//		Document doc = builder.parse(is);
//
//		NodeList nodes = doc.getElementsByTagName("resultMap");
//		for (int i = 0; i < nodes.getLength(); i++) {
//            System.out.println(nodes.item(i).getNodeValue());
//        }
//
//		// 使用XPath
//		XPathFactory xPathFactory = XPathFactory.newInstance();
//		XPath xpath = xPathFactory.newXPath();
//		// XPath表达式
//		XPathExpression expr = xpath.compile("//resultMap[id=\"WorkorderEntity\"]");
//		Object res = expr.evaluate(doc, XPathConstants.NODESET);
//		// 强制转化
//		nodes = (NodeList) res;
//		for (int i = 0; i < nodes.getLength(); i++) {
//            System.out.println(nodes.item(i).getNodeValue());
//        }
//	}
//
//}
