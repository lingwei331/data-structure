//用虚拟头节点
class Solution2
{
    public ListNode removeElements(ListNode head, int val)
    {
        //创建一个虚拟头节点，且赋值，任意值
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        //定义一个prev等于head，此时head一定不是要删除的节点
        ListNode prev = dummyHead;
        //如果prev没有遍历到最后为空，就一直执行
        while (prev.next != null) {
            //如果prev.next遍历到了要删除的节点
            if (prev.next.val == val) {
                //先声明一个delNode等于prev.next
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            //否则就向后移
            else
                prev = prev.next;
        }
        return dummyHead.next;//虚拟头节点的建立对用户时屏蔽的//返回head有什么用？
    }
    public static void main(String[] args)
    {
        int[] nums =new int[]{1,2,6,3,4,5,6};
        //需要一个方法把数组转成链表
        //传入的时数组nums
        ListNode head=new ListNode(nums);
        System.out.println(head);
        //测试，head为链表的头节点
        ListNode res=(new Solution2()).removeElements(head,6);
        System.out.println(res);
    }
}