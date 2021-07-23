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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
{
    public class TreeNode
    {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right)
         {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }
    public class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public TreeNode sortedListToBST(ListNode head)
    {
        //定义快慢指针
        ListNode fastPointer=head;
        ListNode slowPointer=head;
        //定义中间节点的前一个节点
        ListNode frontMid=null;
        if(head==null)
            return null;
        //当快指针的下一个不为空，且快指针的下一个的下一个不为空
        while(fastPointer.next!=null && fastPointer.next.next!=null)
        {
            fastPointer=fastPointer.next.next;
            frontMid=slowPointer;
            slowPointer=slowPointer.next;
        }
        //若没有进入上面循环，则该链表只有一个或两个节点，将head置为null，即树的左边为空
        if(frontMid==null)
            head=null;
        //将链表左部分断开
        else
            frontMid.next=null;
        //右边链表的头节点
        ListNode behindMid=slowPointer.next;
        //二叉搜索树的根节点
        TreeNode root=new TreeNode(slowPointer.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(behindMid);
        return root;
    }
}