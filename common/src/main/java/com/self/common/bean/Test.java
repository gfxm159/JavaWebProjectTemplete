package com.self.common.bean;

public class Test {


    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[getPivot(left, right)];
        System.out.println("pivot:"+pivot);
        while (left < right) {
            if (arr[left] <= pivot && left < right) {
                left++;
            }
            if (arr[right] > pivot && left < right) {
                right--;
            }
            System.out.println("left:"+left);
            System.out.println("right:"+right);
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        sort(arr, 0, left - 1);
        sort(arr, left + 1, arr.length - 1);
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static int getPivot(int left, int right) {
        return (left + right) / 2;
    }

    public static void main(String[] args) {
        int arr[] = {6, 5, 4, 3, 2, 1};
        Test.sort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }


}
