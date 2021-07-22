class Solution
{
    private final String[] lessThanTen=new String[]{"","One","Two","Three","Four","Five",
            "Six","Seven","Eight","Nine"};
    private final String[] lessThanTwenty=new String[]{"Ten","Eleven","Twelve","Thirteen",
            "Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private final String[] lessThanHundred=new String[]{"","Ten","Twenty","Thirty","Forty",
            "Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num)
    {
        if (num == 0) {
            return "Zero";
        }
        return nw(num);
    }
    private String nw(int num)
    {

        String res=new String();
        if(num<10)
        {
            res=lessThanTen[num];
        }
        else if(num<20)
        {
            res=lessThanTwenty[num-10];
        }
        else if(num<100)
        {
            res=lessThanHundred[num/10]+" "+numberToWords(num%10);
        }
        else if(num<1000)
        {
            res=numberToWords(num/100)+" Hundred And "+numberToWords(num%100);
        }
        else if(num<1000000)
        {
            res=numberToWords(num/1000)+" Thousand And "+numberToWords(num%1000);
        }
        else if(num<1000000000)
        {
            res=numberToWords(num/1000000)+" Million And "+numberToWords(num%1000000);
        }
        else
        {
            res=numberToWords(num/1000000000)+" Billion And "+numberToWords(num%1000000000);
        }
        return res.trim();
    }
    //本地测试
    public static void main(String[] args)
    {
        int num1=1234567890;
        System.out.println(new Solution().numberToWords(num1));

        int num2=99999999;
        System.out.println(new Solution().numberToWords(num2));
    }
}
