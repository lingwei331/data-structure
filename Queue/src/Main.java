import java.util.Random;
public class Main
{
     //测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
                                    //承载整型的队列       //操作数
    private static double testQueue(Queue<Integer> q, int opCount)
    {
        long startTime=System.nanoTime();
        Random random=new Random();
        for(int i=0;i<opCount;i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));//入队一个随机数，0-Integer的最大值
        for(int i=0;i<opCount;i++)
            q.dequeue();
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args)
    {
        int opCount=100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue,time: " +time1+"s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue,time: " +time2+"s");
    }
}


