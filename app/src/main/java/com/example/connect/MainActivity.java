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
    int [][] winningPositions = {{0,3,6},{1,4,7},{2,5,8},{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6}};
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
                System.out.println("Board["+clickedOnBoard+"]="+board[clickedOnBoard]);//
            }
            else
            {
                board[clickedOnBoard]=1;
                clicked.setImageResource(R.drawable.slowacki);
                ActivePlayer=false;
                System.out.println("Board["+clickedOnBoard+"]="+board[clickedOnBoard]);
            }
            clicked.animate().translationYBy(200f).setDuration(300);
            for (int [] winningPosition:winningPositions
            ) {
                if(board[winningPosition[0]]==board[winningPosition[1]]&&
                        board[winningPosition[1]]==board[winningPosition[2]]&&      //jeśli na wszystkich trzech polach zwycięskiej kombinacji jest ten sam stan
                        board[winningPosition[0]]!=2)                               //ale nie jest to puste pole
                {
                    System.out.println("The winner is "+board[winningPosition[0]] );
                }
            }
        }
        System.out.println("clicked");
        //test GitHub
    }
}