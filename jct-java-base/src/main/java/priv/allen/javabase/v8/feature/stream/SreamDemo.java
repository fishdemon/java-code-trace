/**
 * 
 */
package priv.allen.javabase.v8.feature.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author Allen 
 *
 */
public class SreamDemo {
	
	List<Integer> numbers = Arrays.asList(16, 51, 28, 39, 14, 26, 45);
	
	/**
	 * 获取最小值与最大值
	 */
	@Test
	public void getMinAndMax() {
		Stream<Integer> stream = numbers.stream();
		Optional<Integer> min = stream.min(Integer::compareTo);
		if (min.isPresent()) {
			System.out.println(min.get());
		}
		
		/**
		 * 流不可以被复用，下面获取最大值的代码会报错
		 * 如果要获取最大值，我们需要重新建流：numbers.stream()
		 */
//		Optional<Integer> max = stream.max(Integer::compareTo);
//		if (max.isPresent()) {
//			System.out.println(max.get());
//		}
		
		/**
		 * 将获取最大值实现出来
		 */
		Stream<Integer> maxStream = numbers.stream();
		Optional<Integer> max = maxStream.max(Integer::compareTo);
		if (max.isPresent()) {
			System.out.println(max.get());
		}
		
		/**
		 * 用流式写法来实现上面获取最大值的功能
		 * 下面这个流式写法是不是很帅气
		 * 
		 */
		numbers.stream().max(Integer::compareTo).ifPresent(System.out::println);
	}
	
	/**
	 * 获取排序结果
	 * 使用forEach 与 lamada 表达式很优美的完成
	 */
	@Test
	public void getSort() {
		System.out.println("将numbers进行排序："); //$NON-NLS-1$
		Stream<Integer> sortStream = numbers.stream().sorted();
		sortStream.forEach(elem -> System.out.print(elem + " ")); //$NON-NLS-1$
	}
	
	/**
	 * 过滤结果
	 * 获取大于25小于45，并进行排序后的数据
	 */
	@Test
	public void getFilter() {
		System.out.println("将numbers过滤并排序："); //$NON-NLS-1$
		numbers.stream().filter(elem -> elem > 25)
						.filter(elem -> elem < 45)
						.sorted(Integer::compareTo)
						.forEach(System.out::println);
		System.out.println("======End======"); //$NON-NLS-1$
		
		// 经过了这么多的操作我们再来看看源List中的数据
		System.out.println("原numbers中的数据："); //$NON-NLS-1$
		numbers.forEach(elem -> System.out.print(elem + " ")); //$NON-NLS-1$
		System.out.println("\n======End======"); //$NON-NLS-1$
	}
	
	/**
	 * 16, 51, 28, 39, 14, 26, 45 -> 28, 39, 14
	 * 截取其中的部分数据，从第3个开始到第5个结束，[2,4]
	 * skip(n): 从头开始跳过n个元素
	 * limit(n): 从当前元素开始，限制获取n个元素
	 */
	@Test
	public void getSkipAndLimit() {
		System.out.println("跳过2个元素后再截取3个元素："); //$NON-NLS-1$
		numbers.stream()
			   .skip(2)
			   .limit(3)
			   .forEach(elem -> System.out.print(elem + " ")); //$NON-NLS-1$
		System.out.println("\n======End======"); //$NON-NLS-1$
	}
	
	/**
	 * 
	 */
	@Test
	public void getMatch() {
		boolean match = numbers.stream().allMatch(elem -> elem > 21);
		System.out.println("判断所有的元素是否都大于21：" + match); //$NON-NLS-1$
		
		match = numbers.stream().anyMatch(elem -> elem > 21);
		System.out.println("判断其中是否有元素大于21：" + match); //$NON-NLS-1$
		
		match = numbers.stream().noneMatch(elem -> elem > 21);
		System.out.println("判断所有元素是否都小于等于21：" + match); //$NON-NLS-1$
	}
	
}
