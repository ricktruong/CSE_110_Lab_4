package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    public void onDestroy() {
        saveProfile();
        super.onDestroy();
    }

    public void onGoBackClicked(View view) {
        finish();
    }

    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);

        // Get name and status Strings from SharedPreferences Hashmap
        String name = preferences.getString("name", "");
        String status = preferences.getString("status", "");

        // Update name and status EditTexts from name and status Strings
        EditText name_edittext = (EditText) findViewById(R.id.name_textview);
        EditText status_edittext = (EditText) findViewById(R.id.status_textview);

        name_edittext.setText(name);
        status_edittext.setText(status);

    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Get name and status Strings from EditTexts
        EditText name_edittext = (EditText) findViewById(R.id.name_textview);
        EditText status_edittext = (EditText) findViewById(R.id.status_textview);

        String name = name_edittext.getText().toString();
        String status = status_edittext.getText().toString();

        // Update SharedPreferences Hashmap
        editor.putString("name", name);
        editor.putString("status", status);

        editor.apply();
    }
}