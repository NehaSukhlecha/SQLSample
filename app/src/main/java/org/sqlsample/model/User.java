package org.sqlsample.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.sqlsample.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String mobile;
    private String password;
    private Context context;
    private DataBaseHelper dataBaseHelper;

    public User() {
    }

    public User(Context context) {
        this.context = context;
        dataBaseHelper = new DataBaseHelper(context);
    }

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE User ( id INTEGER PRIMARY KEY AUTOINCREMENT, first_name VARCHAR, last_name VARCHAR, email VARCHAR,mobile VARCHAR, password VARCHAR)";


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long insertUser(ContentValues values) {
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        long id = db.insert("User", null, values);
        db.close();
        return id;
    }
    public boolean isValidLogin(String email, String password) {
        SQLiteDatabase database = dataBaseHelper.getReadableDatabase();

        Cursor cursor = database
                .rawQuery("SELECT * From User where email= '"+email+"' And password='"+password+"'",null);

        if (cursor.moveToFirst()) {
            first_name = cursor.getString(1);
            cursor.close();
            database.close();
            return true;
        } else {
            cursor.close();
            database.close();
            return false;
        }
    }

    public ArrayList<User> getallUsers() {

        ArrayList<User> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM User";
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getString(cursor.getColumnIndex("id")));
                user.setFirst_name(cursor.getString(cursor.getColumnIndex("first_name")));
                user.setLast_name(cursor.getString(cursor.getColumnIndex("last_name")));
                user.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                user.setMobile(cursor.getString(cursor.getColumnIndex("mobile")));
                users.add(user);
            } while (cursor.moveToNext());
        }
        db.close();
        return users;
    }
}
