package thread;

class MyThread implements Runnable{
    //票数是多个线程的共享资源
    private int ticket = 10;
    @Override
    public void run() {
        while(ticket > 0)
        {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"张票");
        }
    }
}
public class Test {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        new Thread(thread1,"黄牛A").start();
        new Thread(thread1,"黄牛B").start();
        new Thread(thread1,"黄牛C").start();
    }
}

