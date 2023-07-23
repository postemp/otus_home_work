
import java.util.Arrays;

public class hw5Simple {

    public static void main(String[] args) {

        printString(3, "hello");
        sumElementsBigger5(new int[]{2, 4, 34, 6, 4, 20});
        fillEveryElement(4, new int[6]);
        int[] arr = {2, 4, 2, 4};
        increaseEveryElement(3, arr);
        whichHalfIsGreater(new int[] {5,1,1,1,2,2,2,2} );
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

    public static void whichHalfIsGreater(int[] arr){
        if (arr.length%2 != 0){
            System.out.println("половины массива имеют разное количество чисел");
            return;
        }
        int lestSideSum = 0;
        int rightSideSum = 0;
        // суммируем левую сторону массива
        for (int i = 0; i < arr.length/2; i++) {
            lestSideSum += arr[i];
        };
        // суммируем правую сторону массива
        for (int i = arr.length/2; i < arr.length; i++) {
            rightSideSum += arr[i];
        };
        if (lestSideSum > rightSideSum) {
            System.out.println("Сумма левой стороны больше");
        } else if (lestSideSum < rightSideSum) {
            System.out.println("Сумма правой стороны больше");
        } else {
            System.out.println("Суммы сторон одинаковы");
        }
    }
}
