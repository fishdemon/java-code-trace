/**
 * 
 */
package priv.allen.javabase.v8.feature.time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * @author Allen
 *
 */
public class TimeDemo {
	
	/**
	 * 
	 */
	@Test
	public void testInstant() {
		Instant now = Instant.now();
		System.out.println(now);
	}
	
	/**
	 * 
	 */
	@Test
	public void testLocalDateTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime);
		
		LocalDate localDate = currentDateTime.toLocalDate();
		System.out.println(localDate);
		
		LocalTime localTime = currentDateTime.toLocalTime();
		System.out.println(localTime);
		
		Month month = currentDateTime.getMonth();
		System.out.println(month.name());
		System.out.println(month.getValue());
		
		int dayOfYear = currentDateTime.getDayOfYear();
		int dayOfMonth = currentDateTime.getDayOfMonth();
		DayOfWeek dayOfWeek = currentDateTime.getDayOfWeek();
		System.out.println(dayOfYear);
		System.out.println(dayOfMonth);
		System.out.println(dayOfWeek);
		
		int hour = currentDateTime.getHour();
		int minute = currentDateTime.getMinute();
		int second = currentDateTime.getSecond();
		System.out.println(hour + ":" + minute + ":" + second); //$NON-NLS-1$ //$NON-NLS-2$
		
		System.out.println(currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); //$NON-NLS-1$
	}
	
	/**
	 * 
	 */
	@Test
	public void testZonedDateTime(){
		// 时区时间
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		
		// 当前时区
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println(zoneId);
		
		System.out.println(zonedDateTime.toEpochSecond());
	}

}
