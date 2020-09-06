package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode1233 {
    public static void main(String[] args) {
        String[] strings = new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println("" + removeSubfolders(strings));
    }

    public static List<String> removeSubfolders(String[] folder) {
        if (folder.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(folder);
        List<String> strings = new ArrayList<>();
        strings.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String fl = strings.get(strings.size() - 1);
            if (!folder[i].contains(fl+"/")) {
                strings.add(folder[i]);
            }
        }
        return strings;
    }
}
