package Contests.Contest_1;

import java.util.*;

public class DeletionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            if (isNonDecreasing(a)) {
                System.out.println(n);
            } else {
                System.out.println(1);
            }
        }
    }

    static boolean isNonDecreasing(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
