import java.util.ArrayList;
import java.util.List;

public class Leetcode412_fizz_buzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode412_fizz_buzz test = new Leetcode412_fizz_buzz();
        System.out.println(test.fizzBuzz(15));
    }
}
