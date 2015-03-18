package code;

/**
 * Created by twiceYuan on 3/18/15.
 *
 * K 好数
 */
public class Main011 {

    public static void main(String args[]) {
        int K = 4;
        int L = 2;

        int count = 0;

        for (long i = (long) (Math.pow(K, L-1) + 1);i < Math.pow(K, L);i++) {

            String number = getNumber(i, K);

            if (isK(number)) {
                System.out.println(getNumber(i, K));
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isK(String number) {

        for (int i = 0;i < number.length() - 1;i++) {
            char c_current = number.charAt(i);
            char c_next = number.charAt(i+1);
            if (c_current == c_next + 1 || c_current == c_next - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获得某进制下的数字
     * @param number 十进制的该数字
     * @param scale 进制 为一个整数
     * @return 返回该数字的字符串
     */
    public static String getNumber(long number, int scale) {

        StringBuilder sb = new StringBuilder();

        while (number != 0) {
            sb.insert(0, number % scale);
            number /= scale;
        }

        return sb.toString();
    }
}
