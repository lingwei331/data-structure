/*
本代码的作用是：
给定链表，传入唯一参数是输入链表的待删除节点（尾节点除外），返回输出的列表。
本测试方法使用的是教程中的LinkedList类
 */
public class Solution
{
    public static void main(String[] args)
    {
        //创建一个链表
        LinkedList<Integer> linkedList=new LinkedList<>();
        for(int i=0;i<5;i++)
        {
            linkedList.addFirst(i);
        }
        //打印该链表
        System.out.println(linkedList);
        //删除指定节点
        linkedList.remove(2);
        //打印删除节点后的链表
        System.out.println(linkedList);
    }
}
