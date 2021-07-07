public class Array<E>
{
    //定义成员变量,data是变量名
    private E[] data;// private int[] data;
    private int size;
    //构造函数，传入数组的容量capacity构造Array，构造器
    public Array(int capacity)
    {
        data = (E[])new Object[capacity];//Object是任意类的父类//静态初始化数组
        size=0;
    }
    //无参数的构造函数，默认数组的容量是capacity=10
    public Array()
    {
        this(10);//this代表arr吗，main方法里new出来的arr
    }
    //获取数组中的元素个数
    public int getSize()
    {
        return size;
    }
    public int getCapaticy()
    {
        return data.length;
    }
    //返回数组是否为空
    public boolean isEmpty()
    {
        return size==0;
    }
    //向所有元素后添加一个元素
    public void addLast(E e)
    {
        add(size,e);
    }
    /*
    {
        if(size==data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full.");
        data[size]=e;
        size ++;
    }

     */
    //在所有元素前添加一个新元素
    public void addFirst(E e)
    {
        add(0,e);
    }
    //在第index个位置插入一个新元素
    public void add(int index,E e)
    {

        if(index<0 || index>size)
            throw new IllegalArgumentException("AddLast failed.Require index >= 0 and index<=size.");
        if(size==data.length)
            resize(2*data.length);//扩容2倍
        for(int i =size-1;i>=index;i--)
            data[i+1]=data[i];
        data[index]=e;
        size ++;
    }
    //获取索引为index的元素
    public E get(int index)
    {
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Get failed.Require index is illegal.");
        return data[index];
    }

    public E getLast()
    {
       return get(size-1);
    }

    public E getFirst()
    {
        return get(0);
    }
    //修改index索引位置的元素为e
    void set(int index,E e)
    {
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Get failed.Require index is illegal.");
        data[index]=e;
    }
    //查找数组中是否有元素e
    public boolean contains(E e)
    {
        for(int i=0;i<size;i++)
        {
            if(data[i].equals(e))
                return true;
        }
        return false;
    }
    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e)
    {
        for(int i=0;i<size;i++)
        {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }
    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index)
    {
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Remove failed.Require index is illegal.");
        E ret =data[index];
        for(int i=index+1;i<size;i++)
            data[i-1]=data[i];
        size--;
        data[size]=null;//这句话不是必须的 loitering objects！=memory leak
        if(size==data.length/2)
            resize(data.length/2);//减少到一定程度后，减少容量
        return ret;
    }
    //从数组中删除第一个元素，返回删除的元素
    public E removeFirst()
    {
        return remove(0);
    }
    //从数组中删除最后一个元素，返回删除的元素
    public E removeLast()
    {
        return remove(size-1);
    }
    //从数组中删除某个具体元素e，只删除了一个e，并不能保证其他e也被删除
    public void removeElement(E e)
    {
        int index=find(e);
        if(index !=-1)
            remove(index);
    }

    @Override//覆盖
    public String toString()
    {
        StringBuilder res = new StringBuilder();//创建一个StringBuilder变量，命名为res
        res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length));//%d为占位符，\n换行
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append(']');
        return res.toString();//返回值
    }
    private void resize(int newCapacity)//改变数组容量
    {
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0;i<size;i++)
            newData[i]=data[i];
        data=newData;

    }
}
