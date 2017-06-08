package com.bones.balancecalculator;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    KeyboardView kv;
    EditText income,outcome;
    TextView balance;
    FloatingActionButton calculate,clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleIME actionListener = new SimpleIME(this);

        //inflating keyboard
        kv = (KeyboardView) findViewById(R.id.KeyView);
        Keyboard keyboard = new Keyboard(this, R.layout.keyboard);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(actionListener);

        income = (EditText) findViewById(R.id.txtIncome);
        outcome = (EditText) findViewById(R.id.txtOutcome);
        balance = (TextView) findViewById(R.id.txtBalance);

        //Disabling system keyboard
        income.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                EditText edittext = (EditText) v;
                int inType = edittext.getInputType();       // Backup the input type
                edittext.setInputType(InputType.TYPE_NULL); // Disable standard keyboard
                edittext.onTouchEvent(event);               // Call native handler
                edittext.setInputType(inType);              // Restore input type
                return true; // Consume touch event
            }
        });

        //Disabling system keyboard
        outcome.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                EditText edittext = (EditText) v;
                int inType = edittext.getInputType();       // Backup the input type
                edittext.setInputType(InputType.TYPE_NULL); // Disable standard keyboard
                edittext.onTouchEvent(event);               // Call native handler
                edittext.setInputType(inType);              // Restore input type
                return true; // Consume touch event
            }
        });

        income.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //cursor start from the last char
                int count = editable.length();
                income.setSelection(count);
            }
        });

        outcome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //make cursor start from the last char
                int count = editable.length();
                outcome.setSelection(count);
            }
        });


        calculate = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calculating balance
                String txtincome = income.getText().toString();
                String txtoutcome = outcome.getText().toString();
                int balint;

                //Checking the text field
                if(txtincome.isEmpty() || txtoutcome.isEmpty()){
                    Toast.makeText(MainActivity.this, "Field is empty", Toast.LENGTH_SHORT).show();
                } else {
                    int inint = Integer.parseInt(txtincome);
                    int outint = Integer.parseInt(txtoutcome);

                    balint = inint - outint;

                    balance.setText("Balance : " + balint);
                }
            }
        });

        clear = (FloatingActionButton) findViewById(R.id.floatingActionButtonHapus);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Clear all text
                income.setText("");
                outcome.setText("");
                balance.setText("Balance : ");
            }
        });


    }





}
