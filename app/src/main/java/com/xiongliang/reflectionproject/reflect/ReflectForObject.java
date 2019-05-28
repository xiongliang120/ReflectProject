package com.xiongliang.reflectionproject.reflect;

import android.util.Log;

/**
 *  根据一个字符串得到一个类的对象
 */
public class ReflectForObject {
    public void getObjectClass(){
        try{
            String str = "abc";
            Class c1 = str.getClass();

            Class c2 = Class.forName("java.lang.String");
            Class c3 = Class.forName("android.widget.Button");

            Class c4 = c3.getSuperclass();  //得到父类类型

            Class c5 = String.class;

            Class c6 = Boolean.TYPE;  //基本类型，如Integer都有TYPE属性, 可以得到这个基本类型的类型
            Log.i("msg","c1="+c1+"..c2="+c2+"..c3="+c3+"..c4="+c4+"..c5="+c5+"..c6"+c6);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
