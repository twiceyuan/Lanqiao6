package code;

/**
 * Created by twiceYuan on 3/18/15.
 */
public class Main012 {

    public static void main(String args[]) {
        //An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
        //A3=sin(1-sin(2+sin(3-sin(3))))

        int n = 3;

        System.out.println(getAn(n));
        System.out.println(getSn(n));
    }

    private static String getSn(int n) {
        //Sn=((A1+n) A2+n-1)A3+...+2)An+1
        // ((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1

        String temp = getAn(1) + "+" + n;

        int index = 2;
        while (index <= n) {
            int number = n - index + 1;
            temp = "(" + temp + ")" + getAn(index) + "+" + number;
            index++;
        }

        return temp;
    }

    private static String getAn(int n) {

        String temp = n + "";
        n--;

        while (n > 0) {
            temp = n + (n % 2 == 0 ? "+" : "-") + "sin(" + temp + ")";
            n--;
        }

        temp = "sin(" + temp + ")";

        return temp;
    }
}
