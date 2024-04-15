package com.example.proj13;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class theMathFormulaCalculator extends AppCompatActivity
{
    double a, b, c;
    double X1, X2;
    TextView ans1, ans2;
    ImageView showFunc;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_math_formula_calculator);

        ans1 = findViewById(R.id.textView6);
        ans2 = findViewById(R.id.textView7);
        showFunc =findViewById(R.id.imageView2);
        showFunc.setImageResource(R.drawable.ic_launcher_background);

        Intent secPhase = getIntent();
        a = secPhase.getDoubleExtra("a value", 0);
        b = secPhase.getDoubleExtra("b value", 0);
        c = secPhase.getDoubleExtra("c value", 1);

        X1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        X2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

        ans1.setText("ans1 =" + X1);
        ans2.setText("ans2 =" + X2);

        secPhase.putExtra("x1",X1);
        secPhase.putExtra("x2",X2);
        setResult(RESULT_OK, secPhase);
        ShowFuncPic(a, b, c);
    }

    private void ShowFuncPic(double a, double b, double c)
    {
        if (a > 0)
        {
            if (b > 0)
            {
                showFunc.setImageResource(R.drawable.func4);
            }
            else if (b < 0)
            {
                showFunc.setImageResource(R.drawable.func5);
            }
            else
            {
                showFunc.setImageResource(R.drawable.func1);
            }
        }
        if (a < 0)
        {
            if (b > 0)
            {
                showFunc.setImageResource(R.drawable.func3);
            }
            else if (b < 0)
            {
                showFunc.setImageResource(R.drawable.func6);
            }
            else
            {
                showFunc.setImageResource(R.drawable.func2);
            }
        }
    }

    public void returned(View view)
    {

        finish();

    }
}
