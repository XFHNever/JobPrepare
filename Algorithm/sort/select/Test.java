package Algorithm.sort.select;

import Algorithm.sort.Sort;
import Algorithm.sort.SortUtil;

/**
 * Created by never on 2014/9/4.
 */
public class Test {
    public static void main(String arg[]) {
        System.out.println("============= Simple Select Sort ===============");
        int[] array1 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array1);
        Sort simpleSelectSort = new SimpleSelectSort();
        simpleSelectSort.sort(array1);
        SortUtil.printArray(array1);

        System.out.println("============= Heap Sort ===============");
        int[] array2 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array2);
        Sort heapSort = new HeapSort();
        heapSort.sort(array2);
        SortUtil.printArray(array2);

        System.out.println("============= Tournament Sort ===============");
        int[] array3 = {1, 4, 2, 40, 23, 90,56};
        SortUtil.printArray(array3);
        Sort tournamentSort = new TournamentSort();
        tournamentSort.sort(array3);
        SortUtil.printArray(array3);
    }
}
