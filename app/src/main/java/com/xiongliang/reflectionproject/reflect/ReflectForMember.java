package com.xiongliang.reflectionproject.reflect;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.FileHandler;

public class ReflectForMember {
    /**
     * 获取构造函数，包括 private, public,也支持无参数和有参数
     */
    public void getConstructor() {
        Test test = new Test();
        Class temp = test.getClass();
        String className = temp.getName();
        //getDeclaredConstructors() 获取public构造函数, getConstructors()获取所有构造函数
        Constructor[] constructors = temp.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            int mod = constructors[i].getModifiers(); //输出修饰符
            String modifierStr = Modifier.toString(mod);
            Log.i("msg","打印构造函数修饰符="+modifierStr);
            Class[] parameterTypes = constructors[i].getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                String paramName = parameterTypes[j].getName();
                Log.i("msg","打印构造函数参数="+paramName);
            }
        }
    }

    /**
     * 调用构造函数
     */
    public void callConstructor(){
        try{
            Class temp = Class.forName("com.xiongliang.reflectionproject.reflect.Test");

            Constructor c1 = temp.getDeclaredConstructor();  //调用无参构造函数
            Object object1 = c1.newInstance();

            Class[] p1 = {int.class};
            Constructor c2 = temp.getDeclaredConstructor(p1); //获取有一个参数的构造函数，参数为int
            Object object2 = c2.newInstance(2);


            Class[] p2 = {int.class, String.class};
            Constructor c3 = temp.getDeclaredConstructor(p2);
            c3.setAccessible(true);
            Object object3 = c3.newInstance(4,"xiongliang");
            Log.i("msg","");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取类的私有实例方法并调用它
     */
    public void callPrivateMethod(){
        try{
            Class temp = Class.forName("com.xiongliang.reflectionproject.reflect.Test");

            Constructor c1 = temp.getDeclaredConstructor();  //调用无参构造函数
            Object object1 = c1.newInstance();
            Class[] p1 = {String.class};
            Method method = temp.getDeclaredMethod("callPrivateMethod",p1); //在指定类中获取指定的方法
            method.setAccessible(true);

            Object argList[] = {"xiongliang"};
            Object result = method.invoke(object1,argList);
            Log.i("msg","调用私有方法成功"+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取类的静态的私有方法并调用它
     */
    public void callPrivateStaticMethod(){
        try{
            Class temp = Class.forName("com.xiongliang.reflectionproject.reflect.Test");
            Class[] p1 = {String.class};
            Method method = temp.getDeclaredMethod("callPrivateStaticMethod",p1);
            method.setAccessible(true);
            Object argList[] = {"xiongliang"};
            Object result = method.invoke(null,argList);
            Log.i("msg","调用私有静态方法成功"+result);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 获取类的私有变量并修改它
     */
    public void setPrivateField(){
        try{
            Class temp = Class.forName("com.xiongliang.reflectionproject.reflect.Test");
            Constructor c1 = temp.getDeclaredConstructor();  //调用无参构造函数
            Object object1 = c1.newInstance();

            Field field = temp.getDeclaredField("name");
            field.setAccessible(true);
            Object fieldObject = field.get(object1);
            field.set(object1,"test");

            Object fieldValue  = field.get(object1);
            Log.i("msg","修改私有变量成功"+fieldValue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取私有静态字段并修改它
     */
    public void setPrivateStaticField(){
        try{
            Class temp = Class.forName("com.xiongliang.reflectionproject.reflect.Test");
            Field field = temp.getDeclaredField("address");
            field.setAccessible(true);
            Object fieldObject = field.get(null);
            field.set(fieldObject,"test");
            Log.i("msg","修改私有静态变量成功"+ field.get(null));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 获取泛型类中泛型对象
     */
    public void getGenericFiled(){
        try{
            AMN.getgDefault().get();
            Class<?> instance = Class.forName("com.xiongliang.reflectionproject.reflect.GenericTest");
            Field mInstanceFieldId = instance.getDeclaredField("mInstance");
            mInstanceFieldId.setAccessible(true);

            Class<?> temp = Class.forName("com.xiongliang.reflectionproject.reflect.AMN");
            Field mDefaultFieldId = temp.getDeclaredField("gDefault");
            mDefaultFieldId.setAccessible(true);
            Object gDefault = mDefaultFieldId.get(null);
            Log.i("msg","获取泛型对象="+gDefault);

            Object rawObjecct = mInstanceFieldId.get(gDefault);
            Log.i("msg","获取泛型对象="+rawObjecct);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
