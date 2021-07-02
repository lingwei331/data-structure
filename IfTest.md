package demo;

import  java.util.*;
public class IfTest
{
    public static void main(String[] args)
    {
        double salary;
        System.out.println("Please tell me your salary: ");
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        //将键盘的下一个浮点数装入变量
        salary = sc.nextDouble();//读取用户输入的数
        if (salary > 30000)
        {
            System.out.println("richer");
        }
        else if(salary > 10000)
        {
            System.out.println("中产");
        }
        else
        {
            System.out.println("loser");
        }

    }
}
