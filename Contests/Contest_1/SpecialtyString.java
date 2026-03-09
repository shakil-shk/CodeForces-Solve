package Contests.Contest_1;

import java.util.*;

public class SpecialtyString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            System.out.println(canWin(s) ? "YES" : "NO");
        }
    }

    static boolean canWin(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // matched pair found
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty(); // all chars matched
    }
}
