/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Muzhi
 */

/*	Given a date(month/day/year) from user. Print out the week of the
 *	dates (Sun to Sat)
 *	Example:
 *	Input 12/20/2014;
 *	Output 
 *	Sunday 12/13/2014
 *	Monday 12/14/2014
 *	...
 *	Saturday 12/20/2014
 */	

public class MyCalendar {
    public String[] showWeek(String date) throws ParseException {
        assert date != null && date.length() == 10;
        String[] dateParts = date.split("/");
        int year = Integer.parseInt(dateParts[2]);
        int month = Integer.parseInt(dateParts[0]);
        int day = Integer.parseInt(dateParts[1]);
        String[] dayOfWeek = {" ", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] dayOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
        Date myDate = format.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        int curDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        //System.out.println(curDayOfWeek);
        
        
        String[] res = new String[8];
        
        /// calculate the date from Sunday to cur date of week;
        /// remind of when over two month, especially in leap year. e.g. 02/27/2000 - 03/4/2000
        for (int i = 1; i < curDayOfWeek; ++i) {
            res[i] = dayOfWeek[i] + " ";
            if (day - (curDayOfWeek - i) < 1) {
                int tempMonth = (month == 1) ? 12 : month - 1;
                int tempYear = (month == 1) ? year - 1 : year;
                int tempDay = day + dayOfMonth[tempMonth] - (curDayOfWeek - i);
                /// leap year
                if (tempMonth == 2 && leapYear(year)) {
                    tempDay++;
                }
                res[i] += tempMonth + "/" + tempDay + "/" + tempYear;
            } else {
                int tempDay = day - (curDayOfWeek - i);
                res[i] += month + "/" + tempDay + "/" + year;
            }
        }
        
        /// calculate the date from cur date of week to Saturday.
        /// remind of when over two month, especially in leap year. e.g. 02/27/2000 - 03/04/2000
        for (int i = curDayOfWeek; i < 8; ++i) {
            res[i] = dayOfWeek[i] + " ";
            if (day + (i - curDayOfWeek) > dayOfMonth[month]) {
                int tempMonth = (month == 12) ? 1 : month + 1;
                int tempYear = (month == 12) ? year + 1 : year;
                int tempDay = day + i - curDayOfWeek - dayOfMonth[month];
                /// leap year
                if (tempMonth == 3 && leapYear(year) && tempDay >= 1) {
                    if (tempDay == 1) {
                        tempDay = 29;
                        tempMonth = 2;
                    } else 
                        tempDay--;
                }
                res[i] += tempMonth + "/" + tempDay + "/" + tempYear;
            } else {
                int tempDay = day + (i - curDayOfWeek);
                res[i] += month + "/" + tempDay + "/" + year;
            }
        }
        return res;
    }
    
    private boolean leapYear(int year) {
        return year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
    }
    
    public static void main(String... args) throws ParseException {
        String input = "03/01/2000";
        SimpleDateFormat format1 = new SimpleDateFormat("M/d/yyyy");
        
        Date myDate = format1.parse(input);
        System.out.println(myDate);
        format1.applyPattern("EEEE");
        String myDateStr = format1.format(myDate);
        System.out.println(myDateStr);
        format1.applyPattern("E");
        myDateStr = format1.format(myDate);
        System.out.println(myDateStr);
        int dayOfWeek = myDate.getDate();
        System.out.println(dayOfWeek);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        int calDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("test date " + calDayOfWeek);
        System.out.println(cal.get(Calendar.DATE) + "\n\n");
        
        System.out.println("The results are: ");
        MyCalendar myCal = new MyCalendar();
        String[] res = myCal.showWeek(input);
        for (String s : res) {
            System.out.println(s);
        }
    }
    
}
