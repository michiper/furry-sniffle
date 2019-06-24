package it.stockato.its.myniuko.Pages;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
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
    boolean connected = false;

    MaterialButton mLoginButton;

    String mEmail, mPassword;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fragmentManager = getSupportFragmentManager();

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
                    if(isConnected())
                    {
                        OkHttpClient vClient = new OkHttpClient();
                        String url = "http://kennedysql.altervista.org/api_kennedy/login.php";
                        RequestBody vBody = new FormBody.Builder().add("email", mEmail).add("password", mPassword).build();
                        Request vRequest = new Request.Builder().url(url).post(vBody).build();
                        vClient.newCall(vRequest).enqueue(new Callback()
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
                                                //Log.d("ID", ID);
                                                if(Integer.parseInt(ID) == -1)
                                                {
                                                    DialogFragment wrongData = new DialogFragment("Attenzione", "Impossibile accedere, credenziali errate.", 1);
                                                    wrongData.show(getFragmentManager(), "dialog");
                                                    Log.d("errore", ID);
                                                }
                                                else
                                                {
                                                    if(Integer.parseInt(ID) > 0)
                                                    {
                                                        Intent mIntent = new Intent(Login.this, HomePage.class);
                                                        Bundle mBundle = new Bundle();
                                                        mBundle.putString("id", String.valueOf(ID));
                                                        mIntent.putExtras(mBundle);
                                                        startActivity(mIntent);
                                                    }
                                                    else
                                                    {
                                                        DialogFragment notSuccess = new DialogFragment("Attenzione", "Impossibile accedere.", 1);
                                                        notSuccess.show(getFragmentManager(), "dialog");
                                                    }
                                                }
                                            }
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
                    else
                    {
                        DialogFragment noConnection = new DialogFragment("Attenzione", "Impossibile accedere. Controlla la tua connessione e riprova.", 1);
                        noConnection.show(getFragmentManager(), "dialog");
                    }

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

    public boolean isConnected(){

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        }
        else
        {
            return false;
        }

    }
}
