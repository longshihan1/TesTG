package util;

public class DAN {

    //懒汉式
    static class Singleton {
        static Singleton instance;

        private Singleton() {
        }

        static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }

    static class Singleton1 {
        static Singleton1 instance;

        private Singleton1() {
        }

        static synchronized Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();
            }
            return instance;
        }
    }

    //饿han
    static class SingleTon2 {
        static SingleTon2 instance = new SingleTon2();

        private SingleTon2() {
        }

        public static SingleTon2 getInstance() {
            return instance;
        }
    }

    //dcl
    static class SingleTon3 {
        volatile static SingleTon3 instance;

        private SingleTon3() {

        }

        static SingleTon3 getInstance() {
            if (instance == null) {
                synchronized (SingleTon3.class) {
                    if (instance == null) {
                        instance = new SingleTon3();
                    }
                }
            }
            return instance;
        }
    }


    //内部静态类
    static class SingleTon4 {
        private SingleTon4() {

        }

        static class SingleTon_4 {
            static final SingleTon4 instance = new SingleTon4();
        }

        public static SingleTon4 getInstance() {
            return SingleTon_4.instance;
        }

    }


}
