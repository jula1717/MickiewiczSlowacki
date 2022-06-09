package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void drop(View view) {
        ImageView clicked = (ImageView) view;
        clicked.setTranslationY(-200f);
        clicked.setImageResource(R.drawable.mickiewicz);
        clicked.animate().translationYBy(200f).setDuration(300);
        System.out.println("clicked");
    }
}