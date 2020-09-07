package postman;

import java.lang.ref.SoftReference;

public class Test {
    public static void main(String[] args) {
        Integer AA=new Integer(2);
        TT(AA);
        System.out.println("  "+AA);
    }
    public static void TT(Integer A){
        System.out.println("  "+A);
        A=1;
    }
}
