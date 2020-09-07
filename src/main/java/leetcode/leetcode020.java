package leetcode;

import java.util.Stack;

public class leetcode020 {
    public static void main(String[] args) {
        System.out.println(" "+isValid("([)]"));
    }
    public static boolean isValid(String s) {
        String[] ss=s.split("");
        Stack<String> stringStack=new Stack<>();
        //'('，')'，'{'，'}'，'['，']'
        for (int i = 0; i <ss.length; i++) {
            if (stringStack.empty()||"(".equals(ss[i])||"{".equals(ss[i])||"[".equals(ss[i])){
                stringStack.push(ss[i]);
            }else {
                if (")".equals(ss[i])&&"(".equals(stringStack.pop())){

                }else     if ("}".equals(ss[i])&&"{".equals(stringStack.pop())){

                }else     if ("]".equals(ss[i])&&"[".equals(stringStack.pop())){

                }else {
                    return false;
                }

            }
        }
        return true;
    }
}
