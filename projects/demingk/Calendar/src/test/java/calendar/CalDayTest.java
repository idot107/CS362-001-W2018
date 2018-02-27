package calendar;

import java.util.GregorianCalendar;
import java.util.Random;
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
                c.setStartMonth(13);
                a.addAppt(c);
            }
            @Test
            public void test03() throws Throwable
            {
                Random rand = new Random();
                CalDay a = new CalDay(b);
                assertEquals(a.getSizeAppts(), 0);
                Appt c = new Appt(2,3,4,5,6,"T","Y");
                a.addAppt(c);
                c.setStartHour(1);
                a.addAppt(c);
                assertNotEquals(a.toString(),"");
                assertEquals(a.getAppts().getFirst().getStartHour(), 1);
                for(int i = 0; i < 50; i++)
                {
                    c.setStartHour(rand.nextInt(50)+1);
                    a.addAppt(c);
                    c.setStartHour(rand.nextInt(50)* (-1));
                    a.addAppt(c);
                }
                for(int i = 0; i < 100; i++)
                {
                    c.setStartMinute(rand.nextInt(70)+1);
                    a.addAppt(c);
                    c.setStartMinute(rand.nextInt(60)*(-1));
                    a.addAppt(c);
                }
                for(int i = 0; i < 50; i++)
                {
                    c.setStartDay(rand.nextInt(50)+1);
                    a.addAppt(c);
                    c.setStartDay(rand.nextInt(50)*(-1));
                    a.addAppt(c);
                }
                for(int i = 0; i < 20; i++)
                {
                    c.setStartMonth(rand.nextInt(20)+1);
                    a.addAppt(c);
                    c.setStartMonth(rand.nextInt(20)*(-1));
                    a.addAppt(c);
                }
                for(int i = 0; i < 200; i++)
                {
                    c.setStartYear(rand.nextInt(3000)+1);
                    a.addAppt(c);
                    c.setStartYear(rand.nextInt(3000)*(-1));
                    a.addAppt(c);
                }
            }


}
