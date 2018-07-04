package xiangqing.hulian.com.myapplication;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/16.
 */

public class TestDemo {

    static int a=100;
    static ArrayList<Integer> list=new ArrayList<Integer>();

    public static void main(String[] args) {
        list.add(2);
        p_add(list);
        p_out();
    }

    public static void p_add(ArrayList list1){
        list1.add(1);
    }

    public static void p_out(){
       System.out.print(list+"");
    }

}
