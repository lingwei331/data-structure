class Solution
{
    public int minPatches(int[] nums, int n)
    {
        int minNum=0;
        long x=1;
        int index=0;
        while(x<=n)
        {
            if(index<nums.length && nums[index]<=x)
            {
                x+=nums[index];
                index++;
            }
            else
            {
                x+=x;
                minNum++;
            }
        }
        return minNum;
    }
    //本地测试
    public static void main(String[] args)
    {
        int[] nums=new int[]{1,2,4,13,43};
        int n=100;
        System.out.println(new Solution().minPatches(nums,n));
    }
}