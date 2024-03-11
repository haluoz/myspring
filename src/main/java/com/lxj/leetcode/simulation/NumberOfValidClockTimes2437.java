package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 5/9/2023
 */
public class NumberOfValidClockTimes2437 {
    public int countTime(String time) {
        int ans = 0;
        StringBuilder hours = new StringBuilder();
        String[] split = time.split(":");
        String hour = split[0];
        char first = hour.charAt(0);
        char second = hour.charAt(1);
        if (first == '?' && second == '?'){
            hours.append(24);
        } else if (second == '?'){
            if(Integer.parseInt(String.valueOf(first)) > 1){
                hours.append(4);
            }else {
                hours.append(10);
            }
        } else if (first == '?' ){
            if(Integer.parseInt(String.valueOf(second)) > 3){
                hours.append(2);
            }else {
                hours.append(3);
            }
        }
        StringBuilder minutes = new StringBuilder();
        String minute = split[1];
        first = minute.charAt(0);
        second = minute.charAt(1);
        if (first == '?' && second == '?'){
            minutes.append(60);
        } else if (second == '?'){
            minutes.append(10);
        } else if (first == '?'){
            minutes.append(6);
        }
        int hoursInt = !"".equals(hours.toString()) ? Integer.parseInt(hours.toString()) : 0;
        int minuteInt = !"".equals(minutes.toString()) ? Integer.parseInt(minutes.toString()) : 0;
        if (hoursInt > 0 && minuteInt > 0){
            ans = hoursInt * minuteInt;
        } else if (hoursInt > 0 || minuteInt > 0){
            ans = hoursInt + minuteInt;
        } else {
            ans = 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfValidClockTimes2437 solution = new NumberOfValidClockTimes2437();
//        solution.countTime("?1:?9");
//        System.out.println(solution.countTime("0?:0?"));
//        System.out.println(solution.countTime("2?:??"));
        System.out.println(solution.countTime("21:59"));
    }
}
