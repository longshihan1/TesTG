package thread;

public  class ThreadDemo1 extends Thread{

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+":"+"输出的结果:ThreadDemo1");
    }

}