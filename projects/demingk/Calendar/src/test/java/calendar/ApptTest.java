package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {

	 	Appt a = new Appt(1,1,1,1,1,"T", "A");
	 	assertTrue(a.getValid());
	 	assertEquals(a.getStartHour(), 1);
		assertEquals(a.getStartMinute(),1);
		assertEquals(a.getStartDay(), 1);
		assertEquals(a.getStartMonth(),1);
		assertEquals(a.getStartYear(), 1);
		assertEquals(a.getTitle(), "T");
		assertEquals(a.getDescription(),"A");
	 }

	 @Test
	  public void test02()  throws Throwable {
      Appt a = new Appt(1,1,1,1,1,"T","A");
      assertTrue(a.getValid());
      int[] b = new int[]{1,2,3};
      int[] c = new int[]{0};
      a.setRecurrence(b,1,1,1);
      assertEquals(a.getRecurDays(), b);
      assertEquals(a.getRecurBy(),1);
      assertEquals(a.getRecurIncrement(), 1);
      assertEquals(a.getRecurNumber(),1);
      assertTrue(a.isRecurring());
      a.setRecurrence(null,1,1,1);
      //assertEquals(a.getRecurDays(), 0);


	 }
	 @Test
	  public void test03() throws Throwable {
      Appt a = new Appt(1,1,1,1,1,"B","A");
      Appt b = new Appt(13,2,2,2,2,"A","B");
      assertTrue(a.getValid());
      assertEquals(a.toString(), "	1/1/1 at 1:1am ,B, A\n");
      assertEquals(b.toString(), "\t2/2/2 at 1:2pm ,A, B\n");
      assertEquals(a.compareTo(b), -16);
	 }
	 @Test
	  public void test04() throws Throwable {
		 Appt a = new Appt(1, 1, 1, 1, 1, "A", "B");
		 assertTrue(a.getValid());
		 a.setDescription("T");
		 assertEquals(a.getDescription(), "T");
		 a.setDescription(null);
		 assertEquals(a.getDescription(),"");
		 a.setTitle(null);
		 assertEquals(a.getTitle(),"");
		 a.setStartDay(3);
		 assertEquals(a.getStartDay(), 3);
		 a.setStartHour(5);
		 assertEquals(a.getStartHour(), 5);
		 a.setStartMinute(6);
		 assertEquals(a.getStartMinute(), 6);
		 a.setTitle("R");
		 assertEquals(a.getTitle(), "R");
		 a.setStartMonth(5);
		 assertEquals(a.getStartMonth(), 5);
		 a.setStartYear(1000);
		 assertEquals(a.getStartYear(), 1000);
		 assertTrue(a.getValid());
	 }
	 @Test
	 public void test05() throws Throwable
	 {
	 	Appt a = new Appt(25,61,32, 10, 0,"LL","LL");
	 	assertFalse(a.getValid());
	 	assertNull(a.toString());
	 	Appt c = new Appt(23,50,20,10,2000,"TT","TT");
	 	c.setStartHour(24);
	 	assertFalse(c.getValid());
	 	c.setStartHour(23);
	 	c.setStartMinute(-1);
	 	assertFalse(c.getValid());
	 	c.setStartMinute(61);
	 	assertFalse(c.getValid());
	 	c.setStartMinute(50);
	 	c.setStartDay(32);
	 	assertFalse(c.getValid());
	 	c.setStartDay(-1);
		 assertFalse(c.getValid());
	 	c.setStartDay(20);
	 	c.setStartMonth(-1);
	 	assertFalse(c.getValid());
	 	c.setStartMonth(40);
		 assertFalse(c.getValid());
	 }

}
