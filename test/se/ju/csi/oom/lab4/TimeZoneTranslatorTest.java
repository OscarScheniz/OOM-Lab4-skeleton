package se.ju.csi.oom.lab4;
import java.lang.Object;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		
		DateTime testDate = new DateTime(2018, 10, 5, 9, 0, 00);
		testDate = TimeZoneTranslator.shiftTimeZone(testDate, -10, 0);
		
		assertEquals(testDate.toString(), "2018-10-05 19:00:00");
		
		
		DateTime test2 = new DateTime(2016, 1, 1, 6, 0, 00);
		test2 = TimeZoneTranslator.shiftTimeZone(test2, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(), TimeZone.US_PACIFIC.getOffset());
		assertEquals(test2.toString(), "2015-12-31 21:00:00");
		
		
		//test2
		DateTime testDate1 = new DateTime(2018, 10, 13, 9, 00, 00);
		String date = "2018-10-13 09:00:00";
		DateTime string = new DateTime(date);
		
		
		assertEquals(testDate1.toString(), "2018-10-13 09:00:00");
		assertEquals(string.toString(), "2018-10-13 09:00:00");
		
	}

	@Test
	public void testShiftEventTimeZone() {
		
		//TimeZoneTranslator test = new TimeZoneTranslator();
		
		String eventTest = new String("Eventtest");
		DateTime startTime = new DateTime(2018, 10, 05, 12, 00, 00);
		DateTime endTime = new DateTime(2018, 10, 05, 12, 00, 00);
		Person Emil = new Person("Emil");
		Person Ludvig = new Person("Ludvig");
		Place Stockholm = new Place("Stockholm", 59.3293, 18.0686, 10.0);
		Event testEvent = new Event(eventTest, startTime, endTime, new HashSet<>(Arrays.asList(Emil, Ludvig)), Stockholm);
		
		//Skriv ut vart dem är och vart dem åker
		System.out.println(testEvent.toString());
		//testEvent.setEndDate(new DateTime (2019, 1, 1, 0, 0, 0));
		testEvent = TimeZoneTranslator.shiftEventTimeZone(testEvent, TimeZone.AZORES, TimeZone.HALIFAX);
		System.out.println(testEvent.toString());
		
		assertEquals(testEvent.getStartDate().toString(), "2018-10-05 09:00:00");
		assertEquals(testEvent.getEndDate().toString(), "2018-10-05 09:00:00");
	}

}
