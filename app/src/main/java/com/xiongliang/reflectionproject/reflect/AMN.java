package com.xiongliang.reflectionproject.reflect;

public class AMN {
    private static final GenericTest<Test> gDefault = new GenericTest<Test>() {
        @Override
        Test create() {
            Test test = new Test();
            return test;
        }
    };

    public static GenericTest<Test> getgDefault(){
        return gDefault;
    }
}
