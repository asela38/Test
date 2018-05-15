package com.asela;

public class DeadLockTest {
    
    private static Object o1 = "Lock 1" , o2 = "Lock 2";
    
    public static void main(String[] args) {
        
        new Thread() {
            public void run(){
                synchronized (o2) {
                    print();
                    synchronized (o1) {
                        print();
                    }
                }
            }
        }.start();
        
        synchronized (o1) {
            print();
            synchronized (o2) {
                print();
            }
        }
    }
    
    public static void print() {
        System.out.printf("%s %n has %s : %s %n has %s : %s %n", Thread.currentThread().getName(), o1, Thread.holdsLock(o1), o2, Thread.holdsLock(o2));
    }

}
