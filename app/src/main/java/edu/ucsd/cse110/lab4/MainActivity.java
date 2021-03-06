package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onLaunchProfileClicked(View view) {
        Intent intentProfileActivity = new Intent(this, ProfileActivity.class);
        startActivity(intentProfileActivity);
    }

    public void onShowCounterClicked(View view) {
        Intent intent = new Intent(this, CounterActivity.class);

        EditText maxCountView = findViewById(R.id.max_count_view);
        String maxCountStr = maxCountView.getText().toString();

        Optional<Integer> maybeMaxCount = Utilities.parseCount(maxCountStr);

        // Check if the integer is parse correctly
        if (!maybeMaxCount.isPresent()) {
            // If not, show an error, and then return
            Utilities.showAlert(this, "Invalid input. Inputted text is not an integer!");
            return;
        }

        // Get the integer
        int maxCount = maybeMaxCount.get();

        // If it's not positive, show an error and then return
        if (maxCount <= 0) {
            Utilities.showAlert(this, "Please enter a positive number!");
            return;
        }

        // Put it in the Intent
        intent.putExtra("max_count", maxCount);
        startActivity(intent);
    }
}