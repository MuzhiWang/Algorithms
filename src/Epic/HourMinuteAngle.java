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

/*	We are given a specific time (like 02:23), we need to get
 *	the angle between hour and minute (less than 180);
 *
 */


public class HourMinuteAngle {
    /// assume the imput time is of the format: 12:30
    public float angle(String time) {
        assert time != null && time.length() > 0;
        String[] timeParts = time.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);
        float res = (float)Math.abs((float)hour * 30 + (float)minute * 0.5 - (float)minute * 6);
        return res > 180 ? 360 - res : res;
    }
    
    public static void main(String... args) {
        HourMinuteAngle hm = new HourMinuteAngle();
        System.out.println(hm.angle("11:59"));
        
    }
    
}
