package com.lxj.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2021/8/26
 */
public class StudentAttendanceRecordI551 {
    public boolean checkRecord(String s) {
        char [] chars = s.toCharArray();
        char last = 'z';
        int late = 1;
        int absence = 0;
        for(int i = 0; i < chars.length; i++){
            if(last == chars[i] && chars[i] == 'L'){
                late++;
                if (late >= 3){
                    return false;
                }
            } else {
                late = 1;
            }
            if (chars[i] == 'A') {
                absence++;
            }
            last = chars[i];
        }
        if(late < 3  && absence < 2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StudentAttendanceRecordI551 solution = new StudentAttendanceRecordI551();
        System.out.println(solution.checkRecord("LLLALL"));
    }
}
