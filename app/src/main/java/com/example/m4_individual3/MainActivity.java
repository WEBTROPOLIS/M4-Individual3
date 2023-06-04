package com.example.m4_individual3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView screen1 = findViewById(R.id.Screen1);
        TextView screen2 = findViewById(R.id.Screen2);
        EditText numUser = findViewById(R.id.numUser);
        Button mas = findViewById(R.id.mas);
        Button resta = findViewById(R.id.resta);
        Button div = findViewById(R.id.div);
        Button por = findViewById(R.id.por);
        Button igual = findViewById(R.id.igual);
        Button exit = findViewById(R.id.exit);
        Button c = findViewById(R.id.c);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen1.setText("");
                screen2.setText("");
                numUser.setText("");
            }
        });
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = numUser.getText().toString();
                if (!txt.isEmpty()){
                    screen1.setText(txt);
                    screen2.setText("+ ");
                    numUser.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"Debe Ingresar un Valor", Toast.LENGTH_LONG).show();
                }

            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = numUser.getText().toString();
                if (!txt.isEmpty()){
                    screen1.setText(txt);
                    screen2.setText("- ");
                    numUser.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"Debe Ingresar un Valor", Toast.LENGTH_LONG).show();

                }

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = numUser.getText().toString();
                if (!txt.isEmpty()){
                    screen1.setText(txt);
                    screen2.setText("/ ");
                    numUser.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"Debe Ingresar un Valor", Toast.LENGTH_LONG).show();

                }


            }
        });

        por.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = numUser.getText().toString();
                if (!txt.isEmpty()){
                    screen1.setText(txt);
                    screen2.setText("* ");
                    numUser.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"Debe Ingresar un Valor", Toast.LENGTH_LONG).show();

                }

            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String num1 = screen1.getText().toString();

            String op = screen2.getText().toString().trim();
            String num2 = numUser.getText().toString();
            if (!num2.isEmpty()) {

                double resultado = 0;
                boolean flagDivCero = true;
                switch (op) {
                    case "+":
                        resultado = Double.parseDouble(num1) + Double.parseDouble(num2);
                        screen2.setText("+" + num2.toString());
                        break;

                    case "-":
                        resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
                        screen2.setText("-" + num2.toString());
                        break;

                    case "*":
                        resultado = Double.parseDouble(num1) * Double.parseDouble(num2);
                        screen2.setText("*" + num2.toString());
                        break;

                    case "/":
                        if (!num2.equals("0")) {
                            resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
                            screen2.setText("/" + num2.toString());
                        } else {
                            flagDivCero = false;
                            Toast.makeText(MainActivity.this, "No se puede dividir por cero", Toast.LENGTH_LONG).show();
                        }
                        break;


                }
                if (flagDivCero) {
                    numUser.setText(String.valueOf(resultado));
                } else {
                    numUser.setText("Error al dividir por cero");
                }
            }else{
                Toast.makeText(MainActivity.this,"Debe Ingresar un Valor", Toast.LENGTH_LONG).show();

            }
            }
        });
    }
}