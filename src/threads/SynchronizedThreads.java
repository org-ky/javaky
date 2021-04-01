/*
* A race condition occurs when two or more threads access shared data and try to read 
* and write at the same time.
* Both threads execute the same instance of Runnable and change int variable counter.
* We can fix race condition by adding synchronization block
* So, I put a synchronized block and lock it by using a monitor from an instance of 
* Runnable. 
* Since both threads use the same instance of Runnable this monitor will prevent my 
* threads A and B from accessing the block of code at the same time.
*/
package threads;

public class SynchronizedThreads {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            private int counter = 0;
     
            @Override
            public void run() {
                while (true) {
                    synchronized (this) {
                        counter++;
             
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ", value: " + counter);
             
                        counter--;
                        System.out.println(threadName + ", value: " + counter);
                    }
             
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
             }
        };
     
        Thread threadA = new Thread(runnable);
        threadA.setName("Thread A");
        threadA.setDaemon(false);
        threadA.setPriority(5);
     
        Thread threadB = new Thread(runnable);
        threadB.setName("Thread B");
        threadB.setDaemon(false);
        threadB.setPriority(5);
     
        threadA.start();
        threadB.start();
     }
}
