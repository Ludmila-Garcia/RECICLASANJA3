package com.example.reciclasanja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button login_btn_cadastrar;

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private FireBaseQuery firebaseQuery = new FireBaseQuery();
    private FirebaseAuth auth;
    private Button btn_entrar;
    private EditText email,senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        login_btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);

        login_btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cadastrarCliente(email.getText().toString().trim(), senha.getText().toString().trim());
                Intent it = new Intent(MainActivity.this, tela_validar_login.class);
                startActivity(it);
            }
        });
    }

    private void cadastrarCliente(String email, String senha) {

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference().child("Cliente");

                            ClienteModel c = new ClienteModel();
                            c.setEmail(email);
                            c.setSenha(senha);

                            databaseReference.setValue(c);



                    }



    }


