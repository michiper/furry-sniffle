package it.stockato.its.myniuko.Pages;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import it.stockato.its.myniuko.DialogFragment;
import it.stockato.its.myniuko.R;
/*
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
*/
public class Login extends AppCompatActivity implements DialogFragment.IDialogFragment {
    EditText ed_username, ed_password;
    Button btn_login;
    CheckBox ricordaCredenziali;
    String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        btn_login = findViewById(R.id.btn_login);
        ricordaCredenziali = findViewById(R.id.ricorda_credenziali);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = ed_username.getText().toString();
                password = ed_password.getText().toString();

                /*
                if(username.isEmpty() || password.isEmpty()){
                    DialogFragment vDialog = new DialogFragment("Attenzione","Inserisci tutti i dati necessari.", 1);
                    vDialog.show(getFragmentManager(), "dialog");
                }else {

                    OkHttpClient client = new OkHttpClient();
                    String url = "http://kennedysql.altervista.org/api_kennedy/login.php";
                    RequestBody body = new FormBody.Builder().add("email", username).add("password", password).build();
                    Request request = new Request.Builder().url(url).post(body).build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, final Response response) throws IOException {
                            if(response.isSuccessful()){
                                final String myResponse = response.body().string();
                                Login.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            JSONObject json = new JSONObject(myResponse);
                                            String ID = json.getString("ID");
                                            switch (ID){
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
                                            }

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        }
                    });
                    /*if (username.equals("niuko") && password.equals("psw")) {
                        Intent intent = new Intent(Login.this, HomePage.class);
                        startActivity(intent);
                    } else {
                        DialogFragment vDialog = new DialogFragment("Attenzione", "Email o password sbagliata", 1);
                        vDialog.show(getFragmentManager(), "dialog");
                                        }
                       //



                }
*/
                Intent intent = new Intent(Login.this, HomePage.class);
                startActivity(intent);
            }
        });


    }

    //metodo del dialog fragment
    @Override
    public void onResponse(boolean response) {

    }
}
