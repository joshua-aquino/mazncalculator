package com.example.calculatortutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText calculation, result;
    private String curr, res;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDV, btnMT, btnSB,
    btnAD, btnPR, btnEQ, btnAC, btnBS;
    private boolean periodInserted, operatorInserted;
    private int operatorPosition;
    private void backspace() {
        curr = curr.substring(0, curr.length() - 1);
    }
    private void insertOperator(String o) {
        if (!curr.isEmpty()) {
            if (!operatorInserted) {
                if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                    backspace();
                }
                curr = curr + o;
                operatorInserted = true;
                operatorPosition = curr.length() - 1;
                periodInserted = false;
                displayOne();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);
        curr = "";
        res = "";
        periodInserted = false;
        operatorInserted = false;
        operatorPosition = -1;
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAC = (Button) findViewById(R.id.btnAC);
        btnBS = (Button) findViewById(R.id.btnBS);
        btnDV = (Button) findViewById(R.id.btnDV);
        btnMT = (Button) findViewById(R.id.btnMT);
        btnSB = (Button) findViewById(R.id.btnSB);
        btnAD = (Button) findViewById(R.id.btnAD);
        btnPR = (Button) findViewById(R.id.btnPR);
        btnEQ = (Button) findViewById(R.id.btnEQ);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "0";
                displayOne();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "1";
                displayOne();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "2";
                displayOne();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "3";
                displayOne();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "4";
                displayOne();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "5";
                displayOne();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "6";
                displayOne();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "7";
                displayOne();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "8";
                displayOne();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "9";
                displayOne();
            }
        });
        btnPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (periodInserted == false) {
                    if (operatorPosition != -1) {
                        if (operatorPosition == curr.length() - 1) {
                            curr = curr + "0.";
                        } else {
                            curr = curr + ".";
                        }
                    } else if (curr.isEmpty()) {
                        curr = curr + "0.";
                    } else {
                        curr = curr + ".";
                    }
                    periodInserted = true;
                    displayOne();
                }
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = "";
                periodInserted = false;
                operatorInserted = false;
                operatorPosition = -1;
                displayOne();
            }
        });
        btnBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                        periodInserted = false;
                        displayOne();
                    } else if (curr.substring(curr.length() - 1,
                            curr.length()).matches(".*[/*-+].*")) {
                        backspace();
                        operatorInserted = false;
                        operatorPosition = -1;
                        periodInserted = (curr.contains(".") ? true : false);
                        displayOne();
                    } else {
                        backspace();
                        displayOne();
                    }
                }
            }
        });
        btnDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertOperator("/");
            }
        });
        btnMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertOperator("*");
            }
        });
        btnSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertOperator("-");
            }
        });
        btnAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertOperator("+");
            }
        });
        btnEQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operatorInserted && !(operatorPosition == curr.length() - 1)) {
                    String [] tokens = {curr.substring(0, operatorPosition),
                            curr.substring(operatorPosition, operatorPosition + 1),
                            curr.substring(operatorPosition + 1, curr.length())};
                    switch (tokens[1].charAt(0)) {
                        case '/':
                            res = Double.toString(Double.parseDouble(tokens[0]) /
                                    Double.parseDouble(tokens[2]));
                            break;
                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0]) *
                                    Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) -
                                    Double.parseDouble(tokens[2]));
                            break;
                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) +
                                    Double.parseDouble(tokens[2]));
                            break;
                    }
                    displayTwo();
                }
            }
        });
    }

    public void displayOne() {
        calculation.setText(curr);
    }

    public void displayTwo() {
        result.setText(res);
    }
}