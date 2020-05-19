package com.example.reciclasanja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaLogin extends AppCompatActivity {

    Button login_btn_login,btn_cadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        login_btn_login = (Button) findViewById(R.id.login_btn_login);
        btn_cadastrar = findViewById(R.id.login_btn_cadastrar);

        login_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaLogin.this, tela_validar_login.class);
                startActivity(it);
            }
        });


        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }


    }


