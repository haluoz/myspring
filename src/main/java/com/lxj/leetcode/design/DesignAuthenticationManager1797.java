package com.lxj.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xingjing.Li
 * @since 2023/2/9
 */
public class DesignAuthenticationManager1797 {

    private Integer timeToLive;
    private Map<String, Integer> map;

    public DesignAuthenticationManager1797(Integer timeToLive) {
        this.timeToLive = timeToLive;
        this.map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime+timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if(map.getOrDefault(tokenId, 0)> currentTime){
            map.put(tokenId, currentTime+timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        for (Integer value : map.values()) {
            if (value > currentTime){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DesignAuthenticationManager1797 solution = new DesignAuthenticationManager1797(5);
        solution.renew("aaa",1);
        solution.generate("aaa",2);
        solution.countUnexpiredTokens(6);
        solution.generate("bbb", 7);
        solution.renew("bbb", 8);
        solution.renew("bbb", 10);
        solution.countUnexpiredTokens(15);
    }
}
