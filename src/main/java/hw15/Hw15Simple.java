package hw15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hw15Simple {
    public static void main(String[] args) {
        System.out.println(makingArrayList(1, 10));

        ArrayList<Integer> arrLst = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(sumOfElements(arrLst));

        replaceEveryElemnt(123, arrLst);
        System.out.println(arrLst);

        sumEveryElemnt(123, arrLst);
        System.out.println(arrLst);
    }

    public static List<Integer> makingArrayList(int min, int max) {
        List<Integer> arrList = new ArrayList<>();
        for (int i = max; i > min-1; i--) {
            arrList.add(i);
        }
        return arrList;
    }

    public static int sumOfElements (List<Integer> arrayLst) {
        int sum = 0;
        for(Integer i : arrayLst) { // так можно или все таки итератор нужен?
            if (i > 5) {
                sum += i;
            }
        }
        return sum;
    }

    public static void replaceEveryElemnt(Integer number, List<Integer> arrLst) {
        for (int i = 0; i < arrLst.size(); i++) {
            arrLst.set(i,number);
        }
    }

    public static void sumEveryElemnt (Integer number, List<Integer> arrLst) {
        for (int i = 0; i < arrLst.size(); i++) {
            arrLst.set(i,arrLst.get(i) + number);
        }
    }
}
