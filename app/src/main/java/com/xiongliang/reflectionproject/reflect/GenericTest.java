package com.xiongliang.reflectionproject.reflect;

public abstract class GenericTest<T> {
    private T mInstance;

    abstract T create();

    public final T get(){
        synchronized (this){
            if(mInstance == null){
                mInstance = create();
            }
            return mInstance;
        }
    }

}
