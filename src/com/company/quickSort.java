package com.company;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class quickSort{
    //785. 快速排序https://www.acwing.com/problem/content/787/
    public static void main(String[] args){
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        int n =  scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = scan.nextInt();
        }
        quickSort(arr, 0, n - 1);
        for(int i = 0; i < n; i ++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int i = left - 1, j = right + 1, x = arr[left];
        while(i < j ) {
            do{
                i ++;
            } while(arr[i] < x);
            do{
                j --;
            }while(arr[j] > x);
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(arr, left, j);
        quickSort(arr, j + 1, right);
    }
}