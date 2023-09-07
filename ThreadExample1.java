import java.util.*;
public class ThreadExample1 implements Runnable
{
    public void run()
    {
        for(int i=0;i<=10;i++)
        System.out.println(i);
    }
    public static void main (String[] args)
    {
        Thread t1=new Thread(new ThreadExample1());
        t1.start();
        Thread t2=new Thread(new ThreadExample1());
        t2.start();
    }
}