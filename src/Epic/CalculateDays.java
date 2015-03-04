/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

/**
 *
 * @author Muzhi
 */

/*
Give two date, calculate the days between them. The date format should be String like 01012014 (DD MM YY)
*/
public class CalculateDays {
    public int days(String date1, String date2) {
        assert date1.length() == 8 && date2.length() == 8;
        if (compareDate(date1, date2)) {
            String temp = date1;
            date1 = date2;
            date2 = temp;
        }
        int firstDate = Integer.parseInt(date1.substring(0, 2));
        int secondDate = Integer.parseInt(date2.substring(1, 2));
        int firstMonth = Integer.parseInt(date1.substring(2, 4));
        int secondMonth = Integer.parseInt(date2.substring(2, 4));
        int firstYear = Integer.parseInt(date1.substring(4));
        int secondYear = Integer.parseInt(date2.substring(4));
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        
        /// first add firstYear to secondYear - 1. e.g.  date1 = 02082005 date2 = 01022013
        /// add date1 = 0208 2005  -->  0208 2012
        if (firstYear < secondYear - 1) {
            for (int i = firstYear; i < secondYear - 1; ++i) {
                if (leapYear(i)) 
                    res += 366;
                else
                    res += 365;
                firstYear++;
            }
        }
        
        /// if firstYear == secondYear - 1, add firstMonth to secondMonth
        /// e.g. add date1 = 02 08 2012  -->  02 02 2013
        /// e.g. add date1 = 02 08 2012  --> 02 12 2012 if date2 = 01122012
        if (firstYear == secondYear - 1) {
            /// first situation while firstMonth <= secondMonth
            if (firstMonth <= secondMonth) {
                if (leapYear(firstYear))
                    res += 366;
                else 
                    res += 365;
                for (int i = firstMonth; i < secondMonth; ++i) {
                    if (i == 2 && leapYear(firstYear))
                        res += 29;
                    else 
                        res += monthDays[i];
                    firstMonth++;
                }
            /// second situation while firstMonth > secondMonth like 02 08 2012 & 01 02 2013
            } else {
                for (int i = firstMonth; i < secondMonth + 12; ++i) {
                    int tempMonth = (i > 12) ? i - 12 : i;
                    if (i == 2 && leapYear(firstYear) || (i == 14 && leapYear(secondYear)))
                        res += 29;
                    else 
                        res += monthDays[tempMonth];
                }
            }
        /// if firstYear == secondYear, it means firstMonth <= secondMonth, so add firstMonth upto secondMonth
        } else if (firstYear == secondYear) {
            if (firstMonth < secondMonth) {
                for (int i = firstMonth; i < secondMonth; ++i) {
                    if (i == 2 && leapYear(firstYear))
                        res += 29;
                    else 
                        res += monthDays[i];
                    firstMonth++;
                }
            }
        }
        
        /// at last add the date difference.
        res += secondDate - firstDate;
        
        return res;
    }
    
    private boolean leapYear(int year) {
        return (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0));
    }
    
    private boolean compareDate(String date1, String date2) {
        String dateCom1 = date1.substring(4) + date1.substring(2, 4) + date1.substring(0, 2);
        String dateCom2 = date2.substring(4) + date2.substring(2, 4) + date2.substring(0, 2);
        return Integer.parseInt(dateCom1) > Integer.parseInt(dateCom2);
    }
    
    
    /* This is other people's solution, it is wrong without doubt */
    public void dates(String date1,String date2){
			int dd1 = Integer.parseInt(date1.substring(0, 2));
			int dd2 = Integer.parseInt(date2.substring(0, 2));
			int mm1 = Integer.parseInt(date1.substring(2, 4));
			int mm2 = Integer.parseInt(date2.substring(2, 4)) ;
			int yy1 = Integer.parseInt(date1.substring(4));
			int yy2 = Integer.parseInt(date2.substring(4));
			int num_days=0;
			int[] days = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			if(yy1!=yy2){
				for(int i=yy1;i<yy2;++i){
					if(leapYear(i)) num_days+=366;
					else num_days+=365;
				}
				if(leapYear(yy2)) days[2]=29;
				System.out.println(days[2]);
				num_days+=dd2;
				for(int i=1;i<mm2;++i) num_days+=days[i];
			}
			else{
				if(leapYear(yy1)) days[2]=29;
				num_days=days[mm1]-dd1;
				if(mm1!=mm2)num_days+=dd2;
				for(int i=mm1+1;i<mm2;++i){
					num_days+=days[i];
					}
			}
			System.out.println(num_days);
		}
    
    public static void main(String... args) {
        CalculateDays cal = new CalculateDays();
        int res = cal.days("02082005", "01022013");
        boolean test = cal.compareDate("02082005", "01022013");
        System.out.println(res);
        
        /// the result is totally wrong
        cal.dates("02082005", "01022013");
    }
}
