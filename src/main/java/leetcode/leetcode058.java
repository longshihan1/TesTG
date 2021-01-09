package leetcode;

public class leetcode058 {
    public static void main(String[] args) {
         System.out.println(""+lengthOfLastWord(" "));
    }
    public static int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        } else {
            return strings[strings.length - 1].length();
        }
    }
}
