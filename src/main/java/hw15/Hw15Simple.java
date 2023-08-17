package hw15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hw15Simple {
    public static void main(String[] args) {
        System.out.println(makingArrayList(1, 10));

        List<Integer> arrLst = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(sumOfElements(arrLst));

        replaceEveryElemnt(123, arrLst);
        System.out.println(arrLst);

        sumEveryElemnt(123, arrLst);
        System.out.println(arrLst);
    }

    public static List makingArrayList(int min, int max) {
        List<Integer> arrList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            arrList.add(i);
        }
        return arrList;
    }

    public static Integer sumOfElements (List<Integer> arrayLst) {
        Integer sum = 0;
        for(Integer i : arrayLst) { // так можно или все таки итератор нужен?
            if (i > 5) {
                sum += i;
            }
        }
        return sum;
    }

    public static void replaceEveryElemnt(Integer number, List arrLst) {
        for (int i = 0; i < arrLst.size(); i++) {
            arrLst.set(i,number);
        }
    }

    public static void sumEveryElemnt (Integer number, List arrLst) {
        for (int i = 0; i < arrLst.size(); i++) {
            arrLst.set(i,((Integer)arrLst.get(i) + number));
        }
    }
}
