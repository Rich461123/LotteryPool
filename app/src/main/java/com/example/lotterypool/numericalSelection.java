package com.example.lotterypool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class numericalSelection extends AppCompatActivity {
    private static TextView firstBall, secondBall, thirdBall, fourthBall, fifthBall, sixthBall;
    private static Button start, stop, quickPick;

    public static int[] sixNum = new int[6];

    Random random = new Random();

    public static TextView[] lotteryBalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical_selection);
        initWidgets();
        extractLotteryBalls();
    }

    private void initWidgets() {
        firstBall = findViewById(R.id.firstBall);
        secondBall = findViewById(R.id.secondBall);
        thirdBall = findViewById(R.id.thirdBall);
        fourthBall = findViewById(R.id.fourthBall);
        fifthBall = findViewById(R.id.fifthBall);
        sixthBall = findViewById(R.id.sixthBall);

        start = findViewById(R.id.buttonStart);
        stop = findViewById(R.id.buttonStop);
        quickPick = findViewById(R.id.buttonQP);
    }

    public void startRoll(View view) {
        start.setText("REROLL");
        for (int i = 0; i < 6; i++){
            sixNum[i] = random.nextInt(49) + 1;		// 將隨機數(1-49)放入 sixNum[i]
            for (int j = 0; j < i;){			// 與前數列比較，若有相同則再取亂數
                if (sixNum[j] == sixNum[i]){
                    sixNum[i] = random.nextInt(49);
                    j = 0;			// 避面重新亂數後又產生相同數字，若出現重覆，迴圈從頭開始重新比較所有數
                }
                else j++;			// 若都不重複則下一個數
            }
        }
    }

    public void stopRoll(View view) {
        int i = 0;
        while(i < 6){
            lotteryBalls[i].setText(String.valueOf(sixNum[i]));
            i++;
        }
        start.setText("START");
    }

    public void quickPick(View view) {
        for (int i = 0; i < 6; i++){
            sixNum[i] = random.nextInt(49) + 1;		// 將隨機數(1-49)放入 sixNum[i]
            for (int j = 0; j < i;){			// 與前數列比較，若有相同則再取亂數
                if (sixNum[j] == sixNum[i]){
                    sixNum[i] = random.nextInt(49);
                    j = 0;			// 避面重新亂數後又產生相同數字，若出現重覆，迴圈從頭開始重新比較所有數
                }
                else j++;			// 若都不重複則下一個數
            }
        }
        int i = 0;
        while(i < 6){
            lotteryBalls[i].setText(String.valueOf(sixNum[i]));
            i++;
        }
        start.setText("START");
    }

    private void extractLotteryBalls() {
        lotteryBalls = new TextView[6];
        lotteryBalls[0] = findViewById(R.id.firstBall);
        lotteryBalls[1] = findViewById(R.id.secondBall);
        lotteryBalls[2] = findViewById(R.id.thirdBall);
        lotteryBalls[3] = findViewById(R.id.fourthBall);
        lotteryBalls[4] = findViewById(R.id.fifthBall);
        lotteryBalls[5] = findViewById(R.id.sixthBall);
    }

}