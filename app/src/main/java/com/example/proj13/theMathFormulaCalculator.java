package com.example.proj13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class theMathFormulaCalculator extends AppCompatActivity
{
    Intent get = getIntent();
    int a,b,c;
    double X1,X2;
    TextView ans1,ans2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_math_formula_calculator);
        ans1 = (TextView) findViewById(R.id.textView6);
        ans2 = (TextView) findViewById(R.id.textView7);
        a = get.getIntExtra("a value", 1);
        b = get.getIntExtra("b value", 1);
        c = get.getIntExtra("c value", 1);
        X1 = (-b + Math.sqrt(b*b - 4 * a *b))/(2*a);
        X2 = (-b - Math.sqrt(b*b - 4 * a *b))/(2*a);
        ans1.setText(String.valueOf(X1));
        ans2.setText(String.valueOf(X2));
    }
}