package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by twiceYuan on 3/16/15.
 *
 * 给出 a0, a1, b0, b1, 设有数字 x 满足 x 和 a0 的最大公约数是 a1，x 和 b0 的最大公约数是 b1
 * 求 x 的总数
 */
public class Main008 {

    public static void main(String args[]) {

        List<String> inputs = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            inputs.add(sc.nextLine());
        }

        for (String input : inputs) {
            String arguments[] = input.split(" ");
            int[] numbers = new int[arguments.length];

            for (int j = 0; j < arguments.length; j++) {
                numbers[j] = Integer.parseInt(arguments[j]);
            }

            printAnswer(numbers[0], numbers[1], numbers[2], numbers[3]);
        }
    }

    /**
     * @param a0 与x比较最大公约数的数字
     * @param a1 最大公约数
     * @param b0 与x比较最小公倍数的数字
     * @param b1 最小公倍数
     */
    private static void printAnswer(int a0, int a1, int b0, int b1) {

        int count = 0;

        for (int x = a1;x <= b1;x++) {

            int gcd = getGCD(x, a0);
            int lcm = getLCM(x, b0);
            if (gcd == a1 && lcm == b1) {
                count++;
            }
        }

        System.out.println(count);
    }

    /**
     * 获得最小公倍数
     * @param a 任意数字
     * @param b 任意数字
     * @return a 和 b 的最小公倍数
     */
    public static int getLCM(int a, int b) {
        int gcd = getGCD(a, b);
        return a * b / gcd;
    }

    /**
     * 获得 a 和 b 的最大公约数是否为 x
     * @param a a b 中较小的数
     * @param b a b 中较大的数
     * @return a 和 b 的最大公约数
     */
    public static int getGCD(int a, int b) {

        // 获得a的所有约数
        List<Integer> a_cbs = getCommonDivisors(a);
        // 获得b的所有约数
        List<Integer> b_cbs = getCommonDivisors(b);

        int result = 1;

        for (int i = 0; i < a_cbs.size(); i++) {
            for (int j = 0; j < b_cbs.size(); j++) {
                if (a_cbs.get(i).equals(b_cbs.get(j))) {
                    result *= a_cbs.get(i);
                    a_cbs.remove(i);
                    b_cbs.remove(j);

                    i--; // size 减少 1，i 同样 - 1
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 获得一个数字的所有约数（包括1）
     * @param number 要获得约数的数字
     * @return number的所有约数（List）
     */
    public static List<Integer> getCommonDivisors(int number) {

        List<Integer> cd = new ArrayList<Integer>();

        int i = 1;

        while(i <= number) {
            if (number % i == 0) {
                cd.add(i);
                number /= i;
                i = 2;
            } else {
                i++;
            }
        }

        return cd;
    }
}
