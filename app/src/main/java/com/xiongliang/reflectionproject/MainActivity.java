package com.xiongliang.reflectionproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiongliang.reflectionproject.reflect.ReflectForMember;
import com.xiongliang.reflectionproject.reflect.ReflectForObject;

public class MainActivity extends AppCompatActivity {
    private Button classButton;
    private Button classConstructorButton;
    private Button callConstructorButton;
    private Button callPrivateMethodButton;
    private Button callPrivateStaticMethodButton;
    private Button setPrivateFieldButton;
    private Button setPrivateStaticFieldButton;
    private Button getGenericFiledButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classButton = findViewById(R.id.classButton);
        classConstructorButton = findViewById(R.id.classConstructorButton);
        callConstructorButton = findViewById(R.id.callConstructor);
        callPrivateMethodButton = findViewById(R.id.callPrivateMethod);
        callPrivateStaticMethodButton = findViewById(R.id.callPrivateStaticMethod);
        setPrivateFieldButton = findViewById(R.id.setPrivateField);
        setPrivateStaticFieldButton = findViewById(R.id.setPrivateStaticField);
        getGenericFiledButton = findViewById(R.id.getGenericFiled);

        classButton.setOnClickListener(clickListener);
        classConstructorButton.setOnClickListener(clickListener);
        callConstructorButton.setOnClickListener(clickListener);
        callPrivateMethodButton.setOnClickListener(clickListener);
        callPrivateStaticMethodButton.setOnClickListener(clickListener);
        setPrivateFieldButton.setOnClickListener(clickListener);
        setPrivateStaticFieldButton.setOnClickListener(clickListener);
        getGenericFiledButton.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id){
                case R.id.classButton:
                    testReflectObject();
                    break;
                case R.id.classConstructorButton:
                    testReflectConstructor();
                    break;
                case R.id.callConstructor:
                    testCallConstructor();
                    break;
                case R.id.callPrivateMethod:
                    testCallPrivateMethod();
                    break;
                case R.id.callPrivateStaticMethod:
                    testCallPrivateStaticMethod();
                    break;
                case R.id.setPrivateField:
                    testSetPrivateField();
                    break;
                case R.id.setPrivateStaticField:
                    testSetPrivateStaticField();
                    break;
                case R.id.getGenericFiled:
                    testGetGenericFiled();
                    break;
                default:
                    break;
            }
        }
    };

    public void testReflectObject(){
        ReflectForObject reflectForObject = new ReflectForObject();
        reflectForObject.getObjectClass();
    }

    public void testReflectConstructor(){
        ReflectForMember reflectForMember = new ReflectForMember();
        reflectForMember.getConstructor();
    }

    public void testCallConstructor(){
        ReflectForMember reflectForMember = new ReflectForMember();
        reflectForMember.callConstructor();
    }

    public void testCallPrivateMethod(){
        ReflectForMember reflectForMember = new ReflectForMember();
        reflectForMember.callPrivateMethod();
    }

    public void testCallPrivateStaticMethod(){
        ReflectForMember reflectForMember = new ReflectForMember();
        reflectForMember.callPrivateStaticMethod();
    }

    public void testSetPrivateField(){
        ReflectForMember reflectForMember = new ReflectForMember();
        reflectForMember.setPrivateField();
    }

    public void testSetPrivateStaticField(){
        ReflectForMember reflectForMember = new ReflectForMember();
        reflectForMember.setPrivateStaticField();
    }

    public void testGetGenericFiled(){
        ReflectForMember reflectForMember = new ReflectForMember();
        reflectForMember.getGenericFiled();
    }
}
