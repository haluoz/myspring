package com.lxj.leetcode.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2022/2/18
 */
public class FindCenterOfStarGraph1791 {

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = edges.length, n = edges[0].length;
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                map.put(edges[i][j], map.getOrDefault(edges[i][j], 0)+1);
            }
        }
        int entryVal = 0;
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > entryVal){
                entryVal = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindCenterOfStarGraph1791 solution = new FindCenterOfStarGraph1791();
        int[][] ints = {{1, 2}, {2, 3}, {4, 2}};
        solution.findCenter(ints);
    }
}
