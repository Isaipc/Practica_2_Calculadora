package com.app.practica_2_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int SUMA = 0;
    public static final  int RESTA = 1;
    public static final  int PRODUCTO = 2;
    public static final  int DIVISION  = 3;

    Button button;
    Spinner spinner;
    EditText et_1;
    EditText et_2;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupComponents();
    }


    protected void setupComponents()
    {
        button = findViewById(R.id.ok_button);
        spinner = findViewById(R.id.spinner_operations);
        et_1 = findViewById(R.id.et_num_1);
        et_2 = findViewById(R.id.et_num_2);
        tv_result = findViewById(R.id.tv_result);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                operar();
            }
        });
    }

    protected void operar()
    {
        try
        {

            double n1 = Double.parseDouble(et_1.getText().toString());
            double n2 = Double.parseDouble(et_2.getText().toString());
            double result = 0f;

            switch (spinner.getSelectedItemPosition())
            {
                case SUMA:
                    result=n1+n2;
                    break;
                case RESTA:
                    result=n1-n2;
                    break;
                case PRODUCTO:
                    result=n1*n2;
                    break;
                case DIVISION:
                    result=n1/n2;
                    break;
            }

            tv_result.setText(String.valueOf(result));
        }catch(NumberFormatException nfe)
        {
            tv_result.setText(String.valueOf(0));
        }
    }
}
