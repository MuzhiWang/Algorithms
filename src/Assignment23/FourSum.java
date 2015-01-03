/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author Muzhi
 */
public class FourSum {
    
    /******** WrongWrongWrong Array without duplication, not correct has error in HashMap since Integer is the sum but could be collision **********/
    public int[] fourSum(int[] array, int sum) {
        if (array == null || array.length <= 4) return null;
        HashMap<Integer, int[]> hashMap = new HashMap<Integer, int[]>();
        Arrays.sort(array);
        int[] twoSumArray = new int[array.length * (array.length - 1) / 2];
        int index = 0;
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                int[] twoSum = {array[i], array[j]};
                hashMap.put(array[i] + array[j], twoSum);
                twoSumArray[index++] = array[i] + array[j];
            }
        }
        Arrays.sort(twoSumArray);
        int[] res = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int left = 0, right = twoSumArray.length - 1;
        while (left < right) {
            if (twoSumArray[left] + twoSumArray[right] < sum) {
                ++left;
            } else if (twoSumArray[left] + twoSumArray[right] > sum) {
                --right;
            } else {
                int[] sumOne = hashMap.get(twoSumArray[left]);
                int[] sumTwo = hashMap.get(twoSumArray[right]);
                if (sumOne[0] != sumTwo[0] && sumOne[1] != sumTwo[0] & sumOne[0] != sumTwo[1] && sumOne[1] != sumTwo[1]) {
                    res[0] = sumOne[0]; res[1] = sumOne[1]; res[2] = sumTwo[0]; res[3] = sumTwo[1];
                    return res;
                } else {
                    ++left;
                } 
            }
        }
        return res;
    }
    
    /******** Array with duplication, build object, no need HashMap  **********/
    public int[] fourWithDu(int[] array, int sum) {
        if (array == null || array.length < 4) return null;
        element[] pairSum = new element[array.length * (array.length - 1) / 2];
        int index = 0;
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                pairSum[index++] = new element(i, j, array[i] + array[j]);
            }
        }
        Arrays.sort(pairSum, new Comparator<element>() {
            @Override
            public int compare(element one, element two) {
                return one.sum - two.sum;
            }
        });
        int left = 0, right = pairSum.length - 1;
        while(left < right) {
            element leftEle = pairSum[left];
            element rightEle = pairSum[right];
            if (leftEle.sum + rightEle.sum == sum && leftEle.left != rightEle.left && leftEle.left != rightEle.right 
                    && leftEle.right != rightEle.left && leftEle.right != rightEle.right ) {
                int[] res = {array[leftEle.left], array[leftEle.right], 
                    array[rightEle.left], array[rightEle.right]};
                return res;
            } else if (leftEle.sum + rightEle.sum < sum) {
                ++left;
            } else if (leftEle.sum + rightEle.sum > sum) {
                --right;
            }
        }
        return null;
    }
    
    static class element implements Comparator<element> {
        int left, right, sum;
        element(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }
        
        @Override
        public int compare(element one, element two) {
            return one.sum - two.sum;
        }
    }
    
    
    public static void main(String[] args) {
        int[] array = {-5,-2,-2,1,1,1,7,7,7,8,8};
        int sum = 9;
        FourSum four = new FourSum();
        //int[] res = four.fourSum(array, sum);
        //System.out.println(Arrays.toString(res));
        int[] res = four.fourWithDu(array, sum);
        System.out.println(Arrays.toString(res));
        
    }
    
}
