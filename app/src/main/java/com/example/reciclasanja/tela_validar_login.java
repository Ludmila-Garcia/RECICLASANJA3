package com.example.reciclasanja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class tela_validar_login extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private FireBaseQuery firebaseQuery = new FireBaseQuery();
    private FirebaseAuth auth;
    private Button btn_entrar;
    private EditText e,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_validar_login);
        e = (EditText)findViewById(R.id.email);
        s = (EditText)findViewById(R.id.senha);
        btn_entrar = findViewById(R.id.button1);
        inicializarFirebase();

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sn = String.valueOf(s.getText());
                String em = String.valueOf(e.getText());
                loginFirebase(em,sn);
            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(tela_validar_login.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth=FireBaseConexao.getFirebaseAuth();

    }

    private void loginFirebase(final String strEmail, final String strSenha) {

        auth.createUserWithEmailAndPassword(strEmail,strSenha)
        .addOnCompleteListener(tela_validar_login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Intent intent = new Intent(tela_validar_login.this, MainActivity.class);
                    startActivity(intent);

                    altertToast("Login Cadastrado com sucesso");
                }
            }
        });

        auth.signInWithEmailAndPassword(strEmail, strSenha)
                .addOnCompleteListener(tela_validar_login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Intent intent = new Intent(tela_validar_login.this,MainActivity.class);
                            startActivity(intent);
                        }else{
                            altertToast("E-mail ou senha inválidos!");
                        }
                    }
                });

    }
//    firebaseDatabase = FirebaseDatabase.getInstance();
//                            firebaseDatabase.getReference().orderByChild("email").equalTo(strEmail)
//                                    .addValueEventListener(new ValueEventListener(){
//        @Override
//        public void onDataChange(DataSnapshot dSnp)
//        {
//            for(DataSnapshot objSnp : dSnp.getChildren())
//            {
//                ClienteModel c = objSnp.getValue(ClienteModel.class);
//                String idUsuario = c.getIdUsuario();
//
//                if(!strEmail.trim().equals(c.getEmail()) || !strSenha.trim().equals(strSenha)){
//
//                    altertToast("E-mail ou senha inválidos!");
//                    return;
//                }else{
//                    Intent intent = new Intent(tela_validar_login.this,MainActivity.class);
//                    startActivity(intent);
//                }
//                //VERIFICA SE O USUÁRIO ALTEROU A SENHA
//
//
//                break;
//            }
//        }
//        @Override
//        public void onCancelled(DatabaseError databaseError) {}
//    });
//}else{ altertToast("E-mail ou senha inválidos!"); }

    private void altertToast(String s) {
        Toast.makeText(tela_validar_login.this, s, Toast.LENGTH_LONG).show();
    }
}

