package com.lxj.leetcode.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2021/10/9
 */
public class DestinationCity1436 {

    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0),path.get(1));
        }
        String ans = paths.get(0).get(0);
        while (map.containsKey(ans)){
            ans = map.get(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<List<String>> lists = new ArrayList<>();
        DestinationCity1436 solution = new DestinationCity1436();
        lists.add(solution.addElement(new String[]{"London", "New York"}));
        lists.add(solution.addElement(new String[]{"New York", "Lima"}));
        lists.add(solution.addElement(new String[]{"Lima", "Sao Paulo"}));
        System.out.println(solution.destCity(lists));
    }

    public List<String> addElement( String [] elements){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
        }
        return list;
    }
}
