package it.stockato.its.niukoapp.Pages;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import it.stockato.its.niukoapp.R;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    Button loginButton;
    EditText mailField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        loginButton = findViewById(R.id.loginButton);
        mailField = findViewById(R.id.mailField);
        passwordField = findViewById(R.id.passwordField);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = mailField.getText().toString();
                String password = passwordField.getText().toString();

                signIn(mail, password);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
    }

    private void makeToast(String m){
        Toast.makeText(this, m,Toast.LENGTH_SHORT).show();
    }

    private void signIn(String email, String password) {
        Log.d("yo", "signIn:" + email);
        if (!validateForm()) {
            return;
        }


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success
                            Log.d("yo", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails
                            Log.w("yo", "signInWithEmail:failure", task.getException());
                            makeToast("Fallito");
                        }
                    }
                });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mailField.setError("Required.");
            valid = false;
        } else {
            mailField.setError(null);
        }

        String password = passwordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            passwordField.setError("Required.");
            valid = false;
        } else {
            passwordField.setError(null);
        }

        return valid;
    }
}
