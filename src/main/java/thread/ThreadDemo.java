package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
    public void test1(){
        ThreadDemo1 thread=new ThreadDemo1();
        //为线程设置名称
        thread.setName("线程一");
        thread.start();
    }

    public void test2(){
        Thread thread2 = new Thread(new ThreadDemo2());
        //为线程设置名称
        thread2.setName("线程二");
        //开启线程
        thread2.start();
    }

    public void test3(){
        //通过线程池工厂创建线程数量为2的线程池
        ExecutorService service = Executors.newFixedThreadPool(2);
        //执行线程,execute()适用于实现Runnable接口创建的线程
        service.execute(new ThreadDemo1());
    }

    public void test4(){
        new Thread(new Runnable() {
            public void run() {
                System.out.println("123");
            }
        }).start();
    }

}
