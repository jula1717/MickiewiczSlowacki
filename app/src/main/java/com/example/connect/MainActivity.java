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
    int [] board = {2,2,2,2,2,2,2,2,2}; //2 means empty, 1 means Słowacki, 0 means Mickiewicz
    boolean ActivePlayer = false; // false Mickiewicz | true Słowacki
    public void drop(View view) {
        ImageView clicked = (ImageView) view;
        int clickedOnBoard = Integer.parseInt(clicked.getTag().toString());
        if (board[clickedOnBoard]==2)
        {
            clicked.setTranslationY(-200f);
            if(ActivePlayer==false)
            {
                board[clickedOnBoard]=0;
                clicked.setImageResource(R.drawable.mickiewicz);
                ActivePlayer=true;
            }
            else
            {
                board[clickedOnBoard]=1;
                clicked.setImageResource(R.drawable.slowacki);
                ActivePlayer=false;
            }
            clicked.animate().translationYBy(200f).setDuration(300);
        }
        System.out.println("clicked");
    }
}