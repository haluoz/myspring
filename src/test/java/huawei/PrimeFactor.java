package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 质数因子
 */
public class PrimeFactor {
    public  static void main(String[] args)throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 2; i * i <= number; i++){
            if (number % i == 0){
                sb.append(i).append(" ");
                number = number/i;
                i --;
            }
        }
        sb.append(number).append(" ");
        System.out.println(sb.toString());
    }
}
