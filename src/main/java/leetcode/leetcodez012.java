package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class leetcodez012 {
    static AtomicInteger atomicInteger = new AtomicInteger();
    static int count=0;

    public static void main(String[] args) {
        MyRun myRunnable1=new MyRun();
        MyRun myRunnable2=new MyRun();
        MyRun myRunnable3=new MyRun();
        MyRun myRunnable4=new MyRun();
        MyRun myRunnable5=new MyRun();
        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();
        new Thread(myRunnable3).start();
        new Thread(myRunnable4).start();
        new Thread(myRunnable5).start();
    }

    static class MyRun implements Runnable{

        @Override
        public void run() {
            while (true) {
//                if (atomicInteger.get()>=1000){
//                    break;
//                }
                synchronized (this) {
                    if (count >= 1000) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ++count);
//                    System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.incrementAndGet());
                    Thread.yield();
                }
            }
        }
    }
}
