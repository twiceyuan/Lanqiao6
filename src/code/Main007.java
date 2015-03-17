package code;

import java.util.Scanner;

/**
 * Created by twiceYuan on 3/15/15.
 */
public class Main007 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        System.out.println(printResult(n));
    }

    private static String printResult(int n) {
        if (n == 1) {
            return "A";
        }
        return printResult(n - 1) + (char) (n + 64) + printResult(n - 1);
    }
}
