
public class ArrayQueue<E> implements Queue<E>//支持泛型且实现设置的接口
{
    private Array<E> array;//成员变量，变量名为array
    public ArrayQueue(int capacity)//构造器
    {
        array=new Array<>(capacity);
    }
    public  ArrayQueue()
    {
        array=new Array<>();
    }
    @Override
    public int getSize()
    {
        return array.getSize();
    }
    @Override
    public boolean isEmpty()
    {
        return array.isEmpty();
    }
    public int getCapacity()
    {
        return array.getCapaticy();
    }
    @Override
    public void enqueue(E e)
    {
        array.addLast(e);
    }
    @Override
    public E dequeue()
    {
        return array.removeFirst();
    }
    @Override
    public E getFront()
    {
        return array.getFirst();
    }
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();//创建一个StringBuilder变量，命名为res
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();//返回值
    }
    public static void main(String[] args)
    {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
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

