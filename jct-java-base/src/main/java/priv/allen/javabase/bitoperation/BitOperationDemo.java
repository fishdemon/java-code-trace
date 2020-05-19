package priv.allen.javabase.bitoperation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BitOperationDemo {
	
	/**
	 * 去掉二进制数 b 的最后一位1
	 * 1100 -> 1000   b&(b-1)
	 */
	@Test
	public void demo1() {
		int b = 0b1100;
		int b1 = b-1;
		int res = b&(b-1);
		System.out.printf("%s & %s = %s ", Integer.toBinaryString(b), Integer.toBinaryString(b1), Integer.toBinaryString(res));
		System.out.println();
		System.out.println("--------------------------------------");
	}
	
	/**
	 * 用O(1)时间检测整数n是否是2的幂次.
	 * 1. n>0
	 * 2. n的二进制数中只有1个1. 1，10，100
	 * 
	 * 判断方法：去掉n中的1（b&(b-1)），判断结果是否等于0。
	 */
	@Test
	public void demo2( ) {
		int n = 5;
		int res = n&(n-1);
		if (0 == res) {
			System.out.printf("%s 为2的幂次", n);
		} else {
			System.out.printf("%s 不为2的幂次", n);
		}
		
		System.out.println();
		System.out.println("--------------------------------------");
	}
	
	/**
	 *  计算在一个 32 位的整数的二进制表示中有多少个 1.
	 *  
	 *  思路：循环使用b&(b-1)，计算总共消去了多少次
	 */
	@Test
	public void demo3() {
		int n = 76399272;
		int b = n;
		int numOf1 = 0;
		
		while (b != 0) {
			b = b&(b-1);
			numOf1 ++;
		}
		
		System.out.printf("%s 的二进制为 %s, 共含有  %s 个1", n, Integer.toBinaryString(n), numOf1);
		System.out.println();
		System.out.println("--------------------------------------");
	}
	
	/**
	 * 将整数A转化为整数B后，需要改变多少个Bit位
	 * 
	 * 思路: 也就是比较A与B不相同的bit位有多少个，可以用异或操作，相同为0，不同为1，那么就是计算A^B后的值中1的个数
	 */
	@Test
	public void demo4() {
		int a = 7329937;
		int b = 1662221343;
		
		int c = a ^ b;
		int numOf1 = 0;
		while (c != 0) {
			c = c&(c-1);
			numOf1 ++;
		}
		
		System.out.printf("%s [%s] 转化为 %s [%s] , 共需要改变  %s 个bit位", a, Integer.toBinaryString(a), b, Integer.toBinaryString(b), numOf1);
		System.out.println();
		System.out.println("--------------------------------------");
	}
	
	/**
	 * a^b^b=a  b^a^b=a 
	 * 原理: 相同的数相异或为0，0与任何数异或为任何数
	 * 
	 * 可以用来解题， Given [1,2,2,1,3,4,3], return 4
	 * 因为只有一个数恰好出现一个，剩下的都出现过两次，所以只要将所有的数异或起来，就可以得到唯一的那个数
	 */
	@Test
	public void demo5() {
		int[] a= new int[] {1,2,2,1,3,4,3};
		int res = 0;
		for (int e : a) {
			res = res ^ e;
		}
		System.out.printf("a中的那个数为 " + res);
		System.out.println();
		System.out.println("--------------------------------------");
	}
	
	/**
	 *  Given [1,1,2,3,3,3,2,2,4,1] return 4
	 *  给定一个整数集合，只有一个数恰好出现1次，其他数都出现了3次，求这个数。
	 *  
	 *  解法：https://blog.csdn.net/deaidai/article/details/78167367
	 */
	@Test
	public void demo6() {
		
	}
	
	/**
	 * Given [1,2,2,3,4,4,5,3] return 1 and 5
	 * 给定一个整数集合，只有2个数恰好出现1次，其他数都出现了2次，求这两个数。
	 * 
	 * 思路：
	 * 设这两个数是x,y,那么x^y=res, res为所有数异或的结果，并且res！=0
	 * 那么我们可以找出res二进制表示中某一位为1，那么对于x,y中这一位上的数一定是不同的，也就是说其中一个数该位置为1.
	 * 对于原来的数组，我们可以根据这个位置是否为1，分成两个部分，其中一部分的异或结果就可以求出其中一个。
	 */
	@Test
	public void demo7() {
		int[] a= new int[] {1,2,2,3,4,4,5,3};
		int res = 0;
		// 计算res
		for (int e : a) {
			res = res ^ e;
			
		}
		
		// 找到为1的位置
		int pos = 0;
		for (int i = 0; i< 32; i++) {
			if ((res & ((int) Math.pow(2, i))) != 0) {
				pos = i;
				break;
			}
		}
		
		// 并找出数组中所有数指定位为1的子集
		List<Integer> b = new ArrayList<>();
		for (int e : a) {
			if ((e & ((int) Math.pow(2, pos))) != 0) {
				b.add(e);
			}	
		}
		
		// x为指定位为1的所有数的异或结果
		int x = 0;
		for (int e: b) {
			x = x ^ e;
		}
		
		// a^b^b=a
		int y = x ^ res;
		
		System.out.printf("这两个数为：%s,%s",x,y);
		System.out.println();
		System.out.println("--------------------------------------");
	}
	
	/**
	 * 给定一个含不同整数的集合，返回其所有的子集
	 * 如果 S = [1,2,3]，有如下的解：
	 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2] ]
	 * 
	 * 思路：
	 * 0 000 []
	 * 1 001 [3]
	 * 2 010 [2]
	 * 3 011 [2,3]
	 * 4 100 [1]
	 * 5 101 [1,3]
	 * 6 110 [1,2]
	 * 7 111 [1,2,3]
	 * 
	 * 可以看出，如果整数的个数为n, 它的子集就是 2^n-1个（除过第0个，如果要除自身，需要除过111的情况）, 每个子集都对应当前整数的二进制位上的数取或者不取。
	 * 我们可以将每个二进制数的每一位看成是数组的下标，下标为1，就取当前下标的数，为0，就不取，从1到2^n-1。
	 */
	@Test
	public void demo8() {
		int[] s = new int[] {1,2,3};
		List<List<Integer>> res = new ArrayList<>();
		
		int n = s.length;
		int max = (int) Math.pow(2, n);
		for (int i=1; i<max; i++) {
			List<Integer> subRes = new ArrayList<>();
			// 遍历整数的每一位
			for (int j =0; j<n;j++) {
				// 判断当前位，如果为1，则取值
				if ((i & ((int) Math.pow(2, j))) != 0) {
					subRes.add(s[j]);
				}
			}
			res.add(subRes);
		}
		
		res.forEach(e -> {
			e.forEach(e1 -> System.out.print(e1 + ", "));
			System.out.println();
			});
	}
	
	/**
	 * 获取二进制数的某一位
	 */
	@Test
	public void demo9() {
		int n = 5;
		// 获取它的每一位
		for (int i =0; i<32; i++) {
			int temp = n >> i;
			int pos = 0;
			if ((temp & 1) != 0) {
				pos = 1;
			}
			System.out.printf("%s 的第 %s 位为 %s", n,i,pos);
			System.out.println();
		}
		
		// 获取它的指定位
		int i = 2;
		int temp = n >> i;
		int pos = 0;
		if ((temp & 1) != 0) {
			pos = 1;
		}
		System.out.printf("%s 的第 %s 位为 %s", n,i,pos);
	}

}
