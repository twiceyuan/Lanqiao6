package code;

import java.util.Scanner;

/**
 * Created by twiceYuan on 3/13/15.
 *
 * 基础
 */
public class Main003 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        String numbers[] = sc.nextLine().split(" ");

        System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
    }
}
