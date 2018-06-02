package org.sqlsample.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.sqlsample.LoginActivity;
import org.sqlsample.R;
import org.sqlsample.adapter.UserAdapter;
import org.sqlsample.model.User;

import java.util.ArrayList;

public class UserinfoActivity extends AppCompatActivity {

    private ListView user_info_list;
    private UserAdapter userAdapter;
    private ArrayList<User> userArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_list);
        try {

            user_info_list = findViewById(R.id.list_user_info);


            userArrayList = new User(UserinfoActivity.this).getallUsers();

            userAdapter = new UserAdapter(userArrayList, UserinfoActivity.this);
            user_info_list.setAdapter(userAdapter);



            user_info_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    User user = userArrayList.get(i);
                    Intent intent = new Intent(UserinfoActivity.this,UserinfoActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
