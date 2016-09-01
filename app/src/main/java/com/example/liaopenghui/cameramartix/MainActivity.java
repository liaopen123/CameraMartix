package com.example.liaopenghui.cameramartix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.iv);
        Rotate3DAnimation rotate3DAnimation = new Rotate3DAnimation(0,180);
        rotate3DAnimation.setDuration(2000);
        rotate3DAnimation.setRepeatCount(10);
        view.startAnimation(rotate3DAnimation);
    }
}
