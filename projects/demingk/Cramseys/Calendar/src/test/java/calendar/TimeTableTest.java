package calendar;

import java.util.Random;
import java.util.GregorianCalendar;

/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
public class TimeTableTest {

    @Test
    public void test01() throws Throwable
    {
        Random rand = new Random();
    GregorianCalendar c = new GregorianCalendar(1996,7,23);
    GregorianCalendar d = new GregorianCalendar(1996,7,26);
    CalDay b = new CalDay(c);
    Appt s = new Appt(5,5,24,7,1996,"G","F");
    b.addAppt(s);
        for(int i = 0; i < 50; i++)
        {
            s.setStartHour(rand.nextInt(50)+1);
            b.addAppt(s);
            s.setStartHour(rand.nextInt(50)* (-1));
            b.addAppt(s);
        }
        for(int i = 0; i < 100; i++)
        {
            s.setStartMinute(rand.nextInt(70)+1);
            b.addAppt(s);
            s.setStartMinute(rand.nextInt(60)*(-1));
            b.addAppt(s);
        }
        for(int i = 0; i < 50; i++)
        {
            s.setStartDay(rand.nextInt(50)+1);
            b.addAppt(s);
            s.setStartDay(rand.nextInt(50)*(-1));
            b.addAppt(s);
        }
        for(int i = 0; i < 20; i++)
        {
            s.setStartMonth(rand.nextInt(20)+1);
            b.addAppt(s);
            s.setStartMonth(rand.nextInt(20)*(-1));
            b.addAppt(s);
        }
        for(int i = 0; i < 200; i++)
        {
            s.setStartYear(rand.nextInt(3000)+1);
            b.addAppt(s);
            s.setStartYear(rand.nextInt(3000)*(-1));
            b.addAppt(s);
        }
    b.addAppt(s);
    TimeTable a = new TimeTable();
    a.getApptRange(b.getAppts(), c ,d);
    Appt p = new Appt(15,12,5,9,2001,"Work","workstuff");
        for(int i = 0; i < 50; i++)
        {
            p.setStartHour(rand.nextInt(50)+1);
            a.deleteAppt(b.getAppts(),p);
            p.setStartHour(rand.nextInt(50)* (-1));
            a.deleteAppt(b.getAppts(),p);
        }
        for(int i = 0; i < 100; i++)
        {
            p.setStartMinute(rand.nextInt(70)+1);
            a.deleteAppt(b.getAppts(),p);
            p.setStartMinute(rand.nextInt(60)*(-1));
            a.deleteAppt(b.getAppts(),p);
        }
        for(int i = 0; i < 50; i++)
        {
            p.setStartDay(rand.nextInt(50)+1);
            a.deleteAppt(b.getAppts(),p);
            p.setStartDay(rand.nextInt(50)*(-1));
            a.deleteAppt(b.getAppts(),p);
        }
        for(int i = 0; i < 20; i++)
        {
            p.setStartMonth(rand.nextInt(20)+1);
            a.deleteAppt(b.getAppts(),p);
            p.setStartMonth(rand.nextInt(20)*(-1));
            a.deleteAppt(b.getAppts(),p);
        }
        for(int i = 0; i < 200; i++)
        {
            p.setStartYear(rand.nextInt(3000)+1);
            a.deleteAppt(b.getAppts(),p);
            p.setStartYear(rand.nextInt(3000)*(-1));
            a.deleteAppt(b.getAppts(),p);
        }
    s.setStartHour(7);
    b.addAppt(s);
    s.setStartHour(9);
    b.addAppt(s);
    a.getApptRange(b.getAppts(),c,d);
    int[] w = new int[]{0,1};
    int[] v = new int[]{0,1,2,3};
    assertEquals(b.getSizeAppts(),v.length);
    a.permute(b.getAppts(),w);
    a.permute(b.getAppts(),v); //should return error
    }
    @Test
    public void testDOR() throws Throwable
    {
        GregorianCalendar a = new GregorianCalendar(2001, 8,19);
        GregorianCalendar b = new GregorianCalendar(2001,8,18);
        CalDay c = new CalDay(a);
        Appt e = new Appt(1,2,3,4,5,"" +
                "","");
        c.addAppt(e);
        TimeTable d = new TimeTable();
        d.getApptRange(c.getAppts(),a,b); //this should throw a out of range exception GIVE AN ERROR
    }

    @Test
    public void test02() throws Throwable
    {
        GregorianCalendar a = new GregorianCalendar(2001,8,17);
        GregorianCalendar b = new GregorianCalendar(2001,9,17);
        CalDay c = new CalDay(a);
        Appt d = new Appt(15,12,5,9,2001,"Work","workstuff");
        c.addAppt(d);
        int[] e = new int[]{5,7};
        d.setRecurrence(e,2,3,6);
        TimeTable f = new TimeTable();
        assertNull(f.deleteAppt(c.getAppts(),d));
        f.getApptRange(c.getAppts(),a,b);
        d.setStartMinute(61);
        assertNull(f.deleteAppt(c.getAppts(),d));
    }
    @Test
    public void test03() throws Throwable
    {
        GregorianCalendar a = new GregorianCalendar(2001,8,17);
        GregorianCalendar b = new GregorianCalendar(2001,9,17);
        CalDay c = new CalDay(a);
        Appt d = null;
        TimeTable f = new TimeTable();
        assertNull(f.deleteAppt(c.getAppts(),d));

    }

}
