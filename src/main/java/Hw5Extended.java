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