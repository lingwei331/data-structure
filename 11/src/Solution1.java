class Solution1
{
    public int maxArea(int[] height)
    {
        int maxarea=0;
        int l=0;
        int r=height.length-1;
        while(l<r)
        {
            maxarea=Math.max(maxarea,Math.min(height[l],height[r])*(l-r));
        }
        if(height[l]>height[r])
            r--;
        else
            l++;
        return maxarea;
    }
    //本地测试
    public static void main(String[] args)
    {
        int[] height=new int[]{2,7,3,5,1,3,5,9,5};
        System.out.println("最大面积为："+new Solution1().maxArea(height));
    }

}