package leetcode;

import java.util.*;

/**
 * 1202. 交换字符串中的元素
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，
 * 其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串
 */
public class SwapElementsInString {
    // 用一个列表保存并查集
    List<Integer> p;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        p = new ArrayList<>();
        int n = s.length();
        // 塞入并查集中的原始根元素
        for(int i = 0; i < n; i++) p.add(i);

        // 遍历联通节点，构建并查集
        for(List<Integer> pair : pairs) {
            int a = find(pair.get(0)), b = find(pair.get(1));

            if(a != b) p.set(a, b);
        }

        // 用一个map来保存并查集中每个集合的元素
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        // 将字符放到并查集中对应的集合中
        for(int i = 0; i < n; i++) {
            // 获取该下标对应的并查集中的集合
            int cur = find(i);
            if(!map.containsKey(cur)) {
                map.put(cur, new PriorityQueue<>());
            }
            // 将该下标的字符放到对应的优先队列中
            map.get(cur).offer(s.charAt(i));
        }

        StringBuilder res = new StringBuilder();

        // 从低到高，遍历所有元素，优先poll出小的元素
        for(int i = 0; i < n; i++) {
            res.append(map.get(find(i)).poll());
        }
        return res.toString();
    }

    // 并查集中查找集合根元素的模板方法
    private int find(int x) {
        if(x != p.get(x)) {
            p.set(x, find(p.get(x)));
        }
        return p.get(x);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> integerArrayList1 = new ArrayList<>();
        integerArrayList1.add(0);
        integerArrayList1.add(3);
        ArrayList<Integer> integerArrayList2 = new ArrayList<>();
        integerArrayList2.add(1);
        integerArrayList2.add(2);
        list.add(integerArrayList1);
        list.add(integerArrayList2);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.println(list.get(i).get(j));
            }
        }
        SwapElementsInString swapElementsInString = new SwapElementsInString();
        swapElementsInString.smallestStringWithSwaps("dcab",list);
    }
}
