package org.sqlsample.activities;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.sqlsample.R;
import org.sqlsample.model.User;

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
                ContentValues values = new ContentValues();
                values.put("first_name",editText_fName.getText().toString().trim());
                values.put("last_name",editText_lName.getText().toString().trim());
                values.put("password",editText_password.getText().toString().trim());
                values.put("email",editText_email.getText().toString().trim());
                values.put("mobile",editText_mobile.getText().toString().trim());
                Long id = new User(SignUpActivity.this).insertUser(values);
                if(id>0){
                    Toast.makeText(SignUpActivity.this,"User Created !!!",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

    }
}
