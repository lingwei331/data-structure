import sun.font.CreatedFontTracker;

import java.util.Stack;

class Solution
{
    public int trap(int[] height)
    {
        Stack<Integer> stack=new Stack<>();
        int i=0;
        int res=0;
        while(i<height.length)
        {
            while(!stack.isEmpty() && height[i]>=height[stack.peek()])
            {
                int top= stack.pop();
                if(stack.isEmpty())
                    break;
                int d=i-stack.peek()-1;
                int h=Math.min(height[i],height[stack.peek()])-height[top];
                res+=d*h;
            }
            stack.push(i++);
        }
        return res;
    }
    //测试
    public static void main(String[] args)
    {
        int[] height1=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(height1));

        int[] height2=new int[]{9,1,2,8,1,5,6,44,2,6,2,4};
        System.out.println(new Solution().trap(height2));
    }

}