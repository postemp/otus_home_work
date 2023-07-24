import java.util.Arrays;
import java.util.Scanner;

public class Hw5Extended {
    public static void main(String[] args) {

        // 1 задание Cуммирование элементов в массиве
        int[][] multiDimensionArr = new int[][]{
                {1, 2, 3, 4}
                , {2, 2}
                , {1, 1, 1, 1, 1}
                , {2}
        };
        System.out.println(Arrays.toString(sumArrayElements(multiDimensionArr)));

        // 2 задание Найти середину между элементами массива
        System.out.println(findingMiddle(new int[]{1, 1, 3, 1, 4}));

        // 3 задание Проверить, что все элементы идут в порядке убывания или возрастания
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы хотите проверить массив на убывание (введите 1) или возрастание? (введите 2)");
        int whatToDo = scanner.nextInt();
        int[] array = new int[] {4,2,1,-2,-10};
        System.out.println( Arrays.toString(array) +"  "+ checkingIfIncreasing(array,whatToDo ));

        // 4 задание Переворачиваем массив
        System.out.println("Переворачиваем массив " + Arrays.toString(revertArr(new int[]{1, 2, 3, 4, 5, 6, -10})));
    }

    public static int[] sumArrayElements(int[][] multiDimArr) {
        int[] arrOfSum = new int[0];
        int tempSum;
        int counter = 0;

        while (true) {
            tempSum = 0;
            for (int j = 0; j < multiDimArr.length; j++) {
                if (multiDimArr[j].length <= counter) {
                    continue;
                }
//                System.out.print(multiDimArr[j][counter]+ " ");
                tempSum += multiDimArr[j][counter];
            }
//            System.out.println(" Sum = "+ tempSum);
            if (tempSum == 0) {
                break;
            }
            // call the method to add tempSum in arr
            arrOfSum = addX(counter, arrOfSum, tempSum);
            counter++;
        }
        return arrOfSum;
    }

    // этот метод я нашел в интернете:
    public static int[] addX(int n, int arr[], int x) {
        int i;

        // create a new array of size n+1
        int newarr[] = new int[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }

    public static String findingMiddle(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if ( (sum % 2) != 0 ) {
            return "суммы левой и правой части не равны, точки нет";
        } else {
            int halfSum = sum / 2;
            int temp = 0;
            for (int i = 0; i < arr.length; i++) {
                temp += arr[i];
//                System.out.println("sum / 2=" + (sum / 2) + " temp=" + temp);
                if (temp == sum / 2) {
                    return "суммы левой и правой части равны, есть точка";
                }
            }
        }
        return "суммы левой и правой части не равны, точки нет";

    }

    public static String checkingIfIncreasing(int[] arr, int flag) {
        if (flag == 2) { // проверяем, что массив возрастает
            int oldVal = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < oldVal) {
                    return "Массив не возрастает";
                }
                oldVal = arr[i];
            }
            return "Массив возрастает";
        } else if (flag == 1) {  // проверяем, что массив убывает
            int oldValue = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > oldValue) {
                    return "Массив не убывает";
                }
                oldValue = arr[i];
            }
            return "Массив убывает";
        } else {
            return "Введите цифру 1 или 2";
        }
    }

    public static int[] revertArr(int[] arr) {
        int maxVal;
        int minVal;
        int arrRevCounter = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (i >= arrRevCounter) {
                break;
            }
            minVal = arr[i];
            maxVal = arr[arrRevCounter];
            arr[i] = maxVal;
            arr[arrRevCounter] = minVal;
            arrRevCounter--;
//            System.out.println( Arrays.toString(arr));
        }
        return arr;
//
//        int tempVal = arr.length-1;
//        int[] arrOut = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            arrOut[i] = arr[tempVal];
//            tempVal --;
//        }
//        return arrOut;
    }
}

//1 4 5 1 2 2