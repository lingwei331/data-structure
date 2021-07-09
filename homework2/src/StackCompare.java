/*
本代码的作用是
给定两个字符串，当它们分别被输入后，判断二者是否相等，并返回结果。
如果相等返回true，不相等返回false。输入字符串可包含 #，它代表退格字符。
 */
//导入java的util提供的类
import java.util.Stack;
public class StackCompare
{
    public boolean backspaceCompare(String S, String T)
    {
        //声明栈名为s，t，传入的数据为Character类型
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        //遍历S
        for(int i=0;i<S.length();i++)
        {
            //如果不是退格字符就入栈
            if(S.charAt(i)!= '#')
            {
                s.push(S.charAt(i));
            }
            //是退格字符且不为空就出栈
            else if(!s.isEmpty())
                s.pop();
        }
        System.out.println(s);
        //遍历T
        for(int j=0;j<T.length();j++)
        {
            //如果不是退格字符就入栈
            if(T.charAt(j)!='#')
            {
                t.push(T.charAt(j));
            }
            //是退格字符且不为空就出栈
            else if(!t.isEmpty())
                t.pop();
        }
        System.out.println(t);
        return s.equals(t);
    }
    //添加main方法本地测试
    public static void main(String[] args)
    {
        //new一个StackCompare的类，直接调用backspaceCompare方法，传入测试用例
        System.out.println((new StackCompare().backspaceCompare("ab#c","ac#c")));
        System.out.println((new StackCompare().backspaceCompare("ad#cd","ac")));
    }
}
