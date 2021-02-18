package huawei;

import java.util.*;

/**
 * 名字的漂亮度
 */
public class NameOfBeauty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = Integer.parseInt(sc.nextLine());
            int score = 0;
            for(int i =0;i<num;i++){
                int beauty = 26;
                HashMap<Character, Integer> map = new HashMap<>();
                String name = sc.nextLine().toLowerCase();
                char [] chars = name.toCharArray();
                for(char c: chars){
                    map.put(c, map.getOrDefault(c,1)+1);
                }
                ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
                Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                });
                System.out.println(entries);
                for (int j = entries.size() -1; j >= 0  ; j--) {
                    score += (entries.get(j).getValue() - 1) * beauty;
                    beauty--;
                }
                System.out.println(score);
                score = 0;
            }
        }
    }
}

