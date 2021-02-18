package huawei;

import java.util.Scanner;

public class ConvertDateToDays {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String date = sc.nextLine();
            String [] str = date.split(" ");
            int year = Integer.parseInt(str[0]);
            int month = Integer.parseInt(str[1]);
            int day = Integer.parseInt(str[2]);
            int result = day;
            for(int i =1;i< month; i++){
                result += getDays(year,i);
            }
            System.out.println(result);
        }


    }

    public static int getDays(int year, int month){
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }else if(month == 2){
            return year % 4 ==0 ? 29 :28;
        }else{
            return 30;
        }

    }
}
