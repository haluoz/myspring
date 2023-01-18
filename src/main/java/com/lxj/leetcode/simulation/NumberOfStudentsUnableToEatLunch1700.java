package com.lxj.leetcode.simulation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Xingjing.Li
 * @since 2022/10/19
 */
public class NumberOfStudentsUnableToEatLunch1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int count = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int student : students) { deque.add(student);}
        int position = 0;
        //这里会不断循环，加多判断条件
        while (!deque.isEmpty() && count != deque.size()){
            Integer student = deque.pollFirst();
            if (sandwiches[position] == student && position < sandwiches.length){
                position++;
                //能吃到重置
                count = 0;
            }else{
                deque.addLast(student);
                //没吃到加一
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch1700 solution = new NumberOfStudentsUnableToEatLunch1700();
//        int[] students = {1, 1, 0, 0};
//        int[] sandwiches = {0,1,0,1};
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(solution.countStudents(students, sandwiches));
    }
}
