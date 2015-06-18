/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment25;

import java.util.Arrays;

/**
 *
 * @author Muzhi
 */
public class FindTheKthSmallestEleInTwoArrayLogN {
    public int findTheKthSmallestEleInTwoArrayLogN(int[] a1, int[] a2, int k) {
        if (a1.length == 0 || a2.length == 0) {
            if (a1.length != 0) {
                if (a1.length >= k) 
                    return a1[k - 1];
                else {
                    System.out.println("Input error, input arrays' length less than k");
                    return Integer.MIN_VALUE;
                }
            } else if (a2.length > k)
                return a2[k - 1];
            else {
                System.out.println("Input error, input arrays' length less than k");
                return Integer.MIN_VALUE;
            }
        } else if (a1.length + a2.length < k) {
            System.out.println("Input error, input arrays' length less than k");
            return Integer.MIN_VALUE;
        }
        
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        return logNSolutionHelper(a1, a2, 0, 0, k);
    } 
    
    private int logNSolutionHelper(int[] a1, int[] a2, int a1Left, int a2Left, int k) {
        if (k == 0)
            return Math.max(a1[a1Left], a2[a2Left]);
        if (a1Left > a1.length - 1)
            return a2[a2Left + k - 1];
        if (a2Left > a2.length - 1)
            return a1[a1Left + k - 1];
        
        int a1LeftValue = (a1Left + (int)Math.floor(k / 2.0) > a1.length - 1) ? Integer.MAX_VALUE : a1[a1Left + (int)Math.floor(k / 2.0)];
        int a2LeftValue = (a2Left + (int)Math.floor(k / 2.0) > a2.length - 1) ? Integer.MAX_VALUE : a2[a2Left + (int)Math.floor(k / 2.0)];
        
        return (a1LeftValue > a2LeftValue) ? logNSolutionHelper(a1, a2, a1Left, a2Left + k / 2, k - (int)Math.ceil(k / 2.0)) :
                logNSolutionHelper(a1, a2, a1Left + (int)Math.floor(k / 2.0), a2Left, k - (int)Math.ceil(k / 2.0));
    }
    
    
    /* Teacher's method 1, but from testing I find it is wrong. Same mistake as my method */
    public int kthII(int[] A, int[]B, int K) {
            assert A != null && B != null & K > 0 && K <= A.length + B.length;
            return kthII(A, 0, B, 0, K);
    }

    public int kthII(int[] A, int aLeft, int[] B, int bLeft, int K) {
            if (aLeft >= A.length) {
                    return B[bLeft + K - 1];
            } else if (bLeft >= B.length) {
                    return A[aLeft + K - 1];
            }
            if (K == 1) {
                    return Math.min(A[aLeft], B[bLeft]);
            }
            int aMid = aLeft + K / 2 - 1;
            int bMid = bLeft + K / 2 - 1;
            int aValue = aMid >= A.length ? Integer.MAX_VALUE : A[aMid];
            int bValue = bMid >= B.length ? Integer.MAX_VALUE : B[bMid];
            if (aValue < bValue) {
                    return kthII(A, aMid + 1, B, bLeft, K - K / 2);
            } else {
                    return kthII(A, aLeft, B, bMid + 1, K - K / 2);
            }
    }

    /* Teacher's method 2, still has mistake as testing */
    public int kthI(int[] A, int[] B, int K) {
        assert A != null && B != null & K > 0 && K <= A.length + B.length;
        if (A.length == 0) {
                return B[K - 1];
        } else if (B.length == 0) {
                return A[K - 1];
        }
        return kthI(A, Math.max(0, B.length - K - 1), Math.min(A.length - 1, K - 1), B, K);
    }

    public int kthI(int[] A, int left, int right, int[] B, int K) {
        if (left > right) {
                return kthI(B, Math.max(0, A.length - K - 1), Math.min(B.length - 1, K - 1), A, K);
        }
        int aMid = left + (right - left) / 2;
        int bMid = K - aMid - 1;
        if (bMid - 1 >= 0 && B[bMid - 1] > A[aMid]) {
                return kthI(A, aMid + 1, right, B, K);
        } else if (bMid < B.length && B[bMid] < A[aMid]) {
                return kthI(A, left, aMid - 1, B, K);
        }
        return A[aMid];
    }

    /* Teacher's method 3, still has mistake as testing. */
    public int kth(int[] A, int[] B, int K) {
        assert A != null && B != null & K > 0 && K <= A.length + B.length;
        return kth(A, 0, A.length - 1, B, 0, B.length - 1, K);
    }

    public int kth(int[] A, int aLeft, int aRight, int[] B, int bLeft, int bRight, int K) {
        int aLen = aRight - aLeft + 1;
        int bLen = bRight - bLeft + 1;
        if (aLen > bLen) {
                return kth(B, bLeft, bRight, A, aLeft, aRight, K);
        }
        if (aLen == 0) {
                return B[bLeft + K - 1];
        }
        if (K == 1) {
                return Math.min(A[aLeft], B[bRight]);
        }
        int k1 = Math.min(aLen, K / 2);
        int k2 = K - k1;
        if (A[aLeft + k1 - 1] < B[bLeft + k2 - 1]) {
                return kth(A, aLeft + k1, aRight, B, bLeft, bLeft + k2 - 1, K - k1);
        } else {
                return kth(A, aLeft, aLeft + k1 -1, B, bLeft + k2, bRight, K - k2);
        }
    }

    
    public static void main(String... args) {
        int[] a1 = {1,3,7,9,12,18};
        int[] a2 = {2,4,8};
        int k = 3;
        int res = new FindTheKthSmallestEleInTwoArrayLogN().findTheKthSmallestEleInTwoArrayLogN(a1, a2, k);
        System.out.println(res);
        System.out.println(new FindTheKthSmallestEleInTwoArrayLogN().kthII(a2, a2, k));
        System.out.println(new FindTheKthSmallestEleInTwoArrayLogN().kthI(a2, a2, k));
        System.out.println(new FindTheKthSmallestEleInTwoArrayLogN().kth(a2, a2, k));
        
        System.out.println("Ceil: " + Math.ceil(22.5) + "  Floor: " + Math.floor(22.5));
    }
}
