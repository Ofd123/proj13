package com.example.proj13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    TextView tvx1, tvx2;
    EditText edA, edB, edC;
    double a, b, c, ans1,ans2;
    String inputA,inputB,inputC;
    private static final int secretCode = 123;

    //----------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvx1 = (TextView) findViewById(R.id.textView4);
        tvx2 = (TextView) findViewById(R.id.textView5);
        tvx1.setVisibility(View.INVISIBLE);
        tvx2.setVisibility(View.INVISIBLE);
        edA = (EditText) findViewById(R.id.editTextNumberDecimal);
        edB = (EditText) findViewById(R.id.editTextNumberDecimal2);
        edC = (EditText) findViewById(R.id.editTextNumberDecimal3);
    }
    protected void onActivityResult(int source, int result, Intent data)
    {
        super.onActivityResult(source, result, data);
        if (source == secretCode)
        {
            if (result == Activity.RESULT_OK)
            {
                if (data != null)
                {
                    ans1 = data.getDoubleExtra("x1",0);
                    ans2 = data.getDoubleExtra("x2",0);
                    tvx1.setVisibility(View.VISIBLE);
                    tvx2.setVisibility(View.VISIBLE);
                    tvx1.setText("X1 =" + ans1);
                    tvx2.setText("X2 =" + ans2);
                }
            }
        }
    }

    //----------------------------------------------------------------
    public boolean valid(String input)
    {
        if (input.isEmpty())
        {
            return false;
        }
        else if (input.length() == 1)
        {
            char firstChar = input.charAt(0);
            if (firstChar == '.' || firstChar == '-')
            {
                return false;
            }
        }
        else
        {
            char firstChar = input.charAt(0);
            char lastChar = input.charAt(input.length() - 1);
            if (lastChar == '.' || lastChar == '-' || firstChar == '.')
            {
                return false;
            }
        }
        return true;
    }
    //----------------------------------------------------------------

    public void generate(View view)
    {
        Random rnd = new Random();
        a = rnd.nextInt(1000) - 500;
        b = rnd.nextInt(1000) - 500;
        c = rnd.nextInt(1000) - 500;
        edA.setText(String.valueOf(a));
        edB.setText(String.valueOf(b));
        edC.setText(String.valueOf(c));
    }
    //----------------------------------------------------------------



    public void moveToSecView(View view)
    {
        inputA = edA.getText().toString();
        inputB = edB.getText().toString();
        inputC = edC.getText().toString();
        if ((valid(inputA)) && (valid(inputB)) && (valid(inputC)))
        {
            a = Double.parseDouble(inputA);
            b = Double.parseDouble(inputB);
            c = Double.parseDouble(inputC);
            Intent warp = new Intent(this, theMathFormulaCalculator.class);
            warp.putExtra("a value", a);
            warp.putExtra("b value", b);
            warp.putExtra("c value", c);
            startActivityForResult(warp, secretCode);
        }
    }


}