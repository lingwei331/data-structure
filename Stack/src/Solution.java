//import java.util.Stack;
class Solution
{
    public boolean isValid(String s)//如果把public换成private，则在力扣中会编译出错。力扣自己创建的方法则无法访问该逻辑
    {
        //Stack                         //Stack
        ArrayStack<Character> stack =new ArrayStack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{')
                stack.push(c);
            else
            {
                if(stack.isEmpty())
                    return false;
                char topChar=stack.pop();
                if(c==')' && topChar != '(')
                    return false;

                if(c==']' && topChar !='[')
                    return false;

                if(c=='}' && topChar !='{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
    //本地测试
    public static void main(String[] args)
    {
        System.out.println((new Solution().isValid("()[]{}")));
        System.out.println((new Solution().isValid(")[{")));
    }
}


