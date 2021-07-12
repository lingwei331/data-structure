import java.util.ArrayList;
import java.util.Random;
public class Main
{
    public static void main(String[] args)
    {
        /*
        BST<Integer> bst=new BST<>();
        int[] nums=new int[]{5,3,6,8,4,2};
        //将nums数组中的每个元素取出来，插入进bst中
        for(int num:nums)
            bst.add(num);

        bst.levelOreder();
        System.out.println();

        bst.preOrder();
        System.out.println();
        //System.out.println(bst.toString());

        bst.preOrderNR();
        System.out.println();

        bst.inOrder();
        System.out.println();//打印结果即为所有元素排序的结果

        bst.postOrder();
        System.out.println();

         */

        BST<Integer> bst =new BST<>();
        Random random=new Random();
        int n=1000;
        for(int i=0;i<n;i++)
            bst.add(random.nextInt(10000));
        ArrayList<Integer> nums=new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMin());
        System.out.println(nums);
        for(int i=1;i<nums.size();i++)
            if(nums.get(i-1)>nums.get(i))
                throw new IllegalArgumentException("Error");
        System.out.println("remobeMin test completed.");

        for(int i=0;i<n;i++)
            bst.add(random.nextInt(10000));
        nums=new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMax());
        System.out.println(nums);
        for(int i=1;i<nums.size();i++)
            if(nums.get(i-1)<nums.get(i))
                throw new IllegalArgumentException("Error");
        System.out.println("remobeMin test completed.");
    }
}
