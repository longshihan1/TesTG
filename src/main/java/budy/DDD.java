package budy;

public class DDD {
    public static void main(String[] args) {
        A b=new B();
        b.say();
    }
}




 class A {
    protected void say(){
        System.out.println("A");
    }
}
 class B extends A{

    @Override
    public void say() {
         System.out.println("B");
    }
}