package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode003 {
    public static void main(String[] args) {
        System.out.println("  "+lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int from = 0, to = 1, length = 1, maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
        // to遍历直到字符串末尾
        while (to < s.length()){
            int site = s.substring(from, to).indexOf(s.charAt(to));
            if (site != -1){
                // to指向的字符已存在
                length = to - from;
                if (length > maxLength) {
                    maxLength = length;
                }
                if (maxLength > s.length() - from + 1) return maxLength;
                if (maxLength >= set.size()) return maxLength;
                from = from + site + 1;
            }
            to++;
        }
        // 处理最后一个子串
        if (to - from > maxLength) {
            maxLength = to - from;
        }
        return maxLength;
    }

}
