package Algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by never on 2014/10/15.
 */
public class FixedValue {
    public static void main(String args[]) {
        int[] array = {1, 2, 4, 7, 11, 15};

        FixedValue fixedValue = new FixedValue();
        fixedValue.solve3(array, 15);
    }

    private void solve1(int[] array, int K) {
        int length = array.length;
        for (int i=0; i<length; i++) {
            for (int j=i; j<length; j++) {
                if (K == (array[i] + array[j])) {
                    System.out.println("存在数对： " + array[i] + "和" + array[j]);
                }
            }
        }
    }

    private void solve2(int[] array, int K) {
        int i = 0,
            j = array.length - 1;
        while (i<j) {
            if ((array[i] + array[j]) == K) {
                System.out.println("存在数对： " + array[i] + "和" + array[j]);
                i++;
            } else if ((array[i] + array[j] > K)){
                j--;
            } else if ((array[i] + array[j] < K)){
                i++;
            }
        }
    }

    private void solve3(int[] array, int K) {
        int[] temp = new int[array.length];
        for (int i=0; i<array.length; i++) {
            temp[i] = K - array[i];
        }

        int m = 0,
                n = array.length - 1;
        while (m<n) {
            if (array[m] == temp[n]) {
                System.out.println("存在数对： " + array[m] + "和" + (K - array[m]));
                m++;
            } else if (array[m] < temp[n]) {
                m++;
            } else {
                n--;
            }
        }
    }

    private void solve4(int[] array, int K) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i<array.length; i++) {
            if (map.get(array[i]) != null) {
                System.out.println("存在数对： " + array[i] + "和" + (K - array[i]));
            }  else {
                map.put(K - array[i], array[i]);
            }
        }
    }

    private void solve5(int[] array, int K, int max) {
        int[] temp = new int[max + 1];

        for (int i=0; i<array.length; i++) {
            if (temp[array[i]] == 1) {
                System.out.println("存在数对： " + array[i] + "和" + (K - array[i]));
            } else {
                temp[K-array[i]] = 1;
            }
        }

    }
}
