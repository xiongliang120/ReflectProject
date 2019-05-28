package com.xiongliang.reflectionproject.reflect;

import android.util.Log;

public class Test {
    private String name = "xiongliang";
    private static String address = "深圳";

    public Test(){
        Log.i("msg","调用空构造函数");
    }

    public  Test(int a){
        Log.i("msg","调用int 参数,构造函数");
    }

    private  Test(int a,String text){
        Log.i("msg","调用int, string参数，构造函数");
    }

    private String callPrivateMethod(String text){
        Log.i("msg","调用私有方法");
        return "abc";
    }

    private static String callPrivateStaticMethod(String text){
        Log.i("msg","调用私有静态方法");
        return "def";
    }

}
