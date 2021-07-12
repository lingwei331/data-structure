public class LinkedList<E> //支持泛型
{
    private class Node//把节点设置为链表的内部类，且私有
    {
        public E e;
        public Node next;
        public Node(E e,Node next)
        {
            this.e=e;//把节点的e设置为用户传来的e,this.e引用成员变量e
            this.next=next;
        }
        public Node(E e)//更方便的构造函数，若用户只传来e，将next赋值为空
        {
            this(e,null);//调用两个参数的构造函数
        }
        public Node()//用户什么都没传
        {
            this(null,null);
        }
        @Override
        public String toString()//对于链表的每一个节点，设置一个toString方便后续打印输出
        {
            return e.toString();
        }
    }
    private Node dummyHead;//链表中有一个Node型变量，命名为head//虚拟头节点
    private int size;
    public LinkedList()//构造器,如果用户初始化一个链表
    {
        dummyHead=new Node(null,null);
        size=0;
    }
    //获取链表中元素的个数
    public int getSized()
    {
        return size;
    }
    //返回链表是否为空
    public boolean isEmpty()
    {
        return size==0;
    }

    //在链表的index（0-based）位置添加新的元素e
    public void add(int index,E e)
    {
        if(index<0 || index>size)
            throw new IllegalArgumentException("Add failed.Illegal index.");

        Node prev=dummyHead;
        for(int i=0;i<index;i++)
            prev = prev.next;//把当前prev存的节点的下一个节点放进prev变量中
            //Node node = new Node(e);//new一个node，元素是e
            //node.next=prev.next;
            //prev.next=node;

        prev.next=new Node(e,prev.next);//new Node的元素是e，它的next指向prev。next
        size++;

    }
    //在链表头添加新元素e
    public void addFirst(E e)
    {
        //Node node=new Node(e);//首先创建一个新节点，在节点里传入新元素e
        //node.next=head;
        //head=node;

        //head =new Node(e,head);//node存入元素e，node直接指向head，然后把node赋值给现在的head
        //size++;
        add(0,e);
    }
    //在链表尾部添加新元素e
    public void addLast(E e)
    {
        add(size,e);
    }
    //获得链表的第index（0-based）个位置的元素
    //非常用操作
    public E get(int index)
    {
        if(index<0 || index>size)
            throw new IllegalArgumentException("Add failed.Illegal index.");
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++)
            cur=cur.next;
        return cur.e;//cur里存的e就是要找的index个元素
    }
    public E getFirst()
    {
        return get(0);
    }
    public E getLast()
    {
        return get(size-1);
    }
    //修改链表的第index（o-based）个位置的元素为e
    //不常用
    public  void set(int index,E e)
    {
        if(index<0 || index>size)
            throw new IllegalArgumentException("Add failed.Illegal index.");
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++)
            cur=cur.next;
        cur.e=e;//为什么是cur.e?
    }
    //查找链表中是否有元素e
    public boolean contains(E e)
    {
        Node cur=dummyHead.next;
        while(cur !=null)//遍历到直到链表为空
        {
            if(cur.e.equals(e))
                return true;
            cur=cur.next;
        }
        return false;
    }
    //从链表中删除第index（0-based）个元素，返回删除的元素值
    //不常用
    public E remove(int index)
    {
        if(index<0 || index>size)
            throw new IllegalArgumentException("Add failed.Illegal index.");
        Node prev=dummyHead;
        for(int i=0;i<index;i++)
            prev=prev.next;
        Node retNode=prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;
    }
    //从链表中删除第一个元素，返回删除的元素
    public E removeFirst()
    {
        return remove(0);
    }
    //从链表中删除最后一个元素，返回被删除的元素
    public E removeLast()
    {
        return remove(size-1);
    }


    @Override
    public String toString()
    {
        StringBuilder res=new StringBuilder();
      //  Node cur = dummyHead.next;
      //  while(cur!=null)
      //  {
      //      res.append(cur + "→");
      //      cur=cur.next;
      //  }
        for(Node cur=dummyHead.next;cur!=null;cur=cur.next)
            res.append(cur + "→");
        res.append("NULL");
        return res.toString();
    }
    //测试方法
    public static void main(String[] args)
    {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for(int i=0;i<5;i++)
        {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.getSized();
        System.out.println(linkedList.getSized());

        linkedList.set(1,99);
        System.out.println(linkedList);
    }
}
