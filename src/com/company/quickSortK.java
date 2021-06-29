import java.io.BufferedInputStream;
import java.util.Scanner;

public class quickSortK {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = scan.nextInt();
        }
        quickSortK1(arr, 0, n - 1, k - 1);
        System.out.print(arr[k - 1]);
    }

    private static void quickSortK1(int[] arr, int left, int right, int k) {
        if(left >= right) return;
        int i = left - 1, j = right + 1, x = arr[left];
        while(i < j) {
            do{
                i ++;
            } while(arr[i] < x);
            do {
                j --;
            } while(arr[j] > x);
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if(k <= j){// 这个j是排序好的，如果k比j大，意味着排序右边的即可。j右边的数字都比j对应的value值大
            quickSortK1(arr, left, j, k);
        } else {
            quickSortK1(arr, j + 1, right, k);
        }

    }
}
