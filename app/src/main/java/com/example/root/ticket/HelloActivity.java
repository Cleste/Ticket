package com.example.root.ticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {
    private TextView num1;
    private TextView count;
    private Button lButton;
    private Button rButton;
    public int ran = 900000;
    public int num;
    public int sum1, sum2;
    public int points = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        num1 = findViewById(R.id.Num);
        randomNum();
        addListenerOnButton();
    }
    public boolean Happy(){
        sum1 = 0;
        sum2 = 0;
        while(num>=1000){
            sum1 += num % 10;
            num /= 10;
        }
        while(num!=0){
            sum2 += num % 10;
            num /= 10;
        }
        return sum1 == sum2;
    }
    public void randomNum() {
        Random rand = new Random();
        num = 100000 + rand.nextInt(ran);
        num1.setText(String.valueOf(num));
    }
    public void addListenerOnButton (){
        lButton = findViewById(R.id.LButton);
        rButton = findViewById(R.id.RButton);
        count = findViewById(R.id.Count);
        rButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(Happy()){
                            points += 1;
                            count.setText(String.valueOf(points));
                        }
                        randomNum();
                    }
                }
        );
        lButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(!Happy()){
                            points += 1;
                            count.setText(String.valueOf(points));
                        }
                        randomNum();
                    }
                }
        );
    }
}
