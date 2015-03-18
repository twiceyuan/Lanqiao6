package code;

import java.util.Scanner;

/**
 * Created by twiceYuan on 3/18/15.
 */
public class Main010 {

    public static String full = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        String firstLine[] = sc.nextLine().split(" ");
        String secondLine = sc.nextLine();

        int s = Integer.parseInt(firstLine[0]);
        int t = Integer.parseInt(firstLine[1]);
        int w = Integer.parseInt(firstLine[2]);

        String input = secondLine;

        String src = full.substring(s - 1, t);

        for (int i = 0;i < w && input != null;i++) {
            input = next(input, src, w);
            System.out.println(input);
        }
    }

    /**
     * 获得当前 JAM 数字的下一个数字
     * @param current 当前的JAM数字
     * @param src 可用的字母
     * @param length JAM数字的长度
     * @return current的下一个JAM数字
     */
    public static String next(String current, String src, int length) {

        // 该JAM数字可以达到的最大值
        String max = src.substring(src.length() - length);

        // 当达到最大值时
        if (current.equals(max)) {
            return null;
        }

        int index = length - 1;
        while (index > -1) {

            // 当值还没到达最大值
            // 把当前位 +1，并把后面位都赋值为最小值
            if (current.charAt(index) != max.charAt(index)) {

                char temp = current.charAt(index);
                // 当前位 +1
                current = current.replace(temp, (char) (temp + 1));

                // 进位后将该位之后的字母赋值为最小值
                for (int i = index + 1;i < length;i++) {
                    char c = current.charAt(i);
                    current = current.replace(c, (char) (temp + i - index + 1));
                }

                break;
            } else {
                // 当值到达最大值时 ---- 进位
                index--;
            }
        }

        return current;
    }
}
