import java.util.ArrayDeque;
import java.util.Deque;
class Solution
{
    public String removeDuplicateLetters(String s)
    {
        int len=s.length();
        //将输入字符串保存为字符数组
        char[] charArray=s.toCharArray();
        //记录了每个字符最后一次出现的下标
        int[] lastIndex=new int[26];
        for(int i=0;i<len;i++)
        {
            //保存每个字符最后以此出现的下标
            lastIndex[charArray[i]-'a']=i;
        }
        Deque<Character> stack=new ArrayDeque<>();
        //记录某个字符在栈中是否出现
        boolean[] visited=new boolean[26];
        for(int i=0;i<len;i++)
        {
            //如果当前遍历的字符在栈中已经存在，将其丢弃
            if(visited[charArray[i]-'a'])
            {
                continue;
            }
            //如果栈顶元素的ascii码值大于当前遍历到的栈的元素，且当前栈顶元素在以后还会看到，当前栈非空
            while(!stack.isEmpty() && stack.peekLast()>charArray[i] && lastIndex[stack.peekLast()-'a']>i)
            {
                //将栈顶元素拿出来
                Character top=stack.removeLast();
                //维护visited数组
                visited[top-'a']=false;
            }
            //否则将当前元素添加到栈顶，
            stack.addLast(charArray[i]);
            //维护visited数组
            visited[charArray[i]-'a']=true;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(char c:stack)
        {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(new Solution().removeDuplicateLetters("adsadsafac"));
    }
}