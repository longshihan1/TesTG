package thread;

public class ThreadDemo2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果:ThreadDemo2");
    }

}
