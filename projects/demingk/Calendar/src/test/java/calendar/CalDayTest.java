package calendar;

import java.util.GregorianCalendar;

/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
        import org.junit.Test;
        import static org.junit.Assert.*;

        public class CalDayTest {
            @Test
            public void test01() throws Throwable
            {
                CalDay a = new CalDay();
                assertFalse(a.valid);
                assertNull(a.iterator()); //test iterator null
            }
            GregorianCalendar b = new GregorianCalendar(1996,2,9);
            @Test
            public void test02() throws Throwable
            {

                CalDay a = new CalDay(b);
                assertTrue(a.isValid());
                assertEquals(a.getDay(), 9);
                assertEquals(a.getMonth(),2);
                assertEquals(a.getYear(), 1996);
                Appt c = new Appt(3,3,3,3,3,"D","D");
                a.addAppt(c);
                c.setStartYear(5);
                a.addAppt(c);
                c.setStartDay(6);
                a.addAppt(c);
                assertEquals(a.getAppts().getFirst().getStartHour(),3);
                assertEquals(a.getAppts().get(1).getStartYear(),5);
                assertEquals(a.getAppts().getLast().getStartDay(),6);
                assertNotNull(a.iterator());
                c.setStartMonth(12);
                /*Checks to see if 12 is incorrect since it is cause it should be 0 - 11*/
                assertFalse(c.getValid());
                c.setStartMonth(11);
                a.addAppt(c);
            }
            @Test
            public void test03() throws Throwable
            {
                CalDay a = new CalDay(b);
                assertEquals(a.getSizeAppts(), 0);
                Appt c = new Appt(2,3,4,5,6,"T","Y");
                a.addAppt(c);
                c.setStartHour(1);
                a.addAppt(c);
                assertNotEquals(a.toString(),"");
                assertEquals(a.getAppts().getFirst().getStartHour(), 1);
            }

}
