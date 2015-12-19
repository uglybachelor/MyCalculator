package com.a.zzh.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private Button bt_0;
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button bt_4;
    private Button bt_5;
    private Button bt_6;
    private Button bt_7;
    private Button bt_8;
    private Button bt_9;
    private Button bt_dot;
    private Button bt_c;
    private Button bt_del;
    private Button bt_divide;
    private Button bt_multiply;
    private Button bt_minus;
    private Button bt_plus;
    private Button bt_equal;

    private EditText edt;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_0 = (Button) findViewById(R.id.bt_0);
        bt_1 = (Button) findViewById(R.id.bt_1);
        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);
        bt_4 = (Button) findViewById(R.id.bt_4);
        bt_5 = (Button) findViewById(R.id.bt_5);
        bt_6 = (Button) findViewById(R.id.bt_6);
        bt_7 = (Button) findViewById(R.id.bt_7);
        bt_8 = (Button) findViewById(R.id.bt_8);
        bt_9 = (Button) findViewById(R.id.bt_9);
        bt_dot = (Button) findViewById(R.id.bt_dot);
        bt_c = (Button) findViewById(R.id.bt_C);
        bt_del = (Button) findViewById(R.id.bt_DEL);
        bt_divide = (Button) findViewById(R.id.bt_Divide);
        bt_multiply = (Button) findViewById(R.id.bt_Multiply);
        bt_minus = (Button) findViewById(R.id.bt_Minus);
        bt_plus = (Button) findViewById(R.id.bt_Plus);
        bt_equal = (Button) findViewById(R.id.bt_Equal);

        edt = (EditText) findViewById(R.id.editText);

        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_dot.setOnClickListener(this);
        bt_c.setOnClickListener(this);
        bt_del.setOnClickListener(this);
        bt_divide.setOnClickListener(this);
        bt_multiply.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_plus.setOnClickListener(this);
        bt_equal.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String str = edt.getText().toString();


        switch (v.getId()){
            case R.id.bt_0:
            case R.id.bt_1:
            case R.id.bt_2:
            case R.id.bt_3:
            case R.id.bt_4:
            case R.id.bt_5:
            case R.id.bt_6:
            case R.id.bt_7:
            case R.id.bt_8:
            case R.id.bt_9:
            case R.id.bt_dot:


                edt.setText(str + ((Button) v ).getText());
                break;
            case R.id.bt_C:
                edt.setText("");
                break;
            case R.id.bt_DEL:
                if(str != null && !str.equals("")){
                    edt.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.bt_Divide:
            case R.id.bt_Multiply:
            case R.id.bt_Minus:
            case R.id.bt_Plus:
                edt.setText(str + " " + ((Button) v ).getText() + " " );
                break;
            case R.id.bt_Equal:
                getResult();
        }

    }

    private void getResult(){

        String input = edt.getText().toString();

        if(input == null || input.equals("")){
            return;
        }

        if(!input.contains(" ")){
            return;
        }
        else
        {
            String s1 = input.substring(0, input.indexOf(" "));
            String op = input.substring(input.indexOf(" ")+1, input.indexOf(" ")+2);
            String s2 = input.substring(input.indexOf(" ")+3);

            double calResult = 0;

            if(!s1.equals("")&&!s2.equals("")){
                Double d1 = Double.parseDouble(s1);
                Double d2 = Double.parseDouble(s2);

                if(op.equals("+")){
                    calResult = d1+d2;
                }else if(op.equals("-")){
                    calResult = d1-d2;
                }else if(op.equals("*")){
                    calResult = d1*d2;
                }else if(op.equals("/")){
                    if(d2 == 0){
                        calResult = 0;
                    }
                    calResult = d1/d2;
                }

                if(!s1.contains(".")&&!s2.contains(".")){
                    int r = (int) calResult;
                    edt.setText(r + " ");
                }else{
                    edt.setText(calResult + " ");
                }
            }else if(!s1.equals("")&&s2.equals("")){
                edt.setText(input);
            }else if(s1.equals("")&&!s2.equals("")){

                Double d2 = Double.parseDouble(s2);
                if(op.equals("+")){
                    calResult = 0+d2;
                }else if(op.equals("-")){
                    calResult = 0-d2;
                }else if(op.equals("×")){
                    calResult = 0;
                }else if(op.equals("÷")){
                    calResult = 0;
                }
                if(!s1.contains(".")&&!s2.contains(".")){
                    int r = (int) calResult;
                    edt.setText(r + " ");
                }else{
                    edt.setText(calResult + " ");
                }
            }else {
                edt.setText(input);
            }


        }
    }
}
