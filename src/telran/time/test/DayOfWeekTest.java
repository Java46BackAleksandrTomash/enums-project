package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.time.DayOfWeek;

public class DayOfWeekTest {
private static final String YOM_RISHON = "יום ראשון";
private static final String SHABBAT = "שבת";
private static final String OTHER_YOM = "other";

String getHeebrewDayOfWeek(DayOfWeek weekDay) {
	switch(weekDay) {
	case SUN: return YOM_RISHON; 
	case SHABBAT: return SHABBAT;
	default: return OTHER_YOM;
	
	}
}
@Test
void hebrewDayTest() {
	assertEquals(YOM_RISHON, getHeebrewDayOfWeek(DayOfWeek.SUN));
	assertEquals(SHABBAT, getHeebrewDayOfWeek(DayOfWeek.SHABBAT));
}
@Test
void toStringTest() {
	assertEquals("FRI", DayOfWeek.FRI.toString());
}
@Test
void valueTest() {
	assertEquals(DayOfWeek.SHABBAT, DayOfWeek.valueOf("SHABBAT"));
}
@Test
void compareTest() {
	assertTrue(DayOfWeek.SHABBAT.compareTo(DayOfWeek.SUN) > 0);
}
@Test
void pluseDaysTest() {
	assertEquals(DayOfWeek.SHABBAT, DayOfWeek.THU.pluseDays(2));
	assertEquals(DayOfWeek.THU, DayOfWeek.THU.pluseDays(7));
	assertEquals(DayOfWeek.SHABBAT, DayOfWeek.THU.pluseDays(1003));
}
@Test
void betweenTest() {
	assertEquals(2, DayOfWeek.between(DayOfWeek.THU, DayOfWeek.SHABBAT));
	assertEquals(6, DayOfWeek.between(DayOfWeek.THU, DayOfWeek.WED));
	assertEquals(7, DayOfWeek.between(DayOfWeek.SHABBAT, DayOfWeek.SHABBAT));
	
}
}
