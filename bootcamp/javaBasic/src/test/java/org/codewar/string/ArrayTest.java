package org.codewar.string;

import org.junit.jupiter.api.Test;

public class ArrayTest {
    @Test
    private static void print(String name, int a[]){
        System.out.print(name +" = [");
        for (int i=0; i < a.length-1; i++){
            System.out.print(a[i]+", ");
        }
        System.out.println(a[a.length-1]+"]");
    }

    @Test
    private static int indexMin(int[] array) {
        int var = 0;
        int num = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < num) {
                num = array[i];
                var = i;
            }
        }
        return var;
    }

    @Test
    private static int min(int[] array) {
        int var = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < var) {
                var = array[i];
            }
        }
        return var;
    }

    @Test
    public static void main(String args[]){
        int[] arrayA = new int[]{0,1,2,3,4,5};
        int[] arrayB = new int[10];

        for (int i = 0; i<10; i++){
            arrayB[i] = (int) (Math.random()*100);
        }

        print("A", arrayA);
        // Complete this sentence. It should behave exactly the same as the previous method call
        //System.out.println("A = "+??????????);
        print("B", arrayB);
        //System.out.println("B = "+?????????);

        System.out.println("min(A) = "+ min(arrayA));
        System.out.println("indexMin(A) = "+ indexMin(arrayA));

        System.out.println("min(B) = "+ min(arrayB));
        System.out.println("indexMin(B) = "+ indexMin(arrayB));
    }
}
