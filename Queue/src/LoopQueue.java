
public class LoopQueue<E> implements Queue<E>
{
    private E[] data;//创建类型为E[]的数组,名为data
    private int front,tail;//两个变量
    private int size;

    public LoopQueue(int capacity)//构造器
    {
        data =(E[])new Object[capacity+1];//强制类型转换
        front=0;
        tail=0;
        size=0;
    }
    public LoopQueue()//构造器
    {
        this(10);//调用有参数的构造函数
    }
    public int getCapacity()//方法
    {
        return data.length-1;
    }
    @Override
    public boolean isEmpty()
    {
        return front==tail;
    }
    @Override
    public int getSize()
    {
        return size;
    }
    @Override
    public void enqueue(E e)//传进来E类型的元素e
    {
        if((tail+1)%data.length==front)
        {
            resize(getCapacity()*2);
        }
        data[tail] =e;
        tail=(tail+1)%data.length;
        size++;
    }
    @Override
    public E dequeue()
    {
        if(isEmpty())
            throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        E ret=data[front];//保存出队元素为ret
        data[front]=null;//手动把data[front]赋值为null
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity()/4 && getCapacity()/2!=0)
        {
            resize(getCapacity()/2);
        }
        return ret;
    }
    @Override
    public E getFront()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }
    private void resize(int newCapacity)
    {
        E[] newData=(E[])new Object[newCapacity+1];//new一个newData，开空间
        for(int i=0;i<size;i++)
        {
            newData[i]=data[(i+front)%data.length];//data中的数和newData中的数有一个front的偏移量，为了防止越界，取余
        }
        data=newData;
        front=0;
        tail=size;

    }
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();//创建一个StringBuilder变量，命名为res
        res.append(String.format("Queue:size=%d,capacity=%d\n", size, getCapacity()));//%d为占位符，\n换行
        res.append("front [");
        for (int i = front; i !=tail; i=(i+1)%data.length)
        {
            res.append(data[i]);
            if((i+1)%data.length != tail)//判断不是最后一个元素
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();//返回值
    }
    public static void main(String[] args)
    {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i=0;i<10;i++)
        {
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3==2)//i除以3余2
            {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}

