import java.util.Stack;
public class StackCompare
{
    public boolean backspaceCompare(String S, String T)
    {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for(int i=0;i<S.length();i++)
        {
            //如果不是退格字符就入栈
            if(S.charAt(i)!= '#')
            {
                s.push(S.charAt(i));

            }
            //是退格字符并且栈不是空，就出栈
            else
                s.pop();
        }
        System.out.println(s);
        for(Character j:T.toCharArray())
        {
            if(j!='#')
            {
                t.push(j);

            }
            else
                t.pop();

        }
        System.out.println(t);
        return s.equals(t);
    }
    //本地测试
    public static void main(String[] args)
    {
        System.out.println((new StackCompare().backspaceCompare("ab#c","ac#c")));
        System.out.println((new StackCompare().backspaceCompare("ad#cd","ac")));
    }

}
