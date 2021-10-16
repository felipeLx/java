package org.codewar;

public class ArrayEdx {

    //Returning the maximum value of the array
    private int method(int[] array) {
        int var = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > var) {
                var = array[i];
            }
        }
        return var;
    }

    //The sum of the integer elements in array
    private int method2(int[] array) {
        int var = 0;
        for(int i = 0; i < array.length; i++){
            var+=array[i];
        }
        return var;
    }

    //Returning the number of values of the array that are higher than array[0]
    private int method3(int[] array) {
        int value = array[0];
        int var = 0;
        for(int i = 1; i < array.length; i++){
            if (array[i]>value){
                var++;
            }
        }
        return var;
    }

    //if int[][]array = {{16,3,2,13},{5,10,11,8},{9,6,7,12},{4,15,14,1}}. What is var[] storing after running this code?
    //Four integers of value 34, which correspond to the sums of the columns of the bidimendional array
    private void method4(int[][] array) {
        int[] var =new int[array[0].length];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                var[j] += array[i][j];
            }
        }
    }
}
