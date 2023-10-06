import java.util.*;
import java.util.concurrent.Semaphore;
public class ReaderWriter {
    static int rc = 0;
    static Semaphore s = new Semaphore(1);
    static Semaphore wrt = new Semaphore(1);
    static class Reader implements Runnable{
    public void run(){
        try{
        s.acquire();
        rc = rc+1;
        if(rc == 1){
            wrt.acquire();
    }
        s.release();
        System.out.println(Thread.currentThread().getName()+" is reading");
        Thread.sleep(1000);
        s.acquire();
        rc = rc -1;
        if(rc == 0){
            wrt.release();
        }
        s.release();
    }
        catch(Exception e){
            
        }
        
}
}
static class Writer implements Runnable{
    public void run(){
        try{
           wrt.acquire();
           System.out.println(Thread.currentThread().getName()+" is writing");
           Thread.sleep(1000);
           wrt.release();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
public static void main(String args[]){
    Thread t1 = new Thread(new Reader());
    t1.setName("Reader 1");
    Thread t2 = new Thread(new Reader());
    t2.setName("Reader 2");
    Thread t3 = new Thread(new Writer());
    t3.setName("Writer 1");
    Thread t4 = new Thread(new Writer());
    t4.setName("Writer 2");
    t4.start();
    t1.start();
    t3.start();
    t2.start();       
}
}