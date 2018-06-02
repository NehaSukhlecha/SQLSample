package org.sqlsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.sqlsample.activities.SignUpActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editText_email,editText_password;
    private TextView textView_signUp;
    private Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_email = findViewById(R.id.editText_email);
        editText_password= findViewById(R.id.editText_password);
        textView_signUp= findViewById(R.id.textView_signUp);
        String strSignUp = getResources().getString(R.string.signUp);
        textView_signUp.setText(Html.fromHtml(strSignUp));
        button_login  = findViewById(R.id.button_login);


        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        textView_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
