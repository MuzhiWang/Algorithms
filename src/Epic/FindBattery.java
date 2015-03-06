/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Muzhi
 */

/*电池有6节包装，9节包装，20节包装三种，input需要多少节电池，如果可以刚好用3种包装的凑到这个数，就输出这个解， 忘了是不是要输出所有的解。
e.g 输入20， 答{20} 输入17 答没有 输入18，那可能是{6,6,6}也可能是{9,9}。 有点像找钱的问题，似乎是从集合中找到所有集合值等于一个target这个题的简化版，因为集合只有6 9 20。
如果是要求输出所有可能：DFS
*/

public class FindBattery {
    public ArrayList<ArrayList<Integer>> getBattery(int num) {
        assert num > 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        int leftNum = num;
        int[] battery = {6, 9, 20};
        
        getBatteryHelper(res, cur, leftNum, 0, battery);
        
        return res;
    }
    
    private void getBatteryHelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int leftNum, int index, int[] battery) {
        if (leftNum == 0) {
            /// Notice here!! Should not directly use res.add(cur) since cur would be change in the code.
            res.add(new ArrayList<Integer>(cur));
            //System.out.println(Arrays.toString(cur.toArray()));
            return;
        }
        if (leftNum < 0 || index > 2) return;
        int count = 0;
        while (leftNum - battery[index] * count >= 0) {
            for (int i = 0; i < count; ++i)
                cur.add(battery[index]);
            getBatteryHelper(res, cur, leftNum - battery[index] * count, index + 1, battery);
            for (int i = 0; i < count; ++i)
                cur.remove(cur.size() - 1);
            count++;
        }
    }
    
    public static void main(String... args) {
        FindBattery fb = new FindBattery();
        ArrayList<ArrayList<Integer>> res = fb.getBattery(24);
        
        for (List<Integer> l : res) {
            System.out.println(Arrays.toString(l.toArray()));
        }
        
        for (int i = 0; i < res.size(); ++i) {
            //System.out.println(res.get(i).get(0));
        }
    }
}
