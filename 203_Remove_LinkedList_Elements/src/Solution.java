/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//不用虚拟头节点
class Solution {
    public ListNode removeElements(ListNode head, int val)
    {
        //如果head不为空，且head节点本身就是val，而且删掉头节点后，后面的可能又要删掉，因此用while循环
        while(head!=null && head.val==val)
        {
            //定义一个delNode等于待删除的head节点
            ListNode delNode=head;
            head=head.next;
            //断开delNode与链表的关系
            delNode.next=null;
        }
        //如果链表中所有元素都一样，就全删除了，此时头节点也为空
        if(head==null)
        {
            return null;
        }
        //定义一个prev等于head，此时head一定不是要删除的节点
        ListNode prev=head;
        //如果prev没有遍历到最后为空，就一直执行
        while(prev.next != null)
        {
            //如果prev.next遍历到了要删除的节点
            if(prev.next.val==val)
            {
                //先声明一个delNode等于prev.next
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }
            //否则就向后移
            else
                prev=prev.next;
        }
        return head;//返回head有什么用？
    }
    public static void main(String[] args)
    {
        int[] nums =new int[]{1,2,6,3,4,5,6};
        //需要一个方法把数组转成链表
        //传入的时数组nums
        ListNode head=new ListNode(nums);
        System.out.println(head);
        //测试，head为链表的头节点
        ListNode res=(new Solution()).removeElements(head,6);
        System.out.println(res);
    }
}