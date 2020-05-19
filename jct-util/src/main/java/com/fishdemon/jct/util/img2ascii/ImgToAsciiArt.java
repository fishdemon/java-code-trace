package com.fishdemon.jct.util.img2ascii;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 整体思想是：读取图片->读取图片的每个像素点的rgb信息->将每个像素的rgb信息转化成对应的灰度值->将灰度值分成11等分->每份对应一个字符->得到字符画
 * @author Anjin.Ma
 *
 */
public class ImgToAsciiArt {
	// 这里定义了默认的字符串，由复杂到简单
	private static String charUse= "@#&$%*o!;.";
	
	public static String transfer(String file) throws IOException {
		return transfer(new File(file));
	}
	
	public static String transfer(File file) throws IOException {
		return transfer(ImageIO.read(file));
	}
	
	public static String transfer(InputStream in) throws IOException {
		return transfer(ImageIO.read(in));
	}
	
	public static String transfer(URL url) throws IOException {
		return transfer(ImageIO.read(url));
	}

	public static String transfer(BufferedImage image) {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < image.getHeight(); y += 8) {           
			for (int x = 0; x < image.getWidth(); x+=4) {
				// 这个方法通过图像中每个像素点的位置得到这个点ARGB像素值，并将ARGB像素值存储到rgbData数组中，rgbData数组中的数据是以0xAARRGGBB格式存储的，也就是十六进制储存，所以这个方法得到的结果是一个8位整数
				int pixel = image.getRGB(x, y);
				// pixel为8位整数，r为红色值，pixel & 0xff0000中pixel为八位整数，这个&表示与，又因为rgbData数组中的数据是以0xAARRGGBB格式存储的，所以可以知道r颜色储存在从左往右第3/4位，所以pixel & 0xff0000就是要把第3/4位取出来，其他位变成0，>>表示以为运算，可以知道r颜色的右边还有4位数，又由于是十六进制，所以4位十六进制表示16位二进制，所有>>16,最终得到r值，r的值位0-255，同理可得b，g值
				int r = (pixel & 0xff0000) >> 16; 
				int g = (pixel & 0xff00) >> 8;
				int b = pixel & 0xff;
				
				// 将rgb值转化成灰度值，这里r、g、b之前的常数是固定值，这个公式是rgb转换灰度值的一种加权常用算法，不必太深究，转换成的灰度值gray范围为0-255
				float gray = 0.299f * r + 0.578f * g + 0.114f * b;
				
				// 这里base我们是自己设置的，长度为10，然后加1，然后灰度值与这个值乘法，然后再做除法，最终得到的index值得范围为0-11，可以知道值越小，颜色越黑，反之越白
				int index = Math.round(gray * (charUse.length() + 1) / 255);
				
				sb.append(index >= charUse.length() ? " " : String.valueOf(charUse.charAt(index)));
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		try {
//			String asciiArt = transfer("F://me/11.jpeg");
			String asciiArt = transfer(new URL("https://images2018.cnblogs.com/blog/285763/201711/285763-20171127173336972-172418048.png"));
			System.out.println(asciiArt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
