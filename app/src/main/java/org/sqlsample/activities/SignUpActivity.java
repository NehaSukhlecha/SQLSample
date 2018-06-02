package org.sqlsample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.sqlsample.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText editText_email,editText_password,editText_fName,editText_lName,editText_mobile;
    private Button button_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editText_email = findViewById(R.id.editText_email);
        editText_password= findViewById(R.id.editText_password);
        editText_lName = findViewById(R.id.editText_lName);
        editText_fName= findViewById(R.id.editText_fName);
        editText_mobile = findViewById(R.id.editText_mobile);
        button_sign_up = findViewById(R.id.button_sign_up);


        button_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
