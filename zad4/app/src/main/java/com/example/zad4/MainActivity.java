package com.example.zad4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button rolldice;
    private Button resetbutton;

    private TextView dice1;
    private TextView dice2;
    private TextView dice3;
    private TextView dice4;
    private TextView dice5;

    private TextView rollresult;
    private TextView gameresult;
    private TextView rollcount;
    private int liczba_rzut = 0;
    private int sum = 0;
    private int sum_gry = 0;
    private ArrayList<Integer> wyn_los;

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rolldice = findViewById(R.id.rolldice);
        resetbutton = findViewById(R.id.resetButton);

        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        dice3 = findViewById(R.id.dice3);
        dice4 = findViewById(R.id.dice4);
        dice5 = findViewById(R.id.dice5);

        rollresult = findViewById(R.id.rollResultText);
        gameresult = findViewById(R.id.gameResultText);
        rollcount = findViewById(R.id.rollCountText);
        wyn_los = new ArrayList<>();

        rolldice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liczba_rzut++;
                rollcount.setText("Liczba rzutów: " + liczba_rzut);

                int[] wyniki = new int[5];
                for (int i = 0; i < 5; i++) {
                    wyniki[i] = random.nextInt(6) + 1;
                    sum += wyniki[i];
                }

                dice1.setText(String.valueOf(wyniki[0]));
                dice2.setText(String.valueOf(wyniki[1]));
                dice3.setText(String.valueOf(wyniki[2]));
                dice4.setText(String.valueOf(wyniki[3]));
                dice5.setText(String.valueOf(wyniki[4]));

                rollresult.setText("Wynik tego losowania: " + sum);
                sum_gry += sum;
                gameresult.setText("Wynik gry: " + sum_gry);
                sum = 0;
            }
        });

        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice1.setText("?");
                dice2.setText("?");
                dice3.setText("?");
                dice4.setText("?");
                dice5.setText("?");
                liczba_rzut = 0;
                rollcount.setText("Liczba rzutów: " + liczba_rzut);
                sum = 0;
                rollresult.setText("Wynik tego losowania: " + sum);
                sum_gry = 0;
                gameresult.setText("Wynik gry: " + sum_gry);
            }
        });
    }
}