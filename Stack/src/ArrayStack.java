public class ArrayStack<E> implements Stack<E>//实现创建的Stack接口
{
    Array<E> array;//创建成员变量，动态数组,Array类
    public ArrayStack(int capacity)//构造器,有参
    {
        array = new Array<>(capacity);//初始化数组，静态
    }
    public ArrayStack()//无参构造
    {
        array = new Array<>();
    }
    @Override//声明在实现接口中相应方法
    public int getSize()
    {
        return array.getSize();
    }
    @Override
    public boolean isEmpty()
    {
        return array.isEmpty();
    }
    public int getCapacity()//不是Stack接口中的一部分，因为接口和栈的具体实现无关，只有用动态数组来实现这个栈时才存在容积这个概念，时ArrayStack特有的方法
    {
        return array.getCapaticy();
    }
    @Override
    public void push(E e)//E是元素类型
    {
        array.addLast(e);
    }
    @Override
    public E pop()
    {
        return array.removeLast();
    }
    @Override
    public E peek()
    {
        return array.getLast();
    }
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append('[');
        for(int i=0;i<array.getSize();i++)
        {
            res.append(array.get(i));
            if(i != array.getSize()-1)
            {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}

