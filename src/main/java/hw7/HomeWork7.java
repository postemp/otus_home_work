package hw7;

public class HomeWork7 {
    public static void main(String[] args) {
        System.out.println("сумма элементов, которые больше 0, равна "
                + sumOfPositiveElements(new int[][]{{1, -2, 3, 4}, {1, -2, 3}, {1, 2}}));
        drawSquare(15);

        drawArr(new int[][]{
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        });

        System.out.println(findMax(new int[][]{{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}}));

        System.out.println("сумма элементов второй колонки = " + sumSecColElem(new int[][]{
                {1, 2, 3, 4},
                {2, 2}
        }));
    }

    public static int sumOfPositiveElements(int[][] twoDimArr) {
        int sumOfElements = 0;
        for (int i = 0; i < twoDimArr.length; i++) {
            for (int j = 0; j < twoDimArr[i].length; j++) {
                if (twoDimArr[i][j] > 0) {
                    sumOfElements += twoDimArr[i][j];
                }
            }
        }
        return sumOfElements;
    }

    public static void drawSquare(int sideLength) {
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                if (i == 0 || i == sideLength - 1 || j == 0 || j == (sideLength - 1)) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public static void drawArr(int[][] squareTwoDimArr) {
        for (int i = 0; i < squareTwoDimArr.length; i++) {
            for (int j = 0; j < squareTwoDimArr[i].length; j++) {
                if ((squareTwoDimArr.length - 1) - i == j || i == j) {
                    System.out.print(" 0 ");
                } else {
                    System.out.print(" " + squareTwoDimArr[i][j] + " ");

                }
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public static int sumSecColElem(int[][] array) {
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                System.out.println("i =" + i + " j = " + j);
                if (j == 1) {
                    sum += array[i][j];
                    flag = true;
                }
            }
        }
        if (!flag) {
            return -1;
        }
        return sum;
    }

}
