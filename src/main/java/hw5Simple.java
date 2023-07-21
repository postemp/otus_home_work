
import java.util.Arrays;

public class hw5Simple {

    public static void main(String[] args) {

        printString(3, "hello");
        sumElementsBigger5(new int[]{2, 4, 34, 6, 4, 20});
        fillEveryElement(4, new int[6]);
        int[] arr = {2, 4, 2, 4};
        increaseEveryElement(3, arr);
    }

    public static void printString(int counter, String string) {
        for (int i = 0; i < counter; i++) {
            System.out.println(string);
        }

    }

    public static void sumElementsBigger5(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }
        System.out.println("sum =" + sum);
//
    }

    public static void fillEveryElement(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = number;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void increaseEveryElement(int number, int... arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += number;
        }
        System.out.println(Arrays.toString(arr));
    }
}
