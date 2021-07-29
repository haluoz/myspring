package com.lxj.leetcode.hashtable;

import java.util.*;

public class DisplayTableOfFoodOrdersInARestaurant1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        // 桌号 : {餐品 : 个数}（用于构造内容）
        Map<Integer, Map<String, Integer>> tm = new HashMap<>();
        // 餐品（用于构造 title）
        Set<String> ts = new HashSet<>();
        for (List<String> o : orders) {
            String c = o.get(0), t = o.get(1), f = o.get(2);
            Integer tidx = Integer.parseInt(t);
            ts.add(f);
            Map<String, Integer> map = tm.getOrDefault(tidx, new HashMap<>());
            map.put(f, map.getOrDefault(f, 0) + 1);
            tm.put(tidx, map);
        }
        int n = tm.size() + 1, m = ts.size() + 1;
        // 构造 title & 手动排序
        List<String> foods = new ArrayList<>(ts);
        Collections.sort(foods);
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(foods);
        ans.add(title);
        // 构造内容 & 手动排序
        List<Integer> tables = new ArrayList<>(tm.keySet());
        Collections.sort(tables);
        for (int tidx : tables) {
            Map<String, Integer> map = tm.get(tidx);
            List<String> cur = new ArrayList<>();
            cur.add(tidx + "");
            for (String food : foods) {
                cur.add(map.getOrDefault(food, 0) + "");
            }
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        DisplayTableOfFoodOrdersInARestaurant1418 solution = new DisplayTableOfFoodOrdersInARestaurant1418();
//        String [][] orders = {{"David","3","Ceviche"},{"Corina","10","Beef Burrito"},
//                            {"David","3","Fried Chicken"},{"Carla","5","Water"},
//                            {"Carla","5","Ceviche"},{"Rous","3","Ceviche"}};
        List<List<String>> orders = new ArrayList<>();
        ArrayList<String> order = new ArrayList<>();

        order.add("David");
        order.add("3");
        order.add("Ceviche");
        orders.add(order);

        order = new ArrayList<>();
        order.add("Corina");
        order.add("10");
        order.add("Beef Burrito");
        orders.add(order);

        order= new ArrayList<>();
        order.add("David");
        order.add("3");
        order.add("Fried Chicken");
        orders.add(order);

        order= new ArrayList<>();
        order.add("Carla");
        order.add("5");
        order.add("Water");
        orders.add(order);

        order= new ArrayList<>();
        order.add("Carla");
        order.add("5");
        order.add("Ceviche");
        orders.add(order);

        order= new ArrayList<>();
        order.add("Rous");
        order.add("3");
        order.add("Ceviche");
        orders.add(order);

        List<List<String>> lists = solution.displayTable(orders);
        for (List<String> list : lists) {
            for (String str: list){
                System.out.printf("%10s",str+",");
            }
            System.out.println();
        }
    }
}
