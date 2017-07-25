package com.example.user.exercise4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity
{

    EditText firstName;
    EditText lastName;
    public static final String PREFS_NAME = "MyAppSettings";
    SharedPreferences settings;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = (EditText) (findViewById(R.id.first_Name));
        lastName = (EditText) (findViewById(R.id.last_Name));

        settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = settings.edit();
        //Writing shared Preferences
        editor.putString("key", "some value");
        editor.putString("first", "FIRST NAME");
        editor.putString("last", "LAST NAME");
        editor.commit();//saves previous command

        String value = settings.getString("key", "");
        Toast.makeText(this,value, Toast.LENGTH_SHORT).show();
    }

    public void saveName (View view)
    {
        editor.putString("first", firstName.getText().toString());
        editor.putString("last", lastName.getText().toString());
        editor.commit();

        firstName.setText("");
        lastName.setText("");
    }

    public void showfname(View view)
    {
        String value = settings.getString("first", "");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    public void showlname(View view)
    {
        String value = settings.getString("last", "");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }


    public void updater(View view)
    {
        String firstValue = settings.getString("first", "");
        String lastValue = settings.getString("last", "");
        firstName.setText(firstValue);
        lastName.setText(lastValue);
    }
}
