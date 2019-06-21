package it.stockato.its.myniuko.Pages;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import it.stockato.its.myniuko.DialogFragment;
import it.stockato.its.myniuko.R;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Login extends AppCompatActivity implements DialogFragment.IDialogFragment {


    TextInputEditText mEmailEditText;
    TextInputEditText mPasswordEditText;

    CheckBox mRememberPassword;
    TextView mForgottenPassword;

    MaterialButton mLoginButton;

    String mEmail, mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEmailEditText = findViewById(R.id.login_email_field);
        mPasswordEditText = findViewById(R.id.login_password_field);

        mRememberPassword = findViewById(R.id.login_remember_password);
        mForgottenPassword = findViewById(R.id.login_forgotten_password);

        mLoginButton = findViewById(R.id.login_login_button);


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mEmail = mEmailEditText.getText().toString();
                mPassword = mPasswordEditText.getText().toString();

                if(mEmail.isEmpty() || mPassword.isEmpty())
                {
                    DialogFragment vDialog = new DialogFragment("Attenzione","Inserisci tutti i dati necessari.", 1);
                    vDialog.show(getFragmentManager(), "dialog");
                }
                else
                {
                    OkHttpClient vClient = new OkHttpClient();
                    String url = "http://kennedysql.altervista.org/api_kennedy/login.php";
                    RequestBody vBody = new FormBody.Builder().add("email", mEmail).add("password", mPassword).build();
                    Request request = new Request.Builder().url(url).post(vBody).build();
                    vClient.newCall(request).enqueue(new Callback()
                    {
                        @Override
                        public void onFailure(Call call, IOException e)
                        {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, final Response response) throws IOException
                        {
                            if(response.isSuccessful())
                            {
                                final String myResponse = response.body().string();
                                Login.this.runOnUiThread(new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        try
                                        {
                                            JSONObject json = new JSONObject(myResponse);
                                            String ID = json.getString("ID");
                                            if(ID == "-1")
                                            {
                                                DialogFragment notSuccess = new DialogFragment("Attenzione", "Impossibile accedere, credenziali errate.", 1);
                                                notSuccess.show(getFragmentManager(), "dialog");
                                            }
                                            else
                                            {
                                                Intent mIntent = new Intent(Login.this, HomePage.class);
                                                Bundle mBundle = new Bundle();
                                                mBundle.putString("id", String.valueOf(ID));
                                                mIntent.putExtras(mBundle);
                                                startActivity(mIntent);
                                            }
                                        }


                                            /*switch (ID)
                                            {
                                                case "1":
                                                    Intent intent = new Intent(Login.this, HomePage.class);
                                                    startActivity(intent);
                                                    break;

                                                case "-1":
                                                    DialogFragment notSuccess = new DialogFragment("Attenzione", "Impossibile accedere, credenziali errate.", 1);
                                                    notSuccess.show(getFragmentManager(), "dialog");
                                                    break;

                                                default:
                                                    DialogFragment failed = new DialogFragment("Attenzione", "Errore, impossibile eseguire l'operazione.", 1);
                                                    failed.show(getFragmentManager(), "dialog");
                                                    break;
                                            }*/
                                        catch (JSONException e)
                                        {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
                //Intent intent = new Intent(Login.this, HomePage.class);
                //startActivity(intent);
            }
        });


    }

    //metodo del dialog fragment
    @Override
    public void onResponse(boolean response) {

    }
}
