package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twiceYuan on 3/12/15.
 *
 * 递归
 */
public class Main001 {

    public static void main(String args[]) {

        List<Integer> empty = new ArrayList<Integer>();
        printAnswer(empty);
    }

    static void printAnswer(List<Integer> numbers) {

        if (numbers.size() == 5) {
            StringBuilder sb = new StringBuilder();
            for (int i:numbers)sb.append(numbers.get(i));
            System.out.println(sb.toString()+"\n");
            return;
        }

        List<Integer> fork1 = new ArrayList<Integer>();

        fork1.addAll(numbers);
        fork1.add(0);

        List<Integer> fork2 = new ArrayList<Integer>();

        fork2.addAll(numbers);
        fork2.add(1);

        printAnswer(fork1);
        printAnswer(fork2);
    }
}
