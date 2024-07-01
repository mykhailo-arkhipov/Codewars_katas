package Snail_4kyu;

import java.util.Arrays;

public class Snail {

    public static void main(String[] args) {
       int[][] array = new int[4][4];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) (Math.random() * (i + j)) + 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int[] snailArray = snail(array);
        System.out.println("\n" + Arrays.toString(snailArray));

    }

    public static int[] snail(int[][] array) {

        if (array[0].length == 0) return new int[0];

        int[] lineSnail = new int[array.length * array.length];

        int lastIndexSnailLine = 0;

        for (int l = 0; l < array.length / 2 + 1; l++) {

                    //копируется верхний блок
                    System.arraycopy(array[l], l, lineSnail, lastIndexSnailLine, array[l].length - l*2);
                    //перезаписывается индекс последней заполненной ячейки массива-результата
                    lastIndexSnailLine += array[l].length - l*2;

                    //копируется правый блок
                    for (int j = l + 1; j < array.length - l; j++) {
                        lineSnail[lastIndexSnailLine] = array[j][array.length - l - 1];
                        lastIndexSnailLine++;
                    }

                    //копируется нижний блок
                    for (int j = array.length - 2 - l; j >= l; j--) {
                        lineSnail[lastIndexSnailLine] = array[array.length - 1 - l][j];
                        lastIndexSnailLine++;
                    }

                    //копируется левый блок
                    for (int j = array.length - 2 - l; j > l; j--) {
                        lineSnail[lastIndexSnailLine] = array[j][l];
                        lastIndexSnailLine++;
                    }
                }
        return lineSnail;
    }
}
