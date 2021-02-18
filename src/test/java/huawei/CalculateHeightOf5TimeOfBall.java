package huawei;

import java.util.Scanner;

/**
 * 求小球落地5次后所经历的路程和第5次反弹的高度
 */
public class CalculateHeightOf5TimeOfBall {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            double height = Double.valueOf(n);
            double totalHeight = 0;
            for(int i=0;i<5;i++){
                totalHeight += height *2;
                height = height / 2;
                if(i==4){
                    totalHeight -= n;
                    System.out.printf("%.6f\n",totalHeight);
                    System.out.printf("%.6f\n",height);
                }
            }
        }
    }
}
