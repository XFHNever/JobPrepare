package Algorithm.knapsack;

/**
 * Created by fuxie on 2014/10/16  13:24.
 */
public class ZeroOneKnapSack {
    public static void main(String args[]) {
        ZeroOneKnapSack sack = new ZeroOneKnapSack();
        int[] c = {2, 2, 6, 5, 4};
        int[] w = {6, 3, 5, 4, 6};
        sack.knapsack2(c, w, 5, 10);
    }

    private void knapsack(int[] c, int[] w, int N, int V) {
        int[][] opt = new int[N+1][V+1];          //max w of packing items 1..n with weight limit v

        for (int i=0; i<N; i++) {
            opt[i][0] = 0;
        }
        for (int i=0; i<V; i++) {
            opt[0][i] = 0;
        }


        for (int i=1; i<N+1; i++) {
            for (int j=1; j<V+1; j++) {
                //not take item n
                int option1 = opt[i-1][j];

                //take item n
                int option2 = Integer.MIN_VALUE;
                if (c[i-1]<=j) {
                    option2 = w[i-1] + opt[i-1][j-c[i-1]];
                }

                opt[i][j] = Math.max(option1, option2);

            }
        }

        //逆推法求出最优解
        int[] isUsed = new int[N];   //记录是否被使用
        int v = V;
        for (int i=N; i>0; i--) {
            if (opt[i][v] > opt[i-1][v]) {
                isUsed[i-1] = 1;
                v = v - c[i-1];
            }
        }

        for (int i=0; i< N; i++) {
            System.out.print(isUsed[i]);
        }

        System.out.println();
        System.out.println(opt[N][V]);
    }

    private void knapsack2(int[] c, int[] w, int N, int V) {
        int[] opt = new int[V+1];

        for (int i=1; i<=V; i++) {
            opt[i] = 0;
        }

        for (int i=1; i<=N; i++) {
            for (int j=V; j>=c[i-1]; j--) {
                opt[j] = Math.max(opt[j], opt[j-c[i-1]] + w[i-1]);
            }
        }

        System.out.println();
        System.out.println(opt[V]);
    }
}
