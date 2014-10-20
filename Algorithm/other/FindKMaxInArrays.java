package Algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soft on 2014/10/20.
 */
public class FindKMaxInArrays {
    public static void main(String arg[]) {
        FindKMaxInArrays findKMaxInArrays = new FindKMaxInArrays();
        int[] array1 = {1,3,5,9,100};
        int[] array2 = {24, 45, 111};
        int[] array3 = {2, 4,8,10, 101};
        int[] array4 = {45, 67, 89, 102};
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(array1);
        list.add(array2);
        list.add(array3);
        list.add(array4);

        findKMaxInArrays.findK3(list, 10);
    }

    private void findK(int K, List<int[]> list) {
        int size = list.size();
        Node[] nodes = new Node[size];

        for (int i = 0; i < size; i++) {
            Node node = new Node();
            node.group = i;
            node.index = 0;
            node.value = list.get(i)[0];
            nodes[i] = node;
        }

        MaxHeap heap = new MaxHeap(size + 2, nodes);
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heap.siftDown(i, size - 1);
        }

        while (K > 0) {
            Node top = heap.nodes[0];
            System.out.print(top.value + "\t");

            Node newNode = new Node();
            newNode.group = top.group;
            newNode.index = top.index + 1;
            if (top.index >= list.get(top.group).length - 1) {
                newNode.value = Integer.MIN_VALUE;
            } else {
                newNode.value = list.get(newNode.group)[newNode.index];
            }

            heap.nodes[0] = newNode;
            heap.siftDown(0, size - 1);
            K--;
        }

    }

    class Node {
        int value;
        int group;
        int index;
    }

    class MaxHeap {
        Node[] nodes;
        int currentSize;
        int maxSize;

        public MaxHeap(int length, Node[] array) {
            this.maxSize = length;
            this.currentSize = array.length;
            this.nodes = array;
        }

        public void siftDown(int start, int end) {
            int i = start;
            int j = 2 * i + 1;
            Node tmp = nodes[start];

            while (j <= end) {
                if (j < end && nodes[j].value < nodes[j + 1].value) {
                    j++;
                }

                if (tmp.value >= nodes[j].value) {
                    break;
                } else {
                    nodes[i] = nodes[j];
                    i = j;
                    j = 2 * i + 1;
                }
            }

            nodes[i] = tmp;
        }
    }

    private void findK3(List<int[]> list, int k) {
        LoserTree tree = new LoserTree(list, k);
        tree.merge();
    }

    class LoserTree {
        int size;
        int[] b, ls;
        List<int[]> list;
        int k;


        public LoserTree(List<int[]> list, int k) {
            this.list = list;
            this.size = list.size();
            b = new int[size + 1];
            ls = new int[size];
            this.k = k;
        }

        public void adjust(int s) {
            int i, j;

            j = (s + size) / 2;
            while (j > 0) {
                if (b[s] > b[ls[j]]) {
                    i = s;
                    s = ls[j];
                    ls[j] = i;
                }
                j = j / 2;
            }
            ls[0] = s;
        }

        public void merge() {
            for (int i = 0; i < size; i++) {
                b[i] = getFirst(list.get(i));
            }

            createLoserTree();
            while (k>0) {
                int out = ls[0];
                System.out.print(b[out] + "\t");

                b[out] = getFirst(list.get(out));

                adjust(out);
                k--;
            }
        }

        public void createLoserTree() {
            int i;
            b[size] = Integer.MIN_VALUE;
            for (i = 0; i < size; i++) {
                ls[i] = size;
            }

            for (i = size - 1; i >= 0; i--) {
                adjust(i);
            }
        }

        private int getFirst(int[] array) {
            int result = Integer.MIN_VALUE;
            if (array.length > 0) {
                result = array[0];
                for (int i=0; i<array.length-1; i++) {
                    array[i] = array[i+1];
                }
            }
            return result;
        }

    }
}