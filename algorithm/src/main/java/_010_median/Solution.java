package _010_median;


/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class Solution {

    public static void main(String[] args) {
        String s = "asdfsadfas";
        StringBuilder sb1 = new StringBuilder(s.substring(0, s.length() / 2));
        StringBuilder sb2 = new StringBuilder(s.substring(s.length() / 2));
        System.out.println("sb1 = " + sb1);
        System.out.println("sb2 = " + sb2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int len = l1 + l2;
        int left = -1, right = -1;
        int start1 = 0, start2 = 0;
        // 无论len是偶数还是奇数, 都需要遍历 len / 2次
        for (int i = 0; i < len / 2 + 1; i++) {
            left = right;
            //这个判断细节太多了
            //start1++的条件是?
            //1. nums2已经到最后一个元素了
            //2. nums1[start1] < nums2[start2]
            if (start1 < l1 && (start2 >= l2 || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    public double findMedianSortedArrays2(int[] A, int[] B) {
        int la = A.length, lb = B.length;
        int len = la + lb;
        int left = -1, right = -1;
        int start1 = 0, start2 = 0;
        //遍历 len / 2次
        for (int i = 0; i < len / 2 + 1; i++) {
            left = right;
            if (start1 < la && (start2 >= lb || A[start1] < B[start2])) {
                right = A[start1++];
            } else {
                right = B[start2++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
