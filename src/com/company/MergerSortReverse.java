package com.company;

import java.io.*;
import java.util.Scanner;

public class MergerSortReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader scan =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scan.readLine());
        String[] arrStr = scan.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        long res = mergerSortReverse(arr, 0, n - 1);
        System.out.println(res);
    }

    private static long mergerSortReverse(int[] arr, int left, int right) {
        if(left >= right) return 0;
        int mid = left + right >> 1;
        long res = 0;
        res = mergerSortReverse(arr, left, mid) + mergerSortReverse(arr, mid +1, right);
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k ++] = arr[i ++];
            } else {
                temp[k ++] = arr[j ++];
                res += mid - i  + 1;
            }
        }
        while(i <= mid) temp[k ++] = arr[i ++];
        while(j <= right) temp[k ++] = arr[j ++];
        for(i = left, j = 0; i <= right; i ++, j ++) arr[i] = temp[j];
        return res;
    }
}
