package com.songo;

import java.util.Arrays;

/**
 * @Author SonGo
 * @Create 2020/8/3 22:14
 * @Description
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {5,1,4,2,9,7,0,8,7};
        //bubbleSort(arr);
        //quickSort(arr,0,arr.length-1);
        selectSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 1、冒泡排序
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     * 稳定性：稳定
     * @param arr
     */
    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        //外循环-计算对比圈数
        for (int i = 0; i < arr.length-1; i++) {
            //内循环-计算对比次数
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 2、快速排序
     * @param arr
     */
    public static void quickSort(int[] arr,int left,int right) {

        // 必须加
       if (left > right) {
            return;
        }

        // 以左边的元素为基准元素
        int base = arr[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (i < j && arr[j] >= base) {
                j--;
            }
            // 再从左往右边找，直到找到比base值大的数
            while (i < j && arr[i] <= base) {
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 注意，这一步必须要，填上最左边的坑
        arr[left] = arr[i];
        // 基准元素就位
        arr[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    /**
     * 3、选择排序
     * @param arr
     * @param left
     * @param right
     */
    private static void selectSort(int[] arr, int left, int right) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
