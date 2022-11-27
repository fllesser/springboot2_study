package _016_maxarea;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 */

public class Solution {
    public int maxArea1(int[] height) {
        int left = 0, right = height.length - 1;
        for (int i = 0; i < height.length; i++) {
            left = height[left] > height[i] ? left : i;
        }
        for (int i = 0; i < height.length; i++) {
            right = i == left || height[right] >= height[i]  ? right : i;
        }
        int tmp;
        if (left > right) {
            tmp = right;
            right = left;
            left = tmp;
        }
        int area = operArea(height, left, right);
        tmp = 0;
        for (int i = 0; i <= left; i++) {
            for (int j = height.length - 1; j >= right; j--) {
                if (j < height.length - 1 && height[j] < height[j + 1]) continue;
                tmp = Math.max(tmp, operArea(height, i, j));
            }
        }
        area = Math.max(tmp, area);
        return area;
    }

    public int operArea(int[] height, int left, int right) {
        return Math.min(height[left], height[right]) * (right - left);
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
