package code;

import java.util.Scanner;

/**
 * Created by twiceYuan on 3/15/15.
 */
public class Main006 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        System.out.println(fMod10007(n - 1));
    }

    public static int fMod10007(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return (fMod10007(n - 1) + fMod10007(n - 2) ) % 10007;
    }
}
