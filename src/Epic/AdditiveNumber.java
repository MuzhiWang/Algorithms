/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class AdditiveNumber {
    
    public List<Integer> additiveNumber(int start, int end) {
        if (end < 101 || start > end) 
            return null;
        
        List<Integer> res = new ArrayList<>();
        for (int i = start; i <= end; ++i) {
            if (isAdditive(i)) 
                res.add(i);
        }
        return res;
        
    }
    
    private boolean isAdditive(int num) {
        String numStr = Integer.toString(num);
        return isAdditiveHelper(numStr);
    }
    
    private boolean isAdditiveHelper(String numStr) {
        if (numStr.length() < 3)
            return false;
        int len = numStr.length();
        for (int i = 1; i < len - 1; ++i) {
            String first = numStr.substring(0, i);
            int numFirst = Integer.valueOf(first);
            for (int j = i + 1; j < len; ++j) {
                String second = numStr.substring(i, j);
                int numSecond = Integer.valueOf(second);
                for (int k = j + 1; k < len + 1; ++k) {
                    String left = numStr.substring(j, k);
                    int numLeft = Integer.valueOf(left);
                    
                    /* 
                    Here you have to consider about the situation of 0 + 0 = 0 
                    but you also need to deal with the numFirst and numSecond with 0,
                    e.g. 1001 should be false, 1010011 should also be false
                    */
                    if (k == j + 1 && numLeft == 0) {
                        if (numFirst + numSecond != 0)
                            break;
                        else if (k == len)
                            return true;
                        else if (isAdditiveHelper(numStr.substring(k)))
                            return true;
                    }
                        
                    if (numFirst + numSecond == numLeft) {
                        if (k == len) 
                            return true;
                        else if (isAdditiveHelper(numStr.substring(k)))
                            return true;
                    }
                }
            }
        }
        return false;
    }
    
    /* This is other people's solution from internet, with bug when input contain 0, e.g. 112033 */
    public static boolean isAdditiveNumber(String number) {
		for(int i=1;i<number.length();i++)
		{
			for(int j=i+1;j<number.length();j++)
			{
				int part1_tmp = Integer.parseInt(number.substring(0,i));
				int part2 = Integer.parseInt(number.substring(i,j));
				int index= j;
				int rest = Integer.parseInt(number.substring(j,number.length()));
				while(part1_tmp+part2<=rest)
				{
					int part3 = part1_tmp+part2;
					String str = Integer.toString(part3);
					int length = str.length();
					if(index + length > number.length())
					{
						break;
					}
					if(number.substring(index,index+length).equals(str))
					{
						index=length+index;
						if(index==number.length())
						{
							return true;
						}
						part1_tmp = part2;
						part2 = part3;
						rest =Integer.parseInt(number.substring(index,number.length()));
					}
					else
					{
						break;
					}
				}
			}
		}
                return false;
            }
    
    public static void main(String... args) {
        AdditiveNumber addi = new AdditiveNumber();
        List<Integer> res = new ArrayList<>();
        res = addi.additiveNumber(100000, 1000000);
        System.out.println(res.size());
        
        int num = 112033;
        addi.isAdditive(num);
        System.out.println(addi.isAdditive(num));
        
        System.out.println(Arrays.toString(res.toArray()));
        System.out.println(AdditiveNumber.isAdditiveNumber(String.valueOf(num)));
    }
    
}
