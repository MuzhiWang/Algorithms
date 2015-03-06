/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.ArrayList;
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
    public List<List<Integer>> getBattery(int num) {
        assert num > 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int leftNum = num;
        int index = 0;
        int[  
        return res;
    }
    
    private void getBatteryHelper(List<List<Integer>> res, List<Integer> cur, int leftNum, int index) {
        if (leftNum == 0) {
            res.add(cur);
            return;
        }
        if (leftNum < 0) return;
        for (int i = index; i < 3; ++i) {
            while (leftNum - 
        }
        
    }
    
}
