package huawei;

import java.util.Scanner;

/**
 * 等差数列 -> 求和
 * 2 5 8 11 14
 */
public class ArithmeticProgression {
    public static void main(String[] args) {
        //Sn=n*a1+n(n-1)d/2或Sn=n(a1+an)/2
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println((3*n+1)*n/2);
        }
    }
}
