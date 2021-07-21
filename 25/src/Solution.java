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


class Solution
{
    public class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k)
    {
        //如果链表为空或者只有一个节点
        if(head==null || head.next==null)
            return head;

        ListNode tail=head;

        for(int i=0;i<k;i++)
        {
            if(tail==null)
                return head;
            tail=tail.next;
        }

        ListNode newhead=reverse(head,tail);//[head,tail)
        head.next=reverseKGroup(tail,k);//接上，此时head值未变，但位置变了
        return newhead;
    }
    public ListNode reverse(ListNode head,ListNode tail)
    {
        ListNode pre=null;
        while(head!=tail)
        {
            ListNode next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}