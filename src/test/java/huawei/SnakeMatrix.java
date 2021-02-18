package huawei;

import java.util.Scanner;

/**
 * 蛇形矩阵
 */
public class SnakeMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int start = 0;
            for (int i = 0; i < n; i++) {
                int col = start;
                for (int j = 1; j <= n - i; j++) {
                    col = col + j + i ;
                    System.out.print(col + " ");
                }
                start += i;
                System.out.println();
            }
        }
    }
}
