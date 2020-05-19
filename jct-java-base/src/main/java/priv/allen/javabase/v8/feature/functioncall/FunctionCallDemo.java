/**
 * 
 */
package priv.allen.javabase.v8.feature.functioncall;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 方法引用通过方法的名字来指向一个方法。
 * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 * 方法引用使用一对冒号 :: 。
 * @author Allen 
 *
 */
public class FunctionCallDemo {
	
	/**
	 * 
	 */
	@Test
	public void testCar() {
		// 构造器引用，创建一个新的实例
		Car car = Car.create(Car::new);
		List<Car> cars = Arrays.asList(car);
		
		// 静态方法引用
		cars.forEach(Car::collide);
		
		// 实例方法引用
		cars.forEach(Car::repair);
		
		// 特定对象的方法引用
		Car police = Car.create(Car::new);
		cars.forEach(police :: follow);
		
	}

	static class Car {
		
		/**
		 * @param supplier
		 * @return Car
		 */
		public static Car create(final Supplier<Car> supplier) {
			return supplier.get();
		}
		
		
		public static void collide(final Car car) {
			System.out.println("Collide " + car.toString()); //$NON-NLS-1$
		}
		
		public void follow(final Car another) {
			System.out.println("Following the " + another.toString()); //$NON-NLS-1$
		}
		
		public void repair() {
			System.out.println("Repaired " + this.toString()); //$NON-NLS-1$
		}
	}
	
}
