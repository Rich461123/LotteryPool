package com.example.lotterypool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class numericalSelection extends AppCompatActivity {
    private TextView firstBall, secondBall, thirdBall, fourthBall, fifthBall, sixthBall;
    private Button start, stop, quickPick;

    public static int[] sixNum = new int[6];
    public int twoSec = 0;

    public TextView[] lotteryBalls;
    public TextView twoSectionBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical_selection);
        initWidgets();
        extractLotteryBalls();
    }

    private void initWidgets() {
        firstBall = (TextView) findViewById(R.id.firstBall);
        secondBall = (TextView) findViewById(R.id.secondBall);
        thirdBall = (TextView) findViewById(R.id.thirdBall);
        fourthBall = (TextView) findViewById(R.id.fourthBall);
        fifthBall = (TextView) findViewById(R.id.fifthBall);
        sixthBall = (TextView) findViewById(R.id.sixthBall);

        start = (Button) findViewById(R.id.buttonStart);
        stop = (Button) findViewById(R.id.buttonStop);
        quickPick = (Button) findViewById(R.id.buttonQP);
        twoSectionBall = (TextView) findViewById(R.id.twoSectionBall);
    }

    public void startRoll(View view) {

        start.setText("REROLL");

        twoSec = (int) (Math.random() * 8) + 1;//第二區隨機數字1~8

        for (int i = 0; i < 6; i++){
            sixNum[i] = (int) (Math.random() * 49) + 1;// 將隨機數(1~49)放入 sixNum[i]
            for (int j = 0; j < i;){			// 與前數列比較，若有相同則再取亂數
                if (sixNum[j] == sixNum[i]){
                    sixNum[i] = (int) (Math.random() * 49) + 1;
                    j = 0;			// 避面重新亂數後又產生相同數字，若出現重覆，迴圈從頭開始重新比較所有數
                }
                else j++;			// 若都不重複則下一個數
            }
        }
    }

    public void stopRoll(View view) {
        int temp;
        for (int i = 0; i < sixNum.length - 1; i++) {
            boolean Flag = false; // 是否發生交換。沒有交換，提前跳出外層迴圈
            for (int j = 0; j < sixNum.length - 1 - i; j++) {
                if (sixNum[j] > sixNum[j + 1]) {
                    temp = sixNum[j];
                    sixNum[j] = sixNum[j + 1];
                    sixNum[j + 1] = temp;
                    Flag = true;
                }
            }
            if (!Flag)
            {
                break;
            }
        }//泡泡排序法 排列小到大

        int t = 0;
        while(t < 6){
            lotteryBalls[t].setText(String.valueOf(sixNum[t]));
            t++;
        }//顯示數字

        twoSectionBall.setText(String.valueOf(twoSec));//顯示第二區數字
        start.setText("START");
    }

    public void quickPick(View view) {
        for (int i = 0; i < 6; i++){
            sixNum[i] = (int) (Math.random() * 49) + 1;// 將隨機數(1-49)放入 sixNum[i]
            for (int j = 0; j < i;){			// 與前數列比較，若有相同則再取亂數
                if (sixNum[j] == sixNum[i]){
                    sixNum[i] = (int) (Math.random() * 49) + 1;
                    j = 0;			// 避面重新亂數後又產生相同數字，若出現重覆，迴圈從頭開始重新比較所有數
                }
                else j++;			// 若都不重複則下一個數
            }
        }

        int temp;
        for (int i = 0; i < sixNum.length - 1; i++) {
            boolean Flag = false; // 是否發生交換。沒有交換，提前跳出外層迴圈
            for (int j = 0; j < sixNum.length - 1 - i; j++) {
                if (sixNum[j] > sixNum[j + 1]) {
                    temp = sixNum[j];
                    sixNum[j] = sixNum[j + 1];
                    sixNum[j + 1] = temp;
                    Flag = true;
                }
            }
            if (!Flag)
            {
                break;
            }
        }//泡泡排序法 排列小到大

        int i = 0;
        while(i < 6){
            lotteryBalls[i].setText(String.valueOf(sixNum[i]));
            i++;
        }

        twoSec = (int) (Math.random() * 8) + 1;
        twoSectionBall.setText(String.valueOf(twoSec));

        start.setText("START");
    }

    private void extractLotteryBalls() {
        lotteryBalls = new TextView[6];
        lotteryBalls[0] = (TextView) findViewById(R.id.firstBall);
        lotteryBalls[1] = (TextView) findViewById(R.id.secondBall);
        lotteryBalls[2] = (TextView) findViewById(R.id.thirdBall);
        lotteryBalls[3] = (TextView) findViewById(R.id.fourthBall);
        lotteryBalls[4] = (TextView) findViewById(R.id.fifthBall);
        lotteryBalls[5] = (TextView) findViewById(R.id.sixthBall);
    }
}