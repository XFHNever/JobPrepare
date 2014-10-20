package Algorithm.other;

/**
 * Created by soft on 2014/10/20.
 */
public class FindKMaxInOneArray {
    public static void main(String arg[]) {
        FindKMaxInOneArray findKMaxInOneArray = new FindKMaxInOneArray();
        int[] array = {2, 4, 1, 7, 10, 3, 5, 40};
        System.out.println("result: " + findKMaxInOneArray.findK(array, 5, 0, 7));
    }

    private int findK(int[] array, int k, int start, int end) {
        int i = partion(array, start, end);

        if (k == i+1) {
            return array[i];
        } else if (k > i+1) {
            return findK(array, k, i+1, end);
        } else if (k < i+1) {
            return findK(array, k, 0, i);
        }

        return -1;
    }

    private int partion(int[] array, int start, int end) {
        int pivot = array[start];

        while (start < end) {
            while (array[end] < pivot && start < end) {
                end--;
            }
            swap(array, start, end);

            while (array[start] > pivot && start < end) {
                start++;
            }
            swap(array, start, end);
        }

        return start;

    }

    private void swap(int[] array, int left, int right) {
        int tem = array[left];
        array[left] = array[right];
        array[right] = tem;
    }
}
