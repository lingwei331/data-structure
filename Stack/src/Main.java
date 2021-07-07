//使用自己编写的数组类
public class Main {
    public static void main(String[] args)
    {
        Array<Integer> arr = new Array<Integer>();//给他传入一个参数,告诉arr传入的是Integer类型的
        for(int i=0;i<10;i++)//先放入10个元素
            arr.addLast(i);//在数组的末尾添加i
        arr.toString();
        System.out.println(arr);
        System.out.println(arr.toString());
        System.out.println(arr.getSize());

        arr.add(1,100);
        System.out.println(arr);//添加了一个新元素以后，size=data.length,扩容2倍

        arr.addFirst(-1);
        System.out.println(arr);

        arr.get(4);
        System.out.println(arr.get(4));//获取index为4的元素

        System.out.println(arr.get(4));//获取index为4的元素

        arr.set(5,33);
        System.out.println(arr);

        //System.out.println(arr.set(5,33));set方法没有返回值，报错

        System.out.println(arr.contains(33));

        System.out.println(arr.find(33));

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);//缩容，容积变为一半

        arr.removeFirst();
        System.out.println(arr);

    }
}
