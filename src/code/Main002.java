package code;

import java.util.Scanner;

/**
 * Created by twiceYuan on 3/12/15.
 * <p/>
 * 皇后问题
 * <p/>
 * 回溯法
 */
public class Main002 {


    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int a[] = new int[64];
        int b[] = new int[8];
        int c[] = new int[8];
        int i, j, n;

        n = Integer.parseInt(sc.nextLine());

        for (i = 0; i < n; i++) {

            String line[] = sc.nextLine().split(" ");
            for (j = 0; j < n; j++) {
                a[i * n + j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(go(a, b, c, 0, n));
    }

    /**
     *
     * @param a 棋盘
     * @param b
     * @param c
     * @param m 下的棋子数量
     * @param n 最终需要下的棋子总数
     * @return 本次放置后
     */
    static int go(int[] a, int[] b, int[] c, int m, int n)
    {
        if (m == n)
            return 1;

        int i, j, k, count = 0;

        for (i = 0; i < n; i++) {
            // 如果该位置不能放置 则跳到下一个行位置
            if (a[m * n + i] == 0)
                continue;
            //
            for (j = 0; j < m; j++)
                if (b[j] == i || b[j] - i == j - m || b[j] + j == i + m)
                    break;

            if (j == m) {
                b[m] = i;
                for (k = 0; k < n; k++) {
                    if (a[m * n + k] == 0 || k == i)
                        continue;
                    for (j = 0; j < m; j++)
                        if (c[j] == k || c[j] - k == j - m || c[j] + j == k + m)
                            break;
                    if (j == m) {
                        c[m] = k;
                        count += go(a, b, c, m + 1, n);
                    }
                }
            }
        }
        return count;
    }
}
