package _006_binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = ((int) (Math.random() * 100));
        }
        Arrays.sort(arr);
        int index = (int) (Math.random() * 100);
        int value = arr[index];
        System.out.println("index = " + index);
        System.out.println("value = " + value);
        System.out.println(binarySearch(arr, value));

        System.out.println(binarySearchRecursion(arr, value, 0, arr.length - 1));
    }

    /**
     * 普通二分查找
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static int binarySearchRecursion(int[] arr, int value, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return binarySearchRecursion(arr, value, left, right);
    }

    private static final List<Integer> list = new ArrayList<>();

    /**
     * 查找所有的元素
     * @param arr
     * @param value
     * @param left
     * @param right
     */
    public static void binarySearchAll(int[] arr, int value, int left, int right) {
        if (left > right) return; //递归结束的条件
        int mid = (left + right) / 2;
        if (arr[mid] == value) {
            list.add(mid);
            for (int i = mid - 1; i >= left; i--) {
                if (arr[i] != value) break;
                if (!list.contains(i)) list.add(i);
            }
            for (int i = mid + 1; i <= right ; i++) {
                if (arr[i] != value) break;
                if (!list.contains(i)) list.add(i);
            }
        } else if (arr[mid] > value) {
            binarySearchAll(arr, value, left, mid - 1);
        } else {
            binarySearchAll(arr, value, mid + 1 , right);
        }
    }
}
