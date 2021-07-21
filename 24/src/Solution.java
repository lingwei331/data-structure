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
    public ListNode swapPairs(ListNode head)
    {
        ListNode dummyhead=new ListNode(0);
        ListNode cur=head;
        while(cur.next!=null && cur.next.next!=null)
        {
            ListNode next=cur.next;
            ListNode nnext=cur.next.next;
            next=nnext.next;
            nnext.next=next;
            cur.next=nnext;
            cur=cur.next.next;

        }
        return dummyhead.next;
    }
}