
 // Definition for singly-linked list.
 public class ListNode
 {
     public int val;
     public ListNode next;
     public ListNode(int x)
     {
         val=x;
     }
     //链表节点的构造函数
     //使用一个数组arr作为参数，创建一个链表，当前的ListNode为链表头节点
     public ListNode(int[] arr)
     {
         if(arr==null || arr.length==0)
             throw new IllegalArgumentException("qrr can not be empty");
         //this就是创建出来的链表的头节点
         this.val=arr[0];
         //把数组中的每一个元素创建成一个新的ListNode，接在前一个节点上
         ListNode cur=this;
         for(int i=1;i<arr.length;i++)
         {
             cur.next=new ListNode(arr[i]);
             cur=cur.next;
         }
     }
     @Override
     //为了方便在main函数中看到这个链表,以当前节点为头节点的链表信息字符串
     public String toString()
     {
         StringBuilder res=new StringBuilder();
         ListNode cur=this;
         while(cur !=null)
         {
             res.append(cur.val+"→");
             cur=cur.next;
         }
         res.append("NULL");
         return res.toString();
     }
 }
