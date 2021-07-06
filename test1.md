//输入自定义数组，输出其中超过数组长度一半的元素
public class test1
{
    public static void main(String[] args)
    {
        //自定义一个数组
        int[] iArr=new int[]{1,2,3,4,1,1,1,1,1};
        //创建一个数组，动态初始化，所有元素值默认为0
        int count[]=new int[4];
        //遍历数组
        for(int i=0;i<iArr.length;i++)
        {
            //使用swiyh循环确定每个元素出现的次数
            switch (iArr[i])
            {
                case 1:
                    count[0]++;
                    break;
                case 2:
                    count[1]++;
                    break;
                case 3:
                    count[2]++;
                    break;
                case 4:
                    count[3]++;
                    break;
            }
        }
        //打印数组中每个元素出现的次数
        System.out.println("数字1出现的次数： "+count[0]);
        System.out.println("数字2出现的次数： "+count[1]);
        System.out.println("数字3出现的次数： "+count[2]);
        System.out.println("数字4出现的次数： "+count[3]);
        //判断出现次数超过数组长度一半的元素
        for(int a=0;a<4;a++)
        {
            if(count[a]>iArr.length/2)
            {
                System.out.println("该数组中超过数组长度一半的元素为： "+(a+1));
            }
        }
    }
}
