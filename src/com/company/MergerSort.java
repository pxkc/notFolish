package com.company;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class MergerSort {
    public static void main(String[] args) {
        Scanner scan  =  new Scanner(new BufferedInputStream(System.in));
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++ ) {
            arr[i] = scan.nextInt();
        }
        mergerSort(arr, 0, n - 1);
        for(int i = 0; i < n; i ++ ) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergerSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int mid = left + right >> 1;
        mergerSort(arr, left, mid);
        mergerSort(arr, mid +1, right);
        int[] temp = new int[right - left + 1];
        int k = 0, i = left, j = mid + 1;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[k ++] = arr[i ++];
            }
            else {
                temp[k ++] = arr[j ++];
            }
        }
        while(i <= mid) temp[k ++] = arr[i ++];
        while(j <= right) temp[k ++] = arr[j ++];
        for(i = left, j = 0; i <= right; i ++, j ++) {
            arr[i] = temp[j];
        }
    }
}
