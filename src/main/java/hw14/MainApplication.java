package hw14;

public class MainApplication {
    public static void main(String[] args) {
        try {
//            workWithArr(new String[][]{{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}}); // правильный массив
//            workWithArr(new String[][]{{"1","2","3","4"},{"1","2","3","4","5"},{"1","2","3","4"},{"1","2","3","4"},{"2"}}); // размер неправильный
//            workWithArr(new String[][]{{"1","2","3","4"},{"1  ","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}}); // стоит лишний пробел рядом с цифрой
            sumArrElements(new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4", "5"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}});  // неправильное количество элементов во 2 элементе
        } catch (AppArrayDataException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getDetails());
        } catch (AppArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sumArrElements(String[][] twoDimArr) {
        if (twoDimArr.length != 4) {
            throw new AppArraySizeException("Ошибка в размере массива length = " + twoDimArr.length);
        }
        for (int i = 0; i < twoDimArr.length; i++) {
            if (twoDimArr[i].length != 4) {
                throw new AppArraySizeException("Ошибка в размере массива [" + i + "].length = " + twoDimArr[i].length);
            }
        }

        int sum = 0;
        for (int i = 0; i < twoDimArr.length; i++) {
            for (int j = 0; j < twoDimArr[i].length; j++) {
                try {
                    sum += Integer.parseInt(twoDimArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("словили excepton NumberFormatException", "проблема в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        System.out.println("Сумма = " + sum);
    }
}
