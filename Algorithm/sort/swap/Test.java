package Algorithm.sort.swap;

import Algorithm.sort.Sort;

/**
 * Created by never on 2014/8/31.
 */
public class Test {
    public static void main(String args[]) {
        System.out.println("============= Bubble Sort ===============");
        int[] array1 = {1, 4, 2, 40, 23, 90,56};
        Test.printArray(array1);
        Sort bubble = new BubbleSort();
        bubble.sort(array1);
        Test.printArray(array1);

        System.out.println("============= Improve Bubble Sort ===============");
        int[] array2 = {1, 4, 2, 40, 23, 90,56};
        Test.printArray(array2);
        Sort bubbleImprove = new BubbleImprove();
        bubbleImprove.sort(array2);
        Test.printArray(array2);

        System.out.println("============= Improve Bubble Sort 2 ===============");
        int[] array3 = {2, 40, 1, 4, 23, 90,56};
        Test.printArray(array3);
        Sort bubbleImprove2 = new BubbleImprove2();
        bubbleImprove2.sort(array3);
        Test.printArray(array3);

        System.out.println("============= Improve Bubble Sort 3 ===============");
        int[] array4 = {2, 40, 1, 4, 23, 90,56};
        Test.printArray(array4);
        Sort bubbleImprov3 = new BubbleImprove3();
        bubbleImprov3.sort(array4);
        Test.printArray(array4);


        System.out.println("============= Quick Sort ===============");
        int[] array5 = {2, 40, 1, 4, 23, 90,56};
        Test.printArray(array5);
        Sort quickSort = new QuickSort();
        quickSort.sort(array5);
        Test.printArray(array5);
    }

    public static void printArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
