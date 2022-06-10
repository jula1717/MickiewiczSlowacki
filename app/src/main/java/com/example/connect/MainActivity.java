package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtWinnerIs = (TextView) findViewById(R.id.txtWinnerIs);
        linearLayout = (LinearLayout) findViewById(R.id.GameOverLayout);
        isGameActive = true;
    }

    TextView txtWinnerIs;
    LinearLayout linearLayout;
    boolean isGameActive;
    int [] board = {2,2,2,2,2,2,2,2,2}; //2 means empty, 1 means Słowacki, 0 means Mickiewicz
    int [][] winningPositions = {{0,3,6},{1,4,7},{2,5,8},{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6}};
    boolean activePlayer = false; // false Mickiewicz | true Słowacki
    public void drop(View view) {
        ImageView clicked = (ImageView) view;
        int clickedOnBoard = Integer.parseInt(clicked.getTag().toString());
        if (board[clickedOnBoard]==2 && isGameActive)
        {
            clicked.setTranslationY(-200f);
            if(activePlayer ==false)
            {
                board[clickedOnBoard]=0;
                clicked.setImageResource(R.drawable.mickiewicz);
                activePlayer =true;
                System.out.println("Board["+clickedOnBoard+"]="+board[clickedOnBoard]);//
            }
            else
            {
                board[clickedOnBoard]=1;
                clicked.setImageResource(R.drawable.slowacki);
                activePlayer =false;
                System.out.println("Board["+clickedOnBoard+"]="+board[clickedOnBoard]);
            }
            clicked.animate().translationYBy(200f).setDuration(300);
            for (int [] winningPosition:winningPositions
            ) {
                if(board[winningPosition[0]]==board[winningPosition[1]]&&
                        board[winningPosition[1]]==board[winningPosition[2]]&&      //jeśli na wszystkich trzech polach zwycięskiej kombinacji jest ten sam stan
                        board[winningPosition[0]]!=2)                               //ale nie jest to puste pole
                {
                    isGameActive=false;
                    String winner = activePlayer==false?"Słowacki":"Mickiewicz";
                    txtWinnerIs.setText("The winner is "+winner);
                    linearLayout.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    public void playAgain(View view)
    {
        isGameActive = true;
        linearLayout.setVisibility(View.INVISIBLE);
//        for (int field:board
//        ) {
//            field=2;
//        }
       activePlayer = activePlayer==true?false:true; //zaczyna ten co wygrywa
        for(int i = 0;i<board.length;i++)
        {
            board[i]=2;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }

    }
}