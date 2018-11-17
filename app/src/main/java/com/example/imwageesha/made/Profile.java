package com.example.imwageesha.made;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Other.Constants;

public class Profile extends AppCompatActivity {

    TextView tvemail,tvfullname;
    SharedPreferences sharedPref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sharedPref = getSharedPreferences(Constants.USER_PREF,Context.MODE_PRIVATE);
        tvemail = (TextView) findViewById(R.id.tvemail);
        tvfullname = (TextView) findViewById(R.id.tvfullname);

        String fname = sharedPref.getString(Constants.USER_FNAME,"N/A");
        String lname = sharedPref.getString(Constants.USER_LNAME,"N/A");
        String email = sharedPref.getString(Constants.USER_EMAIL,"N/A");

        tvfullname.setText(fname+lname);
        tvemail.setText(email);
    }
    public void logout(View v) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();
        Intent inte = new Intent(Profile.this,MainActivity.class);
        startActivity(inte);
        finish();
    }
}


