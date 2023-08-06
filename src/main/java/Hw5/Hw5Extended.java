package Hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Hw5Extended {
    public static void main(String[] args) {

        // 1 задание Cуммирование элементов в массиве
        int[][] multiDimensionArr = new int[][]{
                {1, 2, 3, 4}
                , {2, 2}
                , {1, 1, 1, 1, 1, 2}
                , {2}
        };
        System.out.println(Arrays.toString(sumArrayElements(multiDimensionArr)));

        // 2 задание Найти середину между элементами массива
        if (findingMiddle(new int[]{1, 1, 3, 1, 5, 1})) {
            System.out.println("суммы левой и правой части равны, точкa присутствует");
        } else {
            System.out.println("суммы левой и правой части не равны, точки нет");
        }

        // 3 задание Проверить, что все элементы идут в порядке убывания или возрастания
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы хотите проверить массив на возрастание? (введите 'y') или на убывание? (любой другой символ)");
        char whatToDo = scanner.next().charAt(0);
        int[] array = new int[]{4, 2, 1, -2, -10}; // убывающий массив
//        int[] array = new int[]{-4, -2, 4, 5, 10}; // возрастающий массив
        System.out.print(Arrays.toString(array));
        if (whatToDo == 'y' || whatToDo == 'Y') {
            if (checkingIfIncreasing(array, whatToDo)) {
                System.out.println(" Массив возрастает");
            } else {
                System.out.println(" Массив не возрастает");
            }
        } else {
            if (checkingIfIncreasing(array, whatToDo)) {
                System.out.println(" Массив  убывает");
            } else {
                System.out.println(" Массив не убывает");
            }
        }

        // 4 задание Переворачиваем массив
        System.out.println("Переворачиваем массив " + Arrays.toString(revertArr(new int[]{1, 2, 3, 4, 5, 6, -10})));

    }

    public static int[] sumArrayElements(int[][] multiDimArr) {
//        ищем длину будущего массива, который будем возвращать
        int counter = 0;
        int maxLength = 0; // длина будущего массива
        for (int i = 0; i < multiDimArr.length; i++) {
            for (int j = 0; j < multiDimArr[i].length; j++) {
                counter++;
            }
            if (maxLength < counter) {
                maxLength = counter;
            }
            counter = 0;
        }
//        System.out.println("maxLength = "+maxLength);
        int[] arrOfSum = new int[maxLength];
        int tempSum;

//        суммируем и заполняем массив:
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
            arrOfSum[counter] = tempSum;
            counter++;
        }
        return arrOfSum;
    }

    public static boolean findingMiddle(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if ((sum % 2) != 0) {
            return false;
        }
        int halfSum = sum / 2;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
//                System.out.println("sum / 2=" + (sum / 2) + " temp=" + temp);
            if (temp == sum / 2) {
                return true;
            }
        }
        return false;

    }

    public static boolean checkingIfIncreasing(int[] arr, int flag) {
        if (flag == 1) { // проверяем, что массив возрастает
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    return false;
                }
            }
            return true;
        }
        // проверяем, что массив убывает
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] revertArr(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[arr.length - i-1];
            arr[arr.length - i-1] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}

//1 4 5 1 2 2