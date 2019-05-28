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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classButton = findViewById(R.id.classButton);
        classConstructorButton = findViewById(R.id.classConstructorButton);

        classButton.setOnClickListener(clickListener);
        classConstructorButton.setOnClickListener(clickListener);
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
}
