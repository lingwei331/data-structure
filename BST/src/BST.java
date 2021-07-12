import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class BST<E extends Comparable> //类型E具有可比较性
{
    private class Node
    {
        public E e;
        public  Node left,right;

        //小e是用户传来的，类型为E
        public Node(E e)
        {
            this.e=e;//右边的e是用户传来的e
            left=null;
            right=null;
        }
    }
    private Node root;
    private int size;

    public BST()
    {
        root=null;
        size=0;

    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void add(E e)
    {
        root=add(root,e);//向root中插入元素e
    }
    //向以node为根的二分搜索树中插入元素e，递归算法
    //返回插入新节点后的二分搜索树的根
    private Node add(Node node,E e)
    {
        /*
        //如果插入的元素e是否等于node的e
        if(e.equals(node.e))
            return;
        //如果插入的元素e小于node的e，使用compareTo方法来比较
        else if(e.compareTo(node.e)<0 && node.left==null)
        {
            node.left=new Node(e);
            size++;
            return;
        }
        else if(e.compareTo(node.e)>0 && node.right==null)
        {
            node.right=new Node(e);
            size++;
            return;
        }
        */
        if(node==null)
        {
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0)
            node.left=add(node.left,e);//如果node.left为空，那么这一次add就会返回一个新的节点e，然后node.left被赋值上这个新节点，相当于改变了这整棵二叉树
        else if(e.compareTo(node.e)>0)
           node.right =add(node.right,e);
        return node;
    }
    //看二分的搜索树是否包含元素e,用户
    public boolean contains(E e)
    {
        return contains(root,e);
    }
    //看以node为根的二分搜索树是否包含元素e，递归算法
    private boolean contains(Node node,E e)
    {
        if(node==null)
            return false;
        if(e.compareTo(node.e)==0)
            return true;
        else if(e.compareTo(node)<0)
            return contains(node.left,e);
        else
            return contains(node.right,e);
    }
    //二分搜索数的前序遍历
    public void preOrder()
    {
        preOrder(root);//用户初始只需要调用只需要对root调用这个preOrder
    }
    //前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node)
    {
        if(node==null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //前序遍历非递归方法
    public void preOrderNR()
    {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            Node cur=stack.pop();
            System.out.println(cur.e);

            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
        }
    }

    public void inOrder()
    {
        inOrder(root);
    }
    //中序遍历
    private void inOrder(Node node)
    {
        if(node==null)
            return;
        inOrder(node.left);
        //访问节点元素
        System.out.println(node.e);
        inOrder(node.right);
    }
    //二分搜索树的后续遍历
    public void postOrder()
    {
        postOrder(root);
    }
    //后续遍历以node为根的二分搜索树，递归算法
    private void postOrder(Node node)
    {
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOreder()
    {
        Queue<Node> q=new LinkedList<>();//使用链表实现队列
        q.add(root);
        while(!q.isEmpty())
        {
            Node cur=q.remove();//队列中出队的元素等于cur
            System.out.println(cur.e);

            if(cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }
    }
    //寻找二分搜索树的最小元素
    public E minimum()
    {
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }
    private Node minimum(Node node)
    {
        if(node.left==null)
            return node;
        return minimum(node.left);
    }

    //寻找二分搜索树的最大元素
    public E maximum()
    {
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }
    private Node maximum(Node node)
    {
        if(node.right==null)
            return node;
        return maximum(node.right);
    }
    //从二分搜索树中删除最小值所在节点，返回最小值
    public E removeMin()
    {
        E ret=minimum();
        root=removeMin(root);//从root节点开始
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node)
    {
        if(node.left==null)
        {
            //保存一下当前节点的右子树
            Node rightNode=node.right;
            //让当前节点和二叉树断开
            node.right=null;
            size--;
            return rightNode;//返回新的二叉搜索树的根
        }
        //若没有递归到底，说明Node还有左孩子，
        node.left=removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除最大值所在节点，返回最大值
    public E removeMax()
    {
        E ret=maximum();
        root=removeMax(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最大节点
    //返回删除节点后新的二分搜索树
    private Node removeMax(Node node)
    {
        if(node.right==null)
        {
            //保存一下当前节点的左子树
            Node leftNode=node.left;
            //让当前节点和二叉树断开
            node.left=null;
            size--;
            return leftNode;
        }
        node.right=removeMax(node.right);
        return node;
    }
    //删除元素为e的节点
    public void remove(E e)
    {
        root=remove(root,e);
    }
    //删除掉以node为根的二分搜索树中元素为e的节点，递归算法
    //返回删除节点后新的二分搜索书的根
    private Node remove(Node node,E e)
    {
        if(node==null)
            return null;
        if(e.compareTo(node.e)<0)
        {
            node.left=remove(node.left,e);
            return node;
        }
        else if(e.compareTo(node.e)>0)
        {
            node.right=remove(node.right,e);
            return node;
        }
        else//e==node.e
        {
            //待删除节点左子树为空的情况
            if(node.left==null)
            {
                //保存一下当前节点的右子树
                Node rightNode=node.right;
                //让当前节点和二叉树断开
                node.right=null;
                size--;
                return rightNode;//返回新的二叉搜索树的根
            }
            //待删除节点右子树为空的情况
            if(node.right==null)
            {
                //保存一下当前节点的左子树
                Node leftNode=node.left;
                //让当前节点和二叉树断开
                node.left=null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor=minimum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder res=new StringBuilder();
        //递归函数
        generateBSTString(root,0,res);
        return res.toString();//什么意思？
    }
    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node,int depth,StringBuilder res)
    {
        if(node==null)
        {
            res.append(generateDepthString(depth) +"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }
    private String generateDepthString(int depth)
    {
        StringBuilder res=new StringBuilder();
        for(int i=0;i<depth;i++)
            res.append("--");
        return res.toString();//什么意思？
    }
}
