package com.lxj.leetcode.simulation;

/**
 * @author Xingjing.Li
 * @since 5/17/2023
 */
public class DetermineIfTwoEventsHaveConflict2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        boolean a = event2[0].compareTo(event1[1]) > 0;
        boolean b = event2[1].compareTo(event1[0]) < 0;
        return !(a||b);
    }

    public static void main(String[] args) {
        DetermineIfTwoEventsHaveConflict2446 solution = new DetermineIfTwoEventsHaveConflict2446();
        String[] event1 = {"14:13","22:08"};
        String[] event2 = {"02:40","08:08"};
        System.out.println(solution.haveConflict(event1, event2));
    }
}
