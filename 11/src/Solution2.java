class Solution2
{
    public int maxArea(int[] height)
    {
        int maxarea=0;
        int s=0;
        for(int i=0;i<height.length;i++)
            for(int j=i+1;j<height.length;j++)
            {
                s=Math.min(height[i],height[j])*(j-i);
                maxarea=Math.max(maxarea,s);
            }
        return maxarea;
    }
    //本地测试
    public static void main(String[] args)
    {
        int[] height=new int[]{2,7,3,5,1,3,5,9,5};
        System.out.println("最大面积为："+new Solution2().maxArea(height));
    }
}