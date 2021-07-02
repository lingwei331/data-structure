package demo;

public class SwithTest
{
    public static void main(String[] args)
    {
        char score = 'A';
        switch (score)
        {
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
                System.out.println("良好");
                break;
            case 'C':
                System.out.println("中");
                break;
            case 'D':
                System.out.println("及格");
                break;
            case 'E':
                System.out.println("不及格");
                break;
            default:
                System.out.println("其他");
        }
    }
}
