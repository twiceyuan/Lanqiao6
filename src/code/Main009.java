package code;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by twiceYuan on 3/17/15.
 */
public class Main009 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int numbers[] = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(getHuffman(numbers));
    }

    public static int getHuffman(int[] numbers) {

        int count = 0;
        while (numbers.length != 2) {

            Arrays.sort(numbers);
            int a = numbers[0] + numbers[1];
            int length = numbers.length;

            int numbers2[] = new int[length - 1];

            System.arraycopy(numbers, 2, numbers2, 0, length - 2);

            numbers2[length - 2] = a;
            numbers = numbers2;
            count += a;
        }

        count += numbers[0] + numbers[1];

        return count;
    }
}
