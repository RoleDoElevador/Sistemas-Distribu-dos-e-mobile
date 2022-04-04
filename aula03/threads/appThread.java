package threads;

public class appThread {

    public static void main(String[] args) {
        myThread t1 = new myThread("Thread 1");
        myThread t2 = new myThread("Thread 2");
        myThread t3 = new myThread("Thread 3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Final do main");
    }
    
}
