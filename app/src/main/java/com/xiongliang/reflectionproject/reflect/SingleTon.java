package com.xiongliang.reflectionproject.reflect;

public class SingleTon<T> {
    private T mInstance;

    public void setSingleTon(T t){
        mInstance = t;
    }
}
