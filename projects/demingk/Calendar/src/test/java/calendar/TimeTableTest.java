package calendar;

import java.util.GregorianCalendar;

/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import org.junit.Test;
import static org.junit.Assert.*;
public class TimeTableTest {

    @Test
    public void test01() throws Throwable
    {
    GregorianCalendar c = new GregorianCalendar(1996,7,23);
    GregorianCalendar d = new GregorianCalendar(1996,7,26);
    CalDay b = new CalDay(c);
    Appt s = new Appt(5,5,24,7,1996,"G","F");
    b.addAppt(s);
    s.setStartDay(25);
    b.addAppt(s);
    TimeTable a = new TimeTable();
    a.getApptRange(b.getAppts(), c ,d);
    s.setStartHour(7);
    b.addAppt(s);
    s.setStartHour(9);
    b.addAppt(s);
    a.getApptRange(b.getAppts(),c,d);
    int[] w = new int[]{0,1};
    int[] v = new int[]{0,1,2,3};
    assertEquals(b.getSizeAppts(),v.length);
    //a.permute(b.getAppts(),w);
    //a.permute(b.getAppts(),v); //should return error
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
        d.setRecurrence(e,2,3, 6);
        TimeTable f = new TimeTable();
        assertNull(f.deleteAppt(c.getAppts(),d));
        f.getApptRange(c.getAppts(),a,b);
        d.setStartMinute(61);
        assertNull(f.deleteAppt(c.getAppts(),d));
    }
    @Test
    public void test03() throws Throwable {
        GregorianCalendar a = new GregorianCalendar(2001, 8, 17);
        GregorianCalendar b = new GregorianCalendar(2001, 9, 17);
        CalDay c = new CalDay(a);
        Appt d = null;
        TimeTable f = new TimeTable();
        assertNull(f.deleteAppt(c.getAppts(), d));

    }
    @Test
    public void test04() throws Throwable
    {
        GregorianCalendar a = new GregorianCalendar(2009,8,17);
        GregorianCalendar b = new GregorianCalendar(2007,9,18);
        GregorianCalendar e = new GregorianCalendar(2008, 10,10);
        GregorianCalendar f = new GregorianCalendar(2008, 8,10);
        CalDay c = new CalDay(b);
        Appt d = new Appt (15,12,5,9,2008,"Lunch","With Friends");
        c.addAppt(d);
        TimeTable g = new TimeTable();
        g.getApptRange(c.getAppts(),b,f); //out of range below
        g.getApptRange(c.getAppts(),e,a); //out of range above
    }
}
