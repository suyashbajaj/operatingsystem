import java.util.*;

public class ThreadExample implements Runnable{
    public void run()
    {
          try{
          for(int i=0;i<=10;i++)
          {
              Thread.sleep(250);
              System.out.println(i);
          }
          } 
          catch(Exception tt)
          {
              System.out.println(tt);
          }
    }
    
    public static void main(String [] args)
    {
        Thread t1=new Thread (new ThreadExample());
        t1.start();
         Thread t2=new Thread (new ThreadExample());
        t2.start();
    }
}