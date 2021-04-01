/*
* To improve our Singleton pattern I have just added synchronized keyword in method declaration. 
* In the following example only one thread can enter the getInstance() method and execute code 
* at the time.
* More specifically, the first thread is going to obtain a lock from Singleton class, execute the 
* method, create an instance of Singleton class and return the monitor. 
* We will acquire lock on getInstance() method once, to create instance and after that we 
* will read instance without acquiring the lock.
* However this implementation is buggy if we forget to declare the variable instance as volatile. 
* Without volatile we don't have happens before link between synchronize write and read. 
* Volatile ensure that multiple threads read the correct instance value. 
* When a variable is declared volatile we suggest the compiler to never store the value of the 
* variable in cache memory.
*/
public class Singleton {
        private static final Object object = new Object();
        private static volatile Singleton instance = null;
     
        private Singleton() {}
     
        public static Singleton getInstance() {
            if (instance != null) {
                return instance;
            }
     
            synchronized (object) {
                if (instance == null) {
                    instance = new Singleton();
                }
     
                return instance;
            }
        }
}
