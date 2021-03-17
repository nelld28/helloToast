package com.example.helloConstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mResetButton;
    private Button mCountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
        mResetButton = findViewById(R.id.button_zero);
        mCountButton = findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Log.i("INFO", "Show Toast clicked");

        Toast toast = Toast.makeText(this, "Hello", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;

        if (mShowCount != null) {
            mShowCount.setText(String.format(Locale.ENGLISH, "%d", mCount));
        }
        mResetButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mResetButton.setClickable(true);

        switch (mCount % 2){
            case 0:
                view.setBackgroundColor(Color.MAGENTA);
                break;
            case 1:
                view.setBackgroundColor(Color.GREEN);
                break;
            default: break;
        }
    }

    public void resetZero(View view) {
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));
        view.setClickable(false);
        view.setBackgroundColor(Color.GRAY);
        mCountButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }
}