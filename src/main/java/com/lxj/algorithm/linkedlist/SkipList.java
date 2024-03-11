package com.lxj.algorithm.linkedlist;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * @author Xingjing.Li
 * @since 6/29/2023
 */
public class SkipList {
    private static final double P = 0.5d;
    private SkipNode head;
    private final Integer MAX_LEVEL = 3;
    private int size = 0;
    private Random random;

    public SkipList() {
        random = new Random();
        this.head = new SkipNode(Integer.MIN_VALUE, null, MAX_LEVEL);
    }

    public void insert(Integer key, Object value){
        SkipNode[] update = new SkipNode[MAX_LEVEL];
        SkipNode current = head;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].key < key){
                current = current.next[i];
            }
            update[i] = current;
        }
        if (current != null && Objects.equals(current.key, key)){
            current.value = value;
        }else {
            int level = 1;
            while (random.nextDouble() < P && level < MAX_LEVEL){
                level++;
            }
            SkipNode newNode = new SkipNode(key, value, level);
            for (int i = 0; i < level; i++) {
                newNode.next[i] = update[i].next[i];
                update[i].next[i] = newNode;
            }
        }
        size++;
    }

    public SkipNode search(Integer key){
        SkipNode current = head;
        for (int i = MAX_LEVEL -1 ; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].key < key){
                current = current.next[i];
            }
        }
        current = current.next[0];
        if (current != null && Objects.equals(current.key, key)){
            return current;
        }
        return null;
    }

    public void print() {
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            SkipNode current = head.next[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print("(" + current.key + ", " + current.value + ") ");
                current = current.next[i];
            }
            System.out.println();
        }
    }

    private class SkipNode{
        Integer key;
        Object value;
        SkipNode[] next;

        public SkipNode(Integer key, Object value, int level) {
            this.key = key;
            this.value = value;
            this.next = new SkipNode[level];
        }

    }

    public static void main(String[] args) {
//        SkipList skipList = new SkipList();
//        skipList.insert(1, "one");
//        skipList.insert(2, "two");
//        skipList.insert(3, "three");
//        skipList.insert(4, "four");
//        skipList.insert(5, "five");
//        skipList.insert(6, "six");
//        skipList.insert(7, "seven");
//        skipList.insert(8, "eight");
//        skipList.insert(9, "nine");
//        skipList.insert(10, "ten");
//        skipList.insert(11, "eleven");
//        skipList.print();
//        SkipNode searchNode = skipList.search(2);
//        System.out.println(searchNode.value);
//        skipList.delete(2);
//        skipList.print();
//        ArrayList<Integer> integers = new ArrayList<>();
//         addNumber(integers, true);
//        System.out.println();

        LocalDate nowDate = LocalDate.now();
        int year = nowDate.getYear();
        int month = nowDate.getMonthValue();
        int day = nowDate.getDayOfMonth();
        int hour = 23;
        int minutes = 59;
        int second = 59;
        LocalDateTime currentDateTime = LocalDateTime.of(year, month, day, hour, minutes, second);
        //前一天到期的企业
        LocalDateTime tomorrowDateTime = currentDateTime.plusDays(1L);
        //前七天到期的企业
        LocalDateTime weekDateTime = currentDateTime.plusDays(7L);
        ZoneId zoneId = ZoneId.systemDefault();
        long preOneDate = tomorrowDateTime.atZone(zoneId).toInstant().toEpochMilli();
        long preSevenDate = weekDateTime.atZone(zoneId).toInstant().toEpochMilli();
        System.out.println();
    }

    private static void addNumber(ArrayList<Integer> integers, boolean flag) {
        integers.add(1);
        integers.add(2);
        integers.add(3);
        if (flag){
            ArrayList<Integer> override = new ArrayList<>();
            override.add(4);
            override.add(5);
            override.add(6);
            integers.clear();
            integers.addAll(override);
        }
    }
}
